package InterfacesAndAbstraction.lab.SayHello;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}
