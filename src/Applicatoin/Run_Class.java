/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applicatoin;

import DataAccess.CustomerDA;
import DataAccess.OrderDA;
import entities.Customer;
import entities.Order;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Abdulrahman Diab
 */
public class Run_Class {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException {
        boolean flag = true;
        while(flag){
            System.out.println("\n-----------------------------"
                    + "\nchose operation:"
                    + "\n0- desplay all customer data"
                    + "\n1- find customer by id"
                    + "\n2- save a new customer"
                    + "\n3- update an existing customer"
                    + "\n4- delete an existing customer"
                    + "\n9- exit");
            int num = input.nextInt();

            switch (num) {
                case 0:
                    findAllCustomers();
                    break;
                case 1:
                    findCustomerById();
                    break;
                case 2:
                    Save(makeCustomer(false));
                    break;
                case 3:
                    Update(makeCustomer(true));
                    break;
                case 4:
                    Delete();
                    break;
                case 9:
                    flag = false;
                    break;
            }
        }
    }

    public static void findAllCustomers() throws SQLException {
        CustomerDA customerDA = new CustomerDA();
        ArrayList<Customer> customers = customerDA.FindAll();

        for (Customer c : customers) {
            System.out.printf("ID:%d |Name: %s |City: %s |Address: %s\n",
                    c.getId(), c.getName(), c.getCity(), c.getAddress());
        }
    }
    
    public static void findCustomerById() throws SQLException {
        System.out.print("\nID: ");
        int id = input.nextInt();
        CustomerDA customerDA = new CustomerDA();
        Customer c = customerDA.FindById(id);
        System.out.printf("ID:%d |Name: %s |City: %s |Address: %s\n",
                    c.getId(), c.getName(), c.getCity(), c.getAddress());
    }
    
    public static void Save (Customer customer) throws SQLException{
        CustomerDA customerDA = new CustomerDA();
        boolean flag = customerDA.Save(customer);
        if(flag){
            System.out.println("Save done");
        }else{
            System.out.println("Save fail!!");
        }
    }
    
    public static void Update(Customer customer) throws SQLException {
        CustomerDA customerDA = new CustomerDA();
        boolean flag = customerDA.Update(customer);
        if(flag){
            System.out.println("Update done");
        }else{
            System.out.println("Update fail!!");
        }
    }
    
    public static void Delete () throws SQLException{
        System.out.print("\nID: ");
        int id = input.nextInt();
        CustomerDA customerDA = new CustomerDA();
        Customer c = customerDA.FindById(id);
        System.out.printf("ID:%d |Name: %s |City: %s |Address: %s\n",
                    c.getId(), c.getName(), c.getCity(), c.getAddress());
        if (ACK("delete this customer")) {
            boolean flag = customerDA.Delete(id);
            if(flag){
                System.out.println("Delete done");
            }else{
                System.out.println("Delete fail!!");
            }
        }
    }
    
    public static boolean ACK (String mss){
        System.out.println("Are you sure you want to "+mss+": y/n ?");
        char c = input.next().charAt(0);
        switch (c) {
            case 'Y':
            case 'y':
                return true;
            case 'N':
            case 'n':
                return false;
            default:
                System.out.println("input failed, char not recognaized");
                return false;
        }
    }
    
    public static Customer makeCustomer (boolean update){
        Customer c = new Customer();
        if (update){
            System.out.print("ID: ");
            int id = input.nextInt();
            c.setId(id);
        }
        System.out.print("Name: ");
        input.nextLine();
        String name = input.nextLine();
        System.out.print("City: ");
        String city = input.nextLine();
        System.out.print("Address: ");
        String address = input.nextLine();
        c.setName(name);
        c.setCity(city);
        c.setAddress(address);
        return c;
    }
    
}
