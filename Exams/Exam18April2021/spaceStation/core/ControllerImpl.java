package Exams.Exam18April2021.spaceStation.core;

import Exams.Exam18April2021.spaceStation.common.ConstantMessages;
import Exams.Exam18April2021.spaceStation.common.ExceptionMessages;
import Exams.Exam18April2021.spaceStation.models.astronauts.Astronaut;
import Exams.Exam18April2021.spaceStation.models.astronauts.Biologist;
import Exams.Exam18April2021.spaceStation.models.astronauts.Geodesist;
import Exams.Exam18April2021.spaceStation.models.astronauts.Meteorologist;
import Exams.Exam18April2021.spaceStation.models.mission.MissionImpl;
import Exams.Exam18April2021.spaceStation.models.planets.Planet;
import Exams.Exam18April2021.spaceStation.models.planets.PlanetImpl;
import Exams.Exam18April2021.spaceStation.repositories.AstronautRepository;
import Exams.Exam18April2021.spaceStation.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private static int deadAstronauts;
    private static int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        exploredPlanets = 0;
    }

    public static void addDeadAstronaut() {
        deadAstronauts++;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (int i = 0; i < items.length; i++) {
            planet.getItems().add(items[i]);
        }
        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> astronautsSuitable = astronautRepository.getModels().stream()
                .filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (astronautsSuitable.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        deadAstronauts = 0;
        MissionImpl mission = new MissionImpl();
        Planet planet = planetRepository.findByName(planetName);
        mission.explore(planet, astronautsSuitable);
        for (Astronaut astronaut : astronautRepository.getModels()) {
            for (Astronaut astronautSuitable : astronautsSuitable) {
                if (astronaut.equals(astronautSuitable)) {
                    astronaut = astronautSuitable;
                }
            }
        }
        exploredPlanets++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanets));
        builder.append(System.lineSeparator());
        builder.append(ConstantMessages.REPORT_ASTRONAUT_INFO);
        builder.append(System.lineSeparator());
        for (Astronaut astronaut : astronautRepository.getModels()) {
            builder.append(astronaut);
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
