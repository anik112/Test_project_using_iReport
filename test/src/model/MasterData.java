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
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.AddToCart;

/**
 *
 * @author Vista Soft IT
 */
public class MasterData {
    
    
    public float finalPrice=0;
    
    public Set<Integer> productList = new HashSet<>();
    
    private java.sql.Connection conn=Connection.getConnection();

    public MasterData() {
        
        
        try {
            PreparedStatement stmt = conn.prepareStatement("select PRODUCT_NUMBER from product_list");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productList.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public float getFinalPrice(int prId){
        
        String getPrice="SELECT PRICE FROM product_list WHERE PRODUCT_NUMBER="+prId;
        try {
            PreparedStatement statement=conn.prepareStatement(getPrice);
            ResultSet set=statement.executeQuery();
            
            while(set.next()){
                this.finalPrice=set.getFloat(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, e);
        }
        return this.finalPrice;
    }
    
    
}
