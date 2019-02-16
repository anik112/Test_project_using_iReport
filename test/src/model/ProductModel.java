/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vista Soft IT
 */
public class ProductModel {
    
    private String tableName;
    public java.sql.Connection connection;
    
    private String insertData="INSERT INTO PRODUCT_LIST "
            + "(PRODUCT_NUMBER,PRODUCT_NAME,PRICE,QTY,ENTRY_DATE) "
            + "VALUES "
            + "(?,?,?,?,?);";
    
    private String selectData="SELECT * FROM"+tableName;
    
    public void addData(Data data){
        
        this.tableName=data.tableName;
        
        try {
            connection=Connection.getConnection();
            
            PreparedStatement statement=connection.prepareStatement(insertData);
            
            statement.setInt(1, data.product_number);
            statement.setString(2, data.product_name);
            statement.setFloat(3, data.price);
            statement.setInt(4, data.qty);
            statement.setDate(5, data.submitDate);
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    
    
}
