package Exams.Exam18April2021.spaceStation.models.mission;

import Exams.Exam18April2021.spaceStation.core.ControllerImpl;
import Exams.Exam18April2021.spaceStation.models.astronauts.Astronaut;
import Exams.Exam18April2021.spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && !planet.getItems().isEmpty()) {
                astronaut.breath();
                String item = planet.getItems().stream().findFirst().orElse(null);
                astronaut.getBag().getItems().add(item);
                planet.getItems().remove(item);
            }
            if (!astronaut.canBreath()) {
                ControllerImpl.addDeadAstronaut();
            }
        }
    }
}
