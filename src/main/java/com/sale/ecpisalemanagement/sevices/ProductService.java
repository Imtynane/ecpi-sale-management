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
            while (rs.next()){
                Products p = new Products();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return products;
    }
}
