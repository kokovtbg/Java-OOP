package Exams.Exam15August2021.restaurant.repositories;

import Exams.Exam15August2021.restaurant.entities.tables.interfaces.Table;
import Exams.Exam15August2021.restaurant.repositories.interfaces.TableRepository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Map<Integer, Table> tables;

    public TableRepositoryImpl() {
        tables = new LinkedHashMap<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return tables.values();
    }

    @Override
    public void add(Table entity) {
        tables.put(entity.getTableNumber(), entity);
    }

    @Override
    public Table byNumber(int number) {
        return tables.get(number);
    }
}
