package com.sale.ecpisalemanagement.sevices;

import com.sale.ecpisalemanagement.model.Category;
import com.sale.ecpisalemanagement.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    final static Connection connection = DbService.getConnection();

    public static List<Users> all(){
        List<Users> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
    public static Users get(int id) {
        Users user = new Users();
        String query = "select * from users where id ='" +id+"'";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
    public static void create(Users user) {
        String query = "INSERT INTO users (name, email, password, address) VALUES (?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ResultSet rs = ps.executeQuery();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void update(Users user) {
        String query = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
