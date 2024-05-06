package com.sale.ecpisalemanagement.sevices;

import com.sale.ecpisalemanagement.model.Category;
import com.sale.ecpisalemanagement.model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    final static Connection connection = DbService.getConnection();

    public static List<Products> all(){
        List<Products> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Products product = new Products();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
    public static Products get(int id) {
        Products product = new Products();
        String query = "select * from products where id ='" +id+"'";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }
    public static void create(Products product) {
        String query = "INSERT INTO products (name, description, price, quantity) VALUES (?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ResultSet rs = ps.executeQuery();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void update(Products product) {
        String query = "UPDATE products SET name = ?, description = ?, price = ?, quantity = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM products WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
