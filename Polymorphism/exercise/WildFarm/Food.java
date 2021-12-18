package Polymorphism.exercise.WildFarm;

public abstract class Food {
    private Integer quantity;

    protected Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    protected void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
