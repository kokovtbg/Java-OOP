package Exams.Exam12April2020.CounterStriker.repositories;

import Exams.Exam12April2020.CounterStriker.common.ExceptionMessages;
import Exams.Exam12April2020.CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_REPOSITORY);
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        return this.models.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }
}
