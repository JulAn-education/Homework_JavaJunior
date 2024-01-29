package Homework4.jdbc;


//Создайте базу данных (например, SchoolDB).
//В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
//Настройте Hibernate для работы с вашей базой данных.
//Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
//Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
//Убедитесь, что каждая операция выполняется в отдельной транзакции.


import Homework4.models.Courses;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class Program {

    public static void main(String[] args) {


    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "jul175an46";

        try {
        // Подключение к базе данных
        Connection connection = DriverManager.getConnection(url, user, password);

        // Создание базы данных
        createDatabase(connection);
        System.out.println("Создана база данных");

        // Использование базы данных
        useDatabase(connection);
        System.out.println("Работа с базой");

        // Создание таблицы
        createTable(connection);
        System.out.println("Таблица создана");

        // Вставка данных
         Courses courses1 = new Courses("Math", 2);
         Courses courses2 = new Courses("Bio", 1);
         insertData(connection, courses1);
         insertData(connection, courses2);

        System.out.println("Добавлен новый объект");

        // Чтение данных
        Collection<Courses> courses = readData(connection);
        for (var cors: courses)
            System.out.println(cors);
        System.out.println("Чтение данных");

        // Обновление данных
        Courses courses3 = new Courses(1, "Language", 2);
            updateData(connection, courses3);

        System.out.println("База обновлена");

//        // Удаление данных
//            for (var cours: courses)
//                deleteData(connection, cours.getId());
//            System.out.println("Delete data successfully");

        // Закрытие соединения
        connection.close();
        System.out.println("Соединение успешно закрыто");

    } catch (SQLException e) {
        e.printStackTrace();
    }

}



    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL =  "CREATE DATABASE IF NOT EXISTS coursesDB;";
        PreparedStatement statement = connection.prepareStatement(createDatabaseSQL);
        statement.execute();
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL =  "USE coursesDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }


    private static void insertData(Connection connection, Courses courses) throws SQLException {
        String insertDataSQL = "INSERT INTO courses (title, duration) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setString(1, courses.getTitle());
            statement.setInt(2, courses.getDuration());
            statement.executeUpdate();
        }
    }


    private static Collection<Courses> readData(Connection connection) throws SQLException {
        ArrayList<Courses> coursesList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM courses;";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int duration = resultSet.getInt("duration");
                coursesList.add(new Courses(id, title, duration));
            }
            return coursesList;
        }
    }


    private static void updateData(Connection connection, Courses courses) throws SQLException {
        String updateDataSQL = "UPDATE courses SET title=?, duration=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)) {
            statement.setString(1, courses.getTitle());
            statement.setInt(2, courses.getDuration());
            statement.setInt(3, courses.getId());
            statement.executeUpdate();
        }
    }


    private static void deleteData(Connection connection, int id) throws SQLException {
        String deleteDataSQL = "DELETE FROM courses WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }



}
