import java.sql.*;

void main() {

    String url = "jdbc:mysql://127.0.0.1:3306/course_jdbc";
    String password = "";
    String username = "root";

    try {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while(resultSet.next()){
            System.out.println(resultSet.getString("user_name") + " : " + resultSet.getString("password"));
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}