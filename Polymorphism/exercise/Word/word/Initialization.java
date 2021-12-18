package Polymorphism.exercise.Word.word;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder builder) {
        return new CommandImpl(builder);
    }
}
