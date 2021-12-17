package InterfacesAndAbstraction.lab.SayHelloExtend;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}
