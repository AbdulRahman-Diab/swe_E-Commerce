package Applicatoin;

import DataAccess.CustomerDA;
import entities.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GUI extends Application{
 
    private static TableView table = new TableView(); 
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws SQLException {   
        
        Button btn0 = new Button("desplay all customer data");
        Button btn1 = new Button("find customer by id");
        Button btn2 = new Button("save a new customer");
        Button btn3 = new Button("update an existing customer");
        Button btn4 = new Button("delete an existing customer");
        Button[] btns = {btn0, btn1, btn2, btn3, btn4};
        
        Label label1 = new Label("ID:");
        TextField id = new TextField ();
        
        Label label2 = new Label("Name:");
        TextField name = new TextField ();
        Label label3 = new Label("email:");
        TextField email = new TextField ();
        Label label4 = new Label("Phone:");
        TextField phone = new TextField ();
        Label label5 = new Label("City:");
        TextField city = new TextField ();
        Label label6 = new Label("Address:");
        TextField address = new TextField ();
        
        
        Node[] edit = {label1, id, label2, name, label3, email, label4, phone, label5, city, label6, address};
        
        table.setEditable(true);
        getCustomerTable();

        setActionHandeler(btns, id, name, email, phone, city, address);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
        
        
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        
        
//        GridPane root = new GridPane();
//        
//        root.addRow(0, btns);
//        root.addRow(1, label);
//        root.add(table, 1, 5);
//        
//        Scene scene=new Scene(root);  
//        primaryStage.setScene(scene);  
//        primaryStage.setTitle("Text Field Example");  
//        primaryStage.show();
        
        
        GridPane grid1 = new GridPane();
        grid1.addRow(0, btns);
        GridPane grid2 = new GridPane();
        grid2.addRow(0, edit);

        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Table View Sample");
        
        primaryStage.setHeight(500);  
        vbox.getChildren().addAll(label, grid1, grid2, table);
        
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
    }
    
    public static void getCustomerTable() throws SQLException{
        table.getItems().clear();
        
        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("ID"));
 
        TableColumn nameCol = new TableColumn("Last Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("name"));
 
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("email"));
        
        TableColumn phoneCol = new TableColumn("Phone");
        phoneCol.setMinWidth(100);
        phoneCol.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("phone"));
                
        TableColumn cityCol = new TableColumn("City");
        cityCol.setMinWidth(100);
        cityCol.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("city"));
 
        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("address"));
        
        table.getColumns().addAll(idCol, nameCol, emailCol, phoneCol, cityCol, addressCol);
    }

    private void setActionHandeler ( Button[] btns, TextField id, TextField name, TextField email, TextField phone, TextField city, TextField address) {
        btns[0].setOnAction(new EventHandler<ActionEvent>() {   
            public void handle(ActionEvent arg0) {  
                try {
                    System.out.println("find all customers");
                    ObservableList<Customer> customers = FXCollections.observableArrayList(new CustomerDA().FindAll());
                    table.setItems(customers);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });  
        
        btns[1].setOnAction(new EventHandler<ActionEvent>() {   
            public void handle(ActionEvent arg0) {  
                try {
                    System.out.println("find customer by id: "+id.getText().toString());
                    ObservableList<Customer> customers = FXCollections.observableArrayList(new CustomerDA().FindById(Integer.parseInt(id.getText().toString())));
                    table.setItems(customers);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        
        btns[2].setOnAction(new EventHandler<ActionEvent>() {   
            public void handle(ActionEvent arg0) {  
                try {
                    System.out.println("save new customer id: "+id.getText().toString());
                    Customer c = new Customer();
//                    c.setID(Integer.parseInt(id.getText().toString()));
                    c.setName(name.getText().toString());
                    c.setEmail(email.getText().toString());
                    c.setPhone(phone.getText().toString());
                    c.setCity(city.getText().toString());
                    c.setAddress(address.getText().toString());
                    new CustomerDA().Save(c);
                    ObservableList<Customer> customers = FXCollections.observableArrayList(new CustomerDA().FindById(c.getID()));
                    table.setItems(customers);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        
        btns[3].setOnAction(new EventHandler<ActionEvent>() {   
            public void handle(ActionEvent arg0) {  
                try {
                    System.out.println("update an existing customer id: "+id.getText().toString());
                    ObservableList<Customer> customers = FXCollections.observableArrayList(new CustomerDA().FindById(Integer.parseInt(id.getText().toString())));
                    table.setItems(customers);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        
        btns[4].setOnAction(new EventHandler<ActionEvent>() {   
            public void handle(ActionEvent arg0) {  
                try {
                    System.out.println("delete an existing customer id: "+id.getText().toString());
                    ObservableList<Customer> customers = FXCollections.observableArrayList(new CustomerDA().FindById(Integer.parseInt(id.getText().toString())));
                    table.setItems(customers);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });     
             
    }
}