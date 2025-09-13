package HospitalManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient() {
        System.out.println("Enter the name of the patient");
        String name = scanner.next();
        System.out.println("Enter the age of the patient");
        int age = scanner.nextInt();
        System.out.println("Enter the gender of the patient");
        String gender = scanner.next();

        try{

            String query = "insert into patients(name,age,gender) values(?,?,?)";
            PreparedStatement preparedStatements = connection.prepareStatement(query);
            preparedStatements.setString(1, name);
            preparedStatements.setInt(2, age);
            preparedStatements.setString(3, gender);
            int affectedRows = preparedStatements.executeUpdate();

            if(affectedRows > 0) {
                System.out.println("Patient has been added successfully");
            }else{
                System.out.println("Patient could not be added");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void viewPatient() {
        String query = "select * from patients";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Patient: ");
            System.out.println("+------------+-------------------------+-------+----------+");
            System.out.println("| Patient Id | Name                    | Age   | Gender   |");
            System.out.println("+------------+-------------------------+-------+----------+");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.printf("|%-12s|%-25s|%-7s|%-10s|\n", id, name, age, gender);
                System.out.println("+------------+-------------------------+-------+----------+");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean getPatientById(int id) {
        String query = "select * from patients where id = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
