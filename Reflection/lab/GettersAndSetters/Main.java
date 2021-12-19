package Reflection.lab.GettersAndSetters;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> aClass = Reflection.class;
        Method[] methods = aClass.getDeclaredMethods();

        List<Method> gettersList = new ArrayList<>();
        List<Method> settersList = new ArrayList<>();

        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                gettersList.add(method);
            } else if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
                settersList.add(method);
            }
        }
        gettersList.stream().sorted(Comparator.comparing(Method::getName)).forEach(m -> System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName()));
        settersList.stream().sorted(Comparator.comparing(Method::getName)).forEach(m -> System.out.printf("%s and will set field of class %s%n", m.getName(), m.getParameterTypes()[0].getName()));
    }
}
