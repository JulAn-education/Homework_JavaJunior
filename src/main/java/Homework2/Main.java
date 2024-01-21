package Homework2;

// Задача 1:
//Создайте абстрактный класс "Animal" с полями "name" и "age".
//Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
//Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
//Выведите на экран информацию о каждом объекте.
//Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Барсик", 5), new Dog("Шарик", 3, "m"),
                new Dog("m"), new Cat("black", 9)};

        Cat cat = new Cat("black", 8);
//        checkFields(cat);
//        checkMethods(cat);
        //checkClassName(cat);
        getInfo(animals);


    }

    public static void checkFields(Object o){
        Class c = o.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f: fields) {
            System.out.print(f.getName() + " ");
        }
        System.out.println();
    }

    public static void checkMethods(Object o){
        Class c = o.getClass();
        Method[] methods = c.getMethods();
        for (Method f: methods) {
            System.out.print(f.getName() + " ");
        }
        System.out.println();
    }

    public static void checkClassName(Object o){
        Class c = o.getClass();
        System.out.println(c.getSimpleName());
    }

    public static void getInfo(Object[] objects){
        for (Object obj: objects) {
            checkClassName(obj);
            System.out.print("Fields: ");
            checkFields(obj);
            System.out.print("Methods: ");
            checkMethods(obj);
            Method m = null;
            try{
                m = obj.getClass().getDeclaredMethod("makeSound", null);
                m.setAccessible(true);
                m.invoke(obj);
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                System.out.println("Метод makeSound отсутствует ");
            }
            System.out.println();

        }
    }


}
