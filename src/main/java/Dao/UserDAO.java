package Dao;

import Entity.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

        public  void addRegister(User user)  {
            try {
                ConnexionDb connexionDb = new ConnexionDb();
                Connection connection = connexionDb.getConnection();
                String sql = "INSERT INTO users (first_name, last_name, phone, email, password) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, user.getFirst_name());
                statement.setString(2, user.getLast_name());
                statement.setString(3, user.getPhone());
                statement.setString(4, user.getEmail());
                statement.setString(5, user.getPassword());

                statement.executeUpdate();
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<User> selectAllUser() {
            List<User> users = new ArrayList<>();
            String sql = "SELECT * FROM users";

            try{
                ConnexionDb connexionDb = new ConnexionDb();
                Connection connection = connexionDb.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    User user = new User();
                    user.setId(Long.parseLong(rs.getString("id")));
                    user.setFirst_name(rs.getString("first_name"));
                    user.setLast_name(rs.getString("last_name"));
                    user.setPhone(rs.getString("phone"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    users.add(user);
                }
                rs.close();
                stmt.close();
                connection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            return users;
        }

        public void deleteUser(int id) {
            ConnexionDb connexionDb = new ConnexionDb();
            Connection conn = connexionDb.getConnection();
            String sql = "DELETE FROM users WHERE id = ?";
            try{
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

}
