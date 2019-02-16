/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.Connection;
import java.sql.Date;
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
public class ProductModel {
    
    // make Connection variable for take database connecion
    public java.sql.Connection connection;
    // make SQL insert query
    private String insertData="INSERT INTO PRODUCT_LIST "
            + "(PRODUCT_NUMBER,PRODUCT_NAME,PRICE,QTY,ENTRY_DATE) "
            + "VALUES "
            + "(?,?,?,?,?);";
    // make SQL select query
    private String selectData="SELECT * FROM PRODUCT_LIST";
    
    /**
     * This method get Data object and take data from object.
     * Add data in Database using SQL query.
     * @param data 
     */
    public void addData(Data data){
        
        try {
            connection=Connection.getConnection(); // get database connection
            // preared SQL statement
            PreparedStatement statement=connection.prepareStatement(insertData);
            
            statement.setInt(1, data.product_number); // set product number in statement PRODUCT_NUMBER
            statement.setString(2, data.product_name); // set product name in statement PRODUCT_NAME
            statement.setFloat(3, data.price); // set price in statement PRICE
            statement.setInt(4, data.qty); // set qty in statement QTY
            statement.setDate(5, data.submitDate); // set Date in statement ENTRY_DATE
            
            statement.executeUpdate(); // run query
            
        } catch (SQLException e) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    /**
     * make a method which helps us clone data from database
     * @return Data_model_list
     */
    public List<Data> getAllProductList(){
        
        List<Data> storeData=new ArrayList<>(); // make List type variable for store data
        
        
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
                data.product_number=set.getInt(1); // get product number
                data.product_name=set.getString(2); // get product name
                data.price=set.getFloat(3); // get price
                data.qty=set.getInt(4); // get qty
                data.submitDate=set.getDate(5); // get date
                
                storeData.add(data); // set Data in list
            }
            
            return storeData; // Return list with data
            
        } catch (SQLException e) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
    
}
