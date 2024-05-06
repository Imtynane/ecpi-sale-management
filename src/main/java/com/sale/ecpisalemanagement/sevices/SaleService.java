package com.sale.ecpisalemanagement.sevices;

import com.sale.ecpisalemanagement.model.Category;
import com.sale.ecpisalemanagement.model.Sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SaleService {
    final static Connection connection = DbService.getConnection();

    public static List<Sales> all(){
        List<Sales> sales = new ArrayList<>();
        String query = "SELECT * FROM sales";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sales sale = new Sales();
                sale.setId(rs.getInt("id"));
                sale.setCustomerId(rs.getInt("customerId"));
                sale.setProductId(rs.getInt("productId"));
                sale.setCode(rs.getString("code"));
                sale.setPrice(rs.getDouble("price"));
                sale.setQuantity(rs.getInt("quantity"));
                sales.add(sale);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sales;
    }
    public static Sales get(int id) {
        Sales sales = new Sales();
        String query = "select * from salesList where id ='" +id+"'";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sales.setId(rs.getInt("id"));
                sales.setCustomerId(rs.getInt("customerId"));
                sales.setProductId(rs.getInt("productId"));
                sales.setCode(rs.getString("code"));
                sales.setPrice(rs.getDouble("price"));
                sales.setQuantity(rs.getInt("quantity"));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sales;
    }
    public static void create(Sales sales) {
        String query = "INSERT INTO salesList (customerId, productId, code, price, quantity) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sales.getCustomerId());
            ps.setInt(2, sales.getProductId());
            ps.setString(3, sales.getCode());
            ps.setDouble(4, sales.getPrice());
            ps.setInt(5, sales.getQuantity());
            ResultSet rs = ps.executeQuery();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void update(Sales sales) {
        String query = "UPDATE categories SET customerId = ?, productId = ?, code = ?, price = ?, quantity = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sales.getCustomerId());
            ps.setInt(2, sales.getProductId());
            ps.setString(3, sales.getCode());
            ps.setDouble(4, sales.getPrice());
            ps.setInt(5, sales.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM salesList WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
