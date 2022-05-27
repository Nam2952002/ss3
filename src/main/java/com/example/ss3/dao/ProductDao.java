package com.example.ss3.dao;

import com.example.ss3.model.Products;
import com.example.ss3.utils.ConnectionUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

     Connection connection = ConnectionUtil.getConnection();


     public List<Products> getProductByCategory(int id){
         List<Products> list = new ArrayList<>();
         String url = "SELECT * FORM product where category = ?";
         try{
             PreparedStatement ps = connection.prepareStatement(url);
             ps.setInt(1, id);
             ResultSet is = ps.executeQuery();
             while (is.next()){
                 Products p = new Products();
                 p.setId(is.getInt("id"));
                 p.setName(is.getString("name"));
                 p.setPrice(is.getInt("price"));
                 p.setQuantity(is.getInt("quantity"));
                 p.setCategory(is.getInt("category"));

                 list.add(p);
             }
         }catch (SQLException e){
             e.printStackTrace();
         }

         return list;
     }


     public String updateProducts(Products p ){
         String url = "UPDATE product SET name = ?, price = ?, WHERE id = ?";

         try {
             PreparedStatement ps = connection.prepareStatement(url);
             ps.setString(1, p.getName());
             ps.setInt(2, p.getPrice());
             ps.setInt(3, p.getId());
             int Success = ps.executeUpdate();
             if (Success > 0){
                 return "Success";
             }
         }catch (SQLException e){
             e.printStackTrace();
         }

         return "Fail";
     }


     public String deleteProducts(Products p ){
         String url = "DELETE FORM product where id = ?";
         try {
             PreparedStatement ps = connection.prepareStatement(url);
             ps.setInt(1, p.getId());
             int Success = ps.executeUpdate();
             if (Success > 0){
                 return "Success";
             }

         }catch (SQLException e){
             e.printStackTrace();
         }

         return "Fail";
     }

    public String insertProduct(Products products){

        String sql = "INSERT INTO product (name, price, quantity, category) value (?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, products.getName());
            ps.setInt(1, products.getPrice());
            ps.setInt(1, products.getQuantity());
            ps.setInt(1, products.getCategory());

            int Success = ps.executeUpdate();
            if (Success > 0){
                return "Success";
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return "Fail";
    }
}
