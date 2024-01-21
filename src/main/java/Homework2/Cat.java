package Homework2;

public class Cat extends Animal{
    private String color;
    private int amountOfLife;

    public Cat(String name, int age, String color, int amountOfLife) {
        super(name, age);
        this.color = color;
        this.amountOfLife = amountOfLife;
    }

    public Cat(String color, int amountOfLife) {
        this.color = color;
        this.amountOfLife = amountOfLife;
    }

    private void makeSound(){
        System.out.println("Meow!");
    }

}
