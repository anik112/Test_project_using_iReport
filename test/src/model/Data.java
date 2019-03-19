/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Vista Soft IT
 */
public class Data {
    
    
        public int product_number;
        public String product_name;
        public float price;
        public int qty;
        public Date submitDate;
        public String tableName;
        
        
        public int client_number_cart;
        public int product_number_cart;
        public int size_cart;
        public int qty_cart;
        public float price_cart;
        public float due_cart;
        public String disc_cart;
        public String sub_title_cart;
        public int terminal_number_cart;
        public String submit_by_cart;
        public Date submit_date_Cart;
        
        

        public Data() {
        }
    
}
