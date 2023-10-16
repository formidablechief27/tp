import java.sql.*;
import java.io.*;

public class JDBC {
    public static void main(String args[]) throws IOException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE blah blah blah";
        statement.executeQuery(query);
        query = "SELECT * FROM blah blah blah";
        ResultSet resultset = statement.executeQuery(query);
        while(resultset.next()){
            int id = resultset.getInt("Id");
            String firstname = resultset.getString("Firstname");
            String lastname = resultset.getString("Lastname");
            pl(// sab print kardo);
        }
        resultset.close();
        statement.close();
        connection.close();
    }
}