import java.sql.*;

void main() {

    String url = "jdbc:mysql://127.0.0.1:3306/course_jdbc";
    String password = "";
    String username = "root";

    try{
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into users" + " (user_name, password, email)" + " values " +
                "(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, "Dante");
        preparedStatement.setString(2, "pequenininhasdds");
        preparedStatement.setString(3, "vergilol@yahoo.com");
        int value = preparedStatement.executeUpdate();
        if(value > 0){
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                System.out.println(id);
            }
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    /*try{
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement st = connection.createStatement();
        ResultSet tableUsers = st.executeQuery("SELECT * FROM users");
        System.out.println("------Users------");
        while(tableUsers.next()){
            System.out.println(tableUsers.getString("user_name") + " : " + tableUsers.getString("password")
            + " : " + tableUsers.getString("email"));
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    */
}