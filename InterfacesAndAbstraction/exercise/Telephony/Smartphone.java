package InterfacesAndAbstraction.exercise.Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        builderMethodWithStream(urls, builder, "Invalid URL!", "Browsing: ");
        return builder.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        builderMethodWithStream(numbers, builder, "Invalid number!", "Calling... ");
        return builder.toString().trim();
    }

    private void builderMethodWithStream(List<String> list, StringBuilder builder, String message, String action) {
        list.forEach(e -> {
            boolean correctSentence = true;
            for (int i = 0; i < e.length(); i++) {
                if (Character.isDigit(e.charAt(i)) && action.equals("Browsing: ")) {
                    correctSentence = false;
                    break;
                }
                if (!Character.isDigit(e.charAt(i)) && action.equals("Calling... ")) {
                    correctSentence = false;
                    break;
                }
            }
            if (correctSentence) {
                builder.append(action);
                builder.append(e);
                if (action.equals("Browsing: ")) {
                    builder.append("!");
                }
                builder.append(System.lineSeparator());
            } else {
                builder.append(message).append(System.lineSeparator());
            }
        });
    }
}
