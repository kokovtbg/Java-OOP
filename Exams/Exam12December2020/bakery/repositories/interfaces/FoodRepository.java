package Exams.Exam12December2020.bakery.repositories.interfaces;

public interface FoodRepository<T> extends Repository<T> {
    T getByName(String name);
}
