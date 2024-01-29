package Homework4.hibernate;

import Homework4.models.Courses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Program {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Courses.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()){

            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Courses courses = Courses.create();

            // Сохранение объекта в базе данных
            session.save(courses);
            System.out.println("Объект сохранен");

            // Чтение объекта
            Courses retrievedCourses= session.get(Courses.class, courses.getId());
            System.out.println("Объект получен");
            System.out.println("Получен объект: " + retrievedCourses);

            // Обновление объекта
            retrievedCourses.updateTitle();
            retrievedCourses.updateDuration();
            session.update(retrievedCourses);
            System.out.println("Объект обновлен");

            // Удаление объекта
            //session.delete(retrievedStudent);
            //System.out.println("Объект удален");

            // Коммит транзакции
            session.getTransaction().commit();
            System.out.println("Сделан коммит");

        }
    }
}
