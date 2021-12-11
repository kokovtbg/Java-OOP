package DesignPatterns.Strategy;

import DesignPatterns.Strategy.fly.CantFly;
import DesignPatterns.Strategy.fly.FlyHigh;
import DesignPatterns.Strategy.fly.FlyNearBeach;

public class Main {
    public static void main(String[] args) {
        Bird eagle = new Bird(new CantFly());
        eagle.fly();

        eagle.setStrategy(new FlyHigh());
        eagle.fly();

        eagle.setStrategy(new FlyNearBeach());
        eagle.fly();
    }
}
