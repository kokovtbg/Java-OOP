package DesignPatterns.BuilderPattern;

public class Pizza {
    private String name;
    private String topping;

    private int weight;
    private int diameter;

    private boolean isHot;
    private boolean hasMeat;
    private boolean containsTomatoes;

    public Pizza(){
    }

    public Pizza(String topping, int weight) {
        this.topping = topping;
        this.weight = weight;
    }

    public Pizza(int weight, String topping) {
        this.topping = topping;
        this.weight = weight;
    }



    public Pizza withWeight(int weight){
        this.weight = weight;
        return this;
    }

    public Pizza withName(String name){
        this.name = name;
        return this;
    }

    public Pizza withTopping(String topping){
        this.topping = topping;
        return this;
    }

}
