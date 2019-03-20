/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vista Soft IT
 */
public class CartModel {
    
    private java.sql.Connection connection;
    
    // make SQL insert query
    private String insertDataMaster="INSERT INTO CART_DATA_MASTER "
            + "(CLIENT_NUMBER,PRODUCT_NUMBER,SIZE,QTY,PRICE,DUE,DISC,SUB_TTL,TERMINAL_NUMBER,SUBMIT_BY,SUBMIT_DATE) "
            + "VALUES "
            + "(?,?,?,?,?,?,?,?,?,?,?);";
    
    // make SQL select query
    private String selectFinalData="SELECT * FROM product_cart";
    
    
    
    /**
     * This method get Data object and take data from object.
     * Add data in Database using SQL query.
     * @param data 
     */
    public void addData(Data data){
        
        try {
            connection=Connection.getConnection(); // get database connection
            // preared SQL statement
            PreparedStatement statement=connection.prepareStatement(insertDataMaster);
            
            statement.setInt(1, data.client_number_cart); // set product number in statement PRODUCT_NUMBER
            statement.setInt(2, data.product_number_cart); // set product name in statement PRODUCT_NAME
            statement.setInt(3, data.size_cart); // set price in statement PRICE
            statement.setInt(4, data.qty_cart); // set qty in statement QTY
            statement.setFloat(5, data.price_cart); // set Date in statement ENTRY_DATE
            statement.setFloat(6, data.due_cart);
            statement.setString(7, data.disc_cart);
            statement.setString(8, data.sub_title_cart);
            statement.setInt(9, data.terminal_number_cart);
            statement.setString(10, data.submit_by_cart);
            statement.setDate(11, data.submit_date_Cart);
            
            statement.executeUpdate(); // run query
            
        } catch (SQLException e) {
            Logger.getLogger(CartModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    
    /**
     * This method get Data object and take data from object.
     * Add data in Database using SQL query.
     * @param data 
     */
    public void addFinalData(Data data){
        
          // make SQL insert query
           String insertDatacart="INSERT INTO product_cart "
            + "(CLIENT_NUMBER,PRODUCT_NUMBER,SIZE,QTY,PRICE,DUE,DISC,SUB_TTL,TERMINAL_NUMBER,SUBMIT_BY,SUBMIT_DATE) "
            + "VALUES "
            + "(?,?,?,?,?,?,?,?,?,?,?);";
        
        
        try {
            connection=Connection.getConnection(); // get database connection
            // preared SQL statement
            PreparedStatement statement=connection.prepareStatement(insertDatacart);
            
            statement.setInt(1, data.client_number_cart); // set product number in statement PRODUCT_NUMBER
            statement.setInt(2, data.product_number_cart); // set product name in statement PRODUCT_NAME
            statement.setInt(3, data.size_cart); // set price in statement PRICE
            statement.setInt(4, data.qty_cart); // set qty in statement QTY
            statement.setFloat(5, data.price_cart); // set Date in statement ENTRY_DATE
            statement.setFloat(6, data.due_cart);
            statement.setString(7, data.disc_cart);
            statement.setString(8, data.sub_title_cart);
            statement.setInt(9, data.terminal_number_cart);
            statement.setString(10, data.submit_by_cart);
            statement.setDate(11, data.submit_date_Cart);
            
            statement.executeUpdate(); // run query
            
        } catch (SQLException e) {
            Logger.getLogger(CartModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    /**
     * make a method which helps us clone data from database
     * @return Data_model_list
     */
    public List<Data> getFinalCartList(){
        
        List<Data> storeData=new ArrayList<>(); // make List type variable for store data
        
        
        try {
            
            connection=Connection.getConnection(); // get Database connection
            // Prepared SQL statement
            PreparedStatement statement=connection.prepareStatement(selectFinalData);
            // clone data from database using execute query and store resultSet
            ResultSet set=statement.executeQuery();
            
            
            // this loop stop work when result set are empty
            while(set.next()){
                // get data model
                Data data=new Data();
                // set data in List from result set
                
                data.client_number_cart=set.getInt(2); // set product number in statement PRODUCT_NUMBER
                data.product_number_cart=set.getInt(3); // set product name in statement PRODUCT_NAME
                data.size_cart=set.getInt(4); // set price in statement PRICE
                data.qty_cart=set.getInt(5); // set qty in statement QTY
                data.price_cart=set.getFloat(6); // set Date in statement ENTRY_DATE
                data.due_cart=set.getFloat(7);
                data.disc_cart=set.getString(8);
                data.sub_title_cart=set.getString(9);
                data.terminal_number_cart=set.getInt(10);
                data.submit_by_cart=set.getString(11);
                data.submit_date_Cart=set.getDate(12);
                
                storeData.add(data); // set Data in list
            }
            
            return storeData; // Return list with data
            
        } catch (SQLException e) {
            Logger.getLogger(CartModel.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
    
    
    
    
    /**
     * make a method which helps us clone data from database
     * @return Data_model_list
     */
    public List<Data> getAllCartList(int clientId){
        
        List<Data> storeData=new ArrayList<>(); // make List type variable for store data
        // make SQL select query
        String selectData="SELECT * FROM CART_DATA_MASTER WHERE CLIENT_NUMBER="+clientId;
        
        try {
            
            connection=Connection.getConnection(); // get Database connection
            // Prepared SQL statement
            PreparedStatement statement=connection.prepareStatement(selectData);
            // clone data from database using execute query and store resultSet
            ResultSet set=statement.executeQuery();
            
            
            // this loop stop work when result set are empty
            while(set.next()){
                // get data model
                Data data=new Data();
                // set data in List from result set
                
                data.client_number_cart=set.getInt(2); // set product number in statement PRODUCT_NUMBER
                data.product_number_cart=set.getInt(3); // set product name in statement PRODUCT_NAME
                data.size_cart=set.getInt(4); // set price in statement PRICE
                data.qty_cart=set.getInt(5); // set qty in statement QTY
                data.price_cart=set.getFloat(6); // set Date in statement ENTRY_DATE
                data.due_cart=set.getFloat(7);
                data.disc_cart=set.getString(8);
                data.sub_title_cart=set.getString(9);
                data.terminal_number_cart=set.getInt(10);
                data.submit_by_cart=set.getString(11);
                data.submit_date_Cart=set.getDate(12);
                
                storeData.add(data); // set Data in list
            }
            
            return storeData; // Return list with data
            
        } catch (SQLException e) {
            Logger.getLogger(CartModel.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
    
    
    
    
    
}
