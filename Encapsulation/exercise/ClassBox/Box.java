package Encapsulation.exercise.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double calculateSurfaceArea() {
        return (this.length * this.width + this.length * this.height + this.width * this.height) * 2;
    }

    public double calculateLateralSurfaceArea() {
        return calculateSurfaceArea() - 2 * this.length * this.width;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
