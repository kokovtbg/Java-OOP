package Exams.Exam11December2021.catHouse.repositories;

import Exams.Exam11December2021.catHouse.entities.toys.Toy;

public interface Repository {

    void buyToy(Toy toy);

    boolean removeToy(Toy toy);

    Toy findFirst(String type);
}
