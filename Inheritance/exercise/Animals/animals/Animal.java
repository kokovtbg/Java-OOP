package Inheritance.exercise.Animals.animals;

public class Animal {
    private String animalType;
    private String name;
    private int age;
    private String gender;
    private String sound;

    private void setAnimalType(String animalType) {
        if (animalType == null || animalType.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.animalType = animalType;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String produceSound() {
        return String.format("%s", this.sound);
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), this.name, this.age, this.gender, this.produceSound());
    }
}
