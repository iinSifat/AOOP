import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {
        try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_tutorial","root","#Sifat10919");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM jdbc_tutorial.people");
        while (resultSet.next()){
            System.out.println(resultSet.getString("firstname"));
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}