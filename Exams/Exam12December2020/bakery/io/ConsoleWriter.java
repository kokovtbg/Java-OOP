package Exams.Exam12December2020.bakery.io;


import Exams.Exam12December2020.bakery.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
