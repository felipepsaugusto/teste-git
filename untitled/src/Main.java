import java.sql.*;

void main() {

    String url = "jdbc:mysql://127.0.0.1:3306/course_jdbc";
    String password = "";
    String username = "root";

    try{
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE users" + " set user_name = ? " + " where " + "(idusers = 1)"
        );

        preparedStatement.setString(1, "Vergil");
        int alt = preparedStatement.executeUpdate();
        System.out.println(alt);



    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}