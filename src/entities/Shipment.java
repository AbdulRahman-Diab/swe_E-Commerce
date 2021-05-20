/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author AbdulRahman Diab
 */
public class Shipment { 
    
    private int ID;
    private int order_ID;
    private int shipment_company_ID;
    private String shipment_date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public int getShipment_company_ID() {
        return shipment_company_ID;
    }

    public void setShipment_company_ID(int shipment_company_ID) {
        this.shipment_company_ID = shipment_company_ID;
    }

    public String getShipment_date() {
        return shipment_date;
    }

    public void setShipment_date(String shipment_date) {
        this.shipment_date = shipment_date;
    }
    
}
