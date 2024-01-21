package Homework2;

public class Dog extends Animal{
    private String gender;

    public Dog(String name, int age, String gender) {
        super(name, age);
        this.gender = gender;
    }

    public Dog(String gender) {
        this.gender = gender;
    }
}
