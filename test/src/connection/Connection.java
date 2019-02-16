/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vista Soft IT
 */
public class Connection {
    
    
    private final static String BasedUrl="jdbc:mysql://";
    private final static String host="localhost";
    private final static String port="3306";
    private final static String dbName="BATA_SHOE_STORE";
    private final static String url=BasedUrl+host+":"+port+"/"+dbName;
    private static java.sql.Connection connection=null;
    
    
    public static java.sql.Connection getConnection(){
        
        try {
            
           // Class.forName("com.mysql.jdbc.Connection");
            connection=DriverManager.getConnection(url, "root", "");
            System.out.println("::Connected::");
            return connection;
        } catch (SQLException /*| ClassNotFoundException */ e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
}
