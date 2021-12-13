package Exams.Exam12December2020.bakery.repositories.entities.tables;

public class InsideTable extends BaseTable {
    private static final double PRICE_PER_PERSON = 2.50;

    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
