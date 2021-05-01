package DataAccess;

import entities.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDA /*implements BaseDA<Order>*/{
    
//    @Override
//    public ArrayList<Order> FindAll() throws SQLException{
//        Connection connection = ConnectionManager.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM order");
//        ArrayList<Order> orders = new ArrayList<Order>();
//        Order order;
//                
//        while(result.next()){
//            order = new Order();
//            int Order_id = result.getInt(1);
//            int Customer_id = result.getInt(2);
//            String Order_date = result.getString(3);           
//            order.setId(Order_id);
//            order.setCustomer_id(Customer_id);
//            order.setOrder_date(Order_date);
//            orders.add(order);
//        }
//        return orders;
//    }
//    
//    @Override
//    public Order FindById (int id) throws SQLException{
//        Connection connection = ConnectionManager.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM order where order_id=" +id);
//        Order order = null;
//                
//        if(result.next()){
//            order = new Order();
//            int Order_id = result.getInt(1);
//            int Customer_id = result.getInt(2);
//            String Order_date = result.getString(3);           
//            order.setId(Order_id);
//            order.setCustomer_id(Customer_id);
//            order.setOrder_date(Order_date);
//        }
//        return order;
//    }
//    
//    // custom method
//    public ArrayList<Order> FindByCustomerId (int id) throws SQLException{
//        Connection connection = ConnectionManager.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet result = statement.executeQuery("SELECT * FROM order where customer_id=" +id);
//        ArrayList<Order> orders = new ArrayList<Order>();
//        Order order;
//                
//        while(result.next()){
//            order = new Order();
//            int Order_id = result.getInt(1);
//            int Customer_id = result.getInt(2);
//            String Order_date = result.getString(3);           
//            order.setId(Order_id);
//            order.setCustomer_id(Customer_id);
//            order.setOrder_date(Order_date);
//            orders.add(order);
//        }
//        return orders;
//    }
//    
//    @Override
//    public boolean Save (Order order) throws SQLException{
//        Connection connection = ConnectionManager.getConnection();
//        Statement statement = connection.createStatement();
//        boolean flag = statement.execute("insert into order value('"+order.getCustomer_id()+"','"+order.getOrder_date()+"')");
//        return flag;
//    }
//
//    @Override
//    public boolean Update(Order order) throws SQLException {
//        
//        Connection connection = ConnectionManager.getConnection();
//        Statement statement = connection.createStatement();
//        boolean flag = statement.execute("UPDATE order SET"
//                + " customer_id = '"+order.getCustomer_id()+"', order_date= '"+order.getOrder_date()+"' "
//                        + "WHERE order_id = "+order.getId()+";");
//        return flag;
//    }
//    
//    @Override
//    public boolean Delete (int id) throws SQLException{
//        Connection connection = ConnectionManager.getConnection();
//        Statement statement = connection.createStatement();
//        boolean flag = statement.execute("delete * FROM order where order_id=" +id);
//        return flag;
//    }
//    
}
