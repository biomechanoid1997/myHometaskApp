package mysql.animals;

import java.sql.*;
import java.util.ArrayList;

public class AnimalDB {
    private static String url = "jdbc:mysql://localhost:3306/webdb1";
    private static String username = "root";
    private static String password = "password";

    public static ArrayList<Animal> select() {

        ArrayList<Animal> animals = new ArrayList<Animal>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM pets");
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String animalName = resultSet.getString(2);
                    String animalType = resultSet.getString(3);
                    String animalColor = resultSet.getString(4);
                    int animalAge = resultSet.getInt(5);
                    String animalHost = resultSet.getString(6);
                    Animal animal = new Animal(id, animalName, animalType,animalColor,animalAge,animalHost);
                    animals.add(animal);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return animals;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static Animal selectOne(int id) {
        Animal animal = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM pets WHERE id=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        int petId = resultSet.getInt(1);
                        String petName = resultSet.getString(2);
                        String petType = resultSet.getString(3);
                        String petColor = resultSet.getString(4);
                        int petAge = resultSet.getInt(5);
                        String petHost = resultSet.getString(6);
                        animal = new Animal(petId,petName,petType,petColor,petAge,petHost);
                    }
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return animal;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public static int insert(Animal animal) {
        try {


            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO pets (AnimalName,AnimalType,AnimalColor,AnimalAge,AnimalHost) Values(?,?,?,?,?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, animal.getAnimalName());
                    preparedStatement.setString(2,animal.getAnimalType());
                    preparedStatement.setString(3,animal.getAnimalColor());
                    preparedStatement.setInt(4,animal.getAnimalAge());
                    preparedStatement.setString(5,animal.getAnimalHost());
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int update(Animal animal) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "UPDATE pets SET AnimalName = ? ,AnimalType = ?, AnimalColor = ?, AnimalAge = ?, AnimalHost = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, animal.getAnimalName());
                    preparedStatement.setString(2,animal.getAnimalType());
                    preparedStatement.setString(3,animal.getAnimalColor());
                    preparedStatement.setInt(4,animal.getAnimalAge());
                    preparedStatement.setString(5,animal.getAnimalHost());
                    preparedStatement.setInt(6,animal.getId());
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int delete(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "DELETE FROM pets WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1,id);
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

}
