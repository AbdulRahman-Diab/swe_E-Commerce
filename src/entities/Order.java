/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 * @author Mahmoud Diab
 */
public class Order {

    private int id;
    private int Customer_id;
    private String Order_date;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int Customer_id) {
        this.Customer_id = Customer_id;
    }

    public String getOrder_date() {
        return Order_date;
    }

    public void setOrder_date(String Order_date) {
        this.Order_date = Order_date;
    }
}
