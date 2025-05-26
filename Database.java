import java.sql.*;

public class Database {
    public static boolean saveUser(User user) {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect DB
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/restaurant", "root",
                    "200008100881");

            String sql = "INSERT INTO users (username, email, phone, dob, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getDob());
            stmt.setString(5, user.getPassword());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
