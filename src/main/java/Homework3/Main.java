package Homework3;

//Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
//Обеспечьте поддержку сериализации для этого класса.
//Создайте объект класса Student и инициализируйте его данными.
//Сериализуйте этот объект в файл.
//Десериализуйте объект обратно в программу из файла.
//Выведите все поля объекта, включая GPA, и ответьте на вопрос,
//почему значение GPA не было сохранено/восстановлено.

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Tom", 20, 4.5);
        writeObject(student);
        readObject();



    }

    public static void writeObject(Object o){
        try {
            FileOutputStream fos = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void readObject(){
        try {
            FileInputStream fis = new FileInputStream("file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student = (Student) ois.readObject();
            ois.close();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
