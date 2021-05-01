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
            String customer_city = result.getString(3);
            String customer_address = result.getString(4);           
            customer.setId(customer_id);
            customer.setName(customer_name);
            customer.setCity(customer_city);
            customer.setAddress(customer_address);
            customers.add(customer);
        }
        return customers;
    }
    
    @Override
    public Customer FindById (int id) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM customers where customer_id=" +id);
        Customer customer = null;
                
        if (result.next()){
            customer = new Customer();
            int customer_id = result.getInt(1);
            String customer_name = result.getString(2);
            String customer_city = result.getString(3);
            String customer_address = result.getString(4);           
            customer.setId(customer_id);
            customer.setName(customer_name);
            customer.setCity(customer_city);
            customer.setAddress(customer_address);
        }
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
            String customer_city = result.getString(3);
            String customer_address = result.getString(4);           
            customer.setId(customer_id);
            customer.setName(customer_name);
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
        boolean flag = statement.execute("insert into customers (customer_name, customer_city, customer_address) "
                + "values( '"+customer.getName()+"' , '"+customer.getCity()+"' , '"+customer.getAddress()+"' )");
        return !flag;
    }

    @Override
    public boolean Update(Customer obj) throws SQLException {
        
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        boolean flag = statement.execute("UPDATE customers SET"
                + " customer_name = '"+obj.getName()+"', customer_city= '"+obj.getCity()+"', customer_address= '"+obj.getAddress()+"' "
                        + "WHERE customer_id = "+obj.getId()+";");
        return !flag;
    }
    
    @Override
    public boolean Delete (int id) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        boolean flag = statement.execute("delete FROM customers where customer_id=" +id);
        return !flag;
    }
    
}
