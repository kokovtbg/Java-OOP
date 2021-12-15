package Exams.Exam22August2021.glacialExpedition.repositories;

import Exams.Exam22August2021.glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExplorerRepository implements Repository<Explorer> {
    private List<Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return explorers;
    }

    @Override
    public void add(Explorer explorer) {
        explorers.add(explorer);
    }

    @Override
    public boolean remove(Explorer explorer) {
        return explorers.remove(explorer);
    }

    @Override
    public Explorer byName(String name) {
        for (int i = 0; i < explorers.size(); i++) {
            if (explorers.get(i).getName().equals(name)) {
                return explorers.get(i);
            }
        }
        return null;
    }
}
