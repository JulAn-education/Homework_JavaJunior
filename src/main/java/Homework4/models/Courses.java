package Homework4.models;

//Создайте базу данных (например, SchoolDB).
//В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
//Настройте Hibernate для работы с вашей базой данных.
//Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
//Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
//Убедитесь, что каждая операция выполняется в отдельной транзакции.

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Courses {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int duration;

    private static final String[] cours = new String[] { "Math", "Bio", "Language", "Literature", "Physics"};
    private static final Random random = new Random();

    public Courses(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Courses(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Courses create(){
        return new Courses(cours[random.nextInt(cours.length)], random.nextInt(1, 3));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void updateTitle(){
        title = cours[random.nextInt(cours.length)];
    }

    public void updateDuration(){
        duration = random.nextInt(1, 3);
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }


}
