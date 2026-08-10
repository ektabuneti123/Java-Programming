package jp_practical_7;

import java.sql.*;
import java.util.Scanner;

public class Jp_Practical_7 {
    
    // Database credentials (using port 3308 for WampServer)
    static final String URL = "jdbc:mysql://127.0.0.1:3306/test_db?useSSL=false";
    static final String USER = "root";
    static final String PASSWORD = ""; // Blank password for WampServer

    public static void main(String[] args) {
        // Explicitly load the MySQL driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found in libraries!");
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Employee Database Menu ---");
        System.out.println("1. Display All Records");
        System.out.println("2. Fetch Specific Record");
        System.out.println("3. Insert Record");
        System.out.println("4. Update Record");
        System.out.println("5. Delete Record");
        System.out.print("Choose an operation: ");
        
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: displayAll(); break;
            case 2: fetchRecord(); break;
            case 3: insertRecord(); break;
            case 4: updateRecord(); break;
            case 5: deleteRecord(); break;
            default: System.out.println("Invalid choice!"); break;
        }
    }

    // 1. Display All
    private static void displayAll() {
        String query = "SELECT * FROM employees";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   ", Name: " + rs.getString("name") + 
                                   ", Age: " + rs.getInt("age") + 
                                   ", Dept: " + rs.getString("department"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 2. Fetch Specific Record
    private static void fetchRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID to fetch: ");
        int id = scanner.nextInt();
        String query = "SELECT * FROM employees WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Name: " + rs.getString("name") + 
                                       ", Age: " + rs.getInt("age") + 
                                       ", Dept: " + rs.getString("department"));
                } else {
                    System.out.println("No employee found with ID " + id);
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 3. Insert Record
    private static void insertRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Age: "); int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter Dept: "); String dept = scanner.nextLine();

        String query = "INSERT INTO employees (id, name, age, department) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, id); stmt.setString(2, name);
            stmt.setInt(3, age); stmt.setString(4, dept);
            System.out.println(stmt.executeUpdate() + " row(s) inserted.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 4. Update Record
    private static void updateRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID to update: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter new Name: "); String name = scanner.nextLine();
        System.out.print("Enter new Age: "); int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter new Dept: "); String dept = scanner.nextLine();

        String query = "UPDATE employees SET name = ?, age = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, name); stmt.setInt(2, age);
            stmt.setString(3, dept); stmt.setInt(4, id);
            System.out.println(stmt.executeUpdate() + " row(s) updated.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 5. Delete Record
    private static void deleteRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, id);
            System.out.println(stmt.executeUpdate() + " row(s) deleted.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}