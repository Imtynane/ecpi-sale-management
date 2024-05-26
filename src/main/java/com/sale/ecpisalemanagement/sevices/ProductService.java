package com.sale.ecpisalemanagement.sevices;

import com.sale.ecpisalemanagement.model.Category;
import com.sale.ecpisalemanagement.model.Products;
import com.sale.ecpisalemanagement.sevices.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final Connection connection = DbService.getConnection();

    public static List<Products> all() {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public static Products get(int id) {
        Products product = new Products();
        String query = "SELECT * FROM products WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public static void create(Products product) {
        String query = "INSERT INTO products (name, description, price, quantity, category) VALUES (?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getCategory().getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(Products product) {
        String query = "UPDATE products SET name = ?, description = ?, price = ?, quantity = ?, category = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getCategory().getId());
            ps.setInt(5, product.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM products WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}