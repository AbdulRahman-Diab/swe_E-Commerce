/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Mahmoud Diab
 */
public class Shipment { 
    
    private int id;
    private int Customer_id;
    private String Shipment_date;

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

    public String getShipment_date() {
        return Shipment_date;
    }

    public void setShipment_date(String Shipment_date) {
        this.Shipment_date = Shipment_date;
    }

}
