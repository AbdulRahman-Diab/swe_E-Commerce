package DataAccess;

import entities.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDA implements BaseDA<Customer>{
    
    @Override
    public ArrayList<Customer> FindAll() throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM customers");
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer;
                
        while(result.next()){
            customer = new Customer();
            int customer_id = result.getInt(1);
            String customer_name = result.getString(2);
            String customer_email = result.getString(3);
            String customer_phone_number = result.getString(4);
            String customer_city = result.getString(5);
            String customer_address = result.getString(6);
            
            customer.setID(customer_id);
            customer.setName(customer_name);
            customer.setEmail(customer_email);
            customer.setPhone(customer_phone_number);
            customer.setCity(customer_city);
            customer.setAddress(customer_address);
            customers.add(customer);
        }
        result.close();
        return customers;
    }
    
    @Override
    public Customer FindById (int id) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM customers where ID=" +id);
        Customer customer = null;
                
        if (result.next()){
            customer = new Customer();
            int customer_id = result.getInt(1);
            String customer_name = result.getString(2);
            String customer_email = result.getString(3);
            String customer_phone = result.getString(4);
            String customer_city = result.getString(5);
            String customer_address = result.getString(6);
            
            customer.setID(customer_id);
            customer.setName(customer_name);
            customer.setEmail(customer_email);
            customer.setPhone(customer_phone);
            customer.setCity(customer_city);
            customer.setAddress(customer_address);

        }
        result.close();
        return customer;
    }
    
    public ArrayList<Customer> FindByName (String name) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM customers where name=" +name);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = null;
                
        while (result.next()){
            customer = new Customer();
            int customer_id = result.getInt(1);
            String customer_name = result.getString(2);
            String customer_email = result.getString(3);
            String customer_phone_number = result.getString(4);
            String customer_city = result.getString(5);
            String customer_address = result.getString(6);
            
            customer.setID(customer_id);
            customer.setName(customer_name);
            customer.setEmail(customer_email);
            customer.setPhone(customer_phone_number);
            customer.setCity(customer_city);
            customer.setAddress(customer_address);

            customers.add(customer);

        }
        return customers;
    }
    
    @Override
    public boolean Save (Customer customer) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        boolean flag = statement.execute("insert into customers (name, email, phone, city, address) "
                + "values( '"+customer.getName()+"' , '"+customer.getEmail()+"' , '"+customer.getPhone()+"' , '"+customer.getCity()+"' , '"+customer.getAddress()+"' )");
        return !flag;
    }

    @Override
    public boolean Update(Customer customer) throws SQLException {
        
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        boolean flag = statement.execute("UPDATE customers SET"
                + " name = '"+customer.getName()+"', email= '"+customer.getEmail()+"', phone= '"+customer.getPhone()+"', city= '"+customer.getCity()+"', address= '"+customer.getAddress()+"' "
                        + "WHERE ID = "+customer.getID()+";");
        return !flag;
    }
    
    @Override
    public boolean Delete (int id) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        boolean flag = statement.execute("delete FROM customers where ID=" +id);
        return !flag;
    }
    
}
