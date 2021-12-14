package Exams.Exam18April2021.spaceStation.repositories;

import Exams.Exam18April2021.spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AstronautRepository implements Repository<Astronaut> {
    private List<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return this.astronauts;
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
    }
}
