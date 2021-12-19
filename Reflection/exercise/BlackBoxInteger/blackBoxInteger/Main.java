package Reflection.exercise.BlackBoxInteger.blackBoxInteger;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();

        Method[] declaredMethods = blackBoxIntClass.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(m -> m.setAccessible(true));

        Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] commandParts = input.split("_");
            String command = commandParts[0];
            int number = Integer.parseInt(commandParts[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, number);

            System.out.println(innerValue.get(blackBoxInt));

            input = scan.nextLine();
        }
    }
}
