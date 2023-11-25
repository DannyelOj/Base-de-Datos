/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VEL-USER
 */
public class metodos {

    Connection con = null;
    String sURL = "jdbc:mysql://localhost:3306/northwind";

    public void crearBase() {
        try {
            con = DriverManager.getConnection(sURL, "root", "123Pokemon@");
            Statement stmt = con.createStatement();
            stmt.execute("create database if not exists northwind");
            System.out.println("Base de datos creada correctamente");
        } catch (SQLException e) {
            System.out.println("Error en la conexión:" + e.toString());
        } finally {
            try {
                // Cerramos posibles conexiones abiertas
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error cerrando conexiones: "
                        + e.toString());
            }
        }
    }

    public void crearTabla() {
        try {
            con = DriverManager.getConnection(sURL, "root", "123Pokemon@");
            Statement stmt = con.createStatement();
            //Preparas el String con los datos de creación  de la tabla
            String sql = "CREATE TABLE IF NOT EXISTS Categories "
                    + "(CategoryID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + " CategoryName VARCHAR(25), "
                    + " Description VARCHAR(255) )";
            //Ejecutamos el Statement
            stmt.executeUpdate(sql);//
            //Preparas el String con los datos de creación  de la tabla
            String sql2 = "CREATE TABLE IF NOT EXISTS Customers "
                    + "(CustomerID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + " CustomerName VARCHAR(50), "
                    + " ContactName VARCHAR(50),"
                    + " Address VARCHAR(50),"
                    + " City VARCHAR(20),"
                    + " PostalCode VARCHAR(10),"
                    + " Country VARCHAR(15))";
            //Ejecutamos el Statement
            stmt.executeUpdate(sql2);//
            String sql3 = "CREATE TABLE IF NOT EXISTS Employees "
                    + "(EmployeeID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + " LastName VARCHAR(15), "
                    + " FirstName VARCHAR(15),"
                    + " BirthDate DATETIME,"
                    + " Photo VARCHAR(25),"
                    + " Notes VARCHAR(1024))";
            //Ejecutamos el Statement
            stmt.executeUpdate(sql3);//
            String sql4 = "CREATE TABLE IF NOT EXISTS Shippers "
                    + "(ShipperID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + " ShipperName VARCHAR(25),"
                    + " Phone VARCHAR(15))";
            //Ejecutamos el Statement
            stmt.executeUpdate(sql4);//
            String sql5 = "CREATE TABLE IF NOT EXISTS Suppliers "
                    + "(SupplierID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + " SupplierName VARCHAR(50),"
                    + " ContactName VARCHAR(50),"
                    + " Address VARCHAR(50),"
                    + " City VARCHAR(20),"
                    + " PostalCode VARCHAR(10),"
                    + " Country VARCHAR(15),"
                    + " Phone VARCHAR(15))";
            //Ejecutamos el Statement
            stmt.executeUpdate(sql5);//
            String sql6 = "CREATE TABLE IF NOT EXISTS Products "
                    + "(ProductID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + " ProductName VARCHAR(50),"
                    + " SupplierID INTEGER,"
                    + " CategoryID INTEGER,"
                    + " Unit VARCHAR(25),"
                    + " Price NUMERIC,"
                    + " FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID),"
                    + " FOREIGN KEY (SupplierID) REFERENCES Suppliers (SupplierID))";
            //Ejecutamos el Statement
            stmt.executeUpdate(sql6);
            String sql7 = "CREATE TABLE IF NOT EXISTS Orders "
                    + "(OrderID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + " CustomerID INTEGER,"
                    + " EmployeeID INTEGER,"
                    + " OrderDate DATETIME,"
                    + " ShipperID INTEGER,"
                    + " FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID),"
                    + " FOREIGN KEY (CustomerID) REFERENCES Customers (CustomerID),"
                    + " FOREIGN KEY (ShipperID) REFERENCES Shippers (ShipperID))";
            //Ejecutamos el Statement
            stmt.executeUpdate(sql7);
            String sql8 = "CREATE TABLE IF NOT EXISTS OrderDetails "
                    + "(OrderDetailID INTEGER PRIMARY KEY AUTO_INCREMENT,"
                    + " OrderID INTEGER,"
                    + " ProductID INTEGER,"
                    + " Quantity INTEGER,"
                    + " FOREIGN KEY (OrderID) REFERENCES Orders (OrderID),"
                    + " FOREIGN KEY (ProductID) REFERENCES Products (ProductID))";
            //Ejecutamos el Statement
            stmt.executeUpdate(sql8);
            // System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertar() {

    }

    public void leer() throws SQLException {

        try ( Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Categories");
            while (rs.next()) {
                String cName = rs.getString("CategoryName");
                String d = rs.getString("Description");
                System.out.println(String.format("%s %s",
                        cName, 
                        d));
            }
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Customers");
            while (rs1.next()) {
                String nameCustomer = rs.getString("CustomerName");
                String contactCustomer = rs.getString("ContactName");
                String addresCustomer = rs.getString("Address");
                String cityCustomer = rs.getString("City");
                String postalCustomer = rs.getString("PostalCode");
                String countryCustomer = rs.getString("Country");
                System.out.println(String.format("%s %s %s %s %s %s",
                        nameCustomer, 
                        contactCustomer, 
                        addresCustomer,
                        cityCustomer, 
                        postalCustomer, 
                        countryCustomer));

            }
            rs1.close();
            
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Employees");
            while (rs2.next()) {
                String lastEmployees = rs.getString("LastName");
                String firstEmployees = rs.getString("FirstName");
                String birthEmployees = rs.getString("BirthDate");
                String photoEmployees = rs.getString("Photo");
                String notesEmployees = rs.getString("Notes");
                System.out.println(String.format("%s %s %s %s %s ",
                        lastEmployees, 
                        firstEmployees, 
                        birthEmployees,
                        photoEmployees, 
                        notesEmployees));
            }
            rs2.close();
            
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM Shippers");
            while (rs3.next()) {
                String nameShipper = rs.getString("ShipperName");
                String contactShipper = rs.getString("Phone");
                System.out.println(String.format("%s %s",
                        nameShipper, 
                        contactShipper));
            }
            rs3.close();
            
            ResultSet rs4 = stmt.executeQuery("SELECT * FROM Suppliers");
            while (rs4.next()) {
                String nameSuppliers = rs.getString("SupplierName");
                String contactSuppliers = rs.getString("ContactName");
                String addresSuppliers = rs.getString("Address");
                String citySuppliers = rs.getString("City");
                String postalSuppliers = rs.getString("PostalCode");
                String countrySuppliers = rs.getString("Country");
                String phoneSuppliers = rs.getString("Phone");
                System.out.println(String.format("%s %s %s %s %s %s %s",
                        nameSuppliers, 
                        contactSuppliers, 
                        addresSuppliers,
                        citySuppliers, 
                        postalSuppliers,
                       countrySuppliers,
                       phoneSuppliers));
            }
            rs4.close();
            
            ResultSet rs5 = stmt.executeQuery("SELECT * FROM Products");
            while (rs5.next()) {
                String nameProducts = rs.getString("ProductName");
                String suplierIdProducts = rs.getString("SupplierID");
                String categoryIdProducts = rs.getString("CategoryID");
                String unitProducts = rs.getString("Unit");
                String priceProducts = rs.getString("Price");
                // FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID)
                // FOREIGN KEY (SupplierID) REFERENCES Suppliers (SupplierID))
                System.out.println(String.format("%s %s %s %s %s ",
                        nameProducts, 
                        suplierIdProducts, 
                        categoryIdProducts,
                        unitProducts, 
                        priceProducts));
                       //claveforanea1,
                       //claveforanea2,
            }
            rs5.close();
            
            ResultSet rs6 = stmt.executeQuery("SELECT * FROM Orders");
            while (rs6.next()) {
                String customerIdOrders = rs.getString("CustomerID");
                String employeeIdOrders = rs.getString("EmployeeID");
                String dateOrders = rs.getString("OrderDate");
                String shipperIdOrders = rs.getString("ShipperID");
                /*
                FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID),"
                FOREIGN KEY (CustomerID) REFERENCES Customers (CustomerID),"
                FOREIGN KEY (ShipperID) REFERENCES Shippers (ShipperID
                */
                System.out.println(String.format("%s %s %s %s ",
                        customerIdOrders, 
                        employeeIdOrders, 
                        dateOrders,
                        shipperIdOrders));
                       //claveforanea1,
                       //claveforanea2,
                       //claveforanea3,
            }
            rs6.close();
            
            ResultSet rs7 = stmt.executeQuery("SELECT * FROM OrderDetails");
            while (rs7.next()) {
                int orderIdOrdersDetails = rs.getInt("OrderID");
                int productIdOrdersDetails = rs.getInt("ProductID");
                int oquantityOrdersDetails = rs.getInt("Quantity");
                /*
                FOREIGN KEY (OrderID) REFERENCES Orders (OrderID)
                FOREIGN KEY (ProductID) REFERENCES Products (ProductID)
                */
                System.out.println(String.format("%d %d %d ",
                        orderIdOrdersDetails, 
                        productIdOrdersDetails, 
                        oquantityOrdersDetails));
                       //claveforanea1,
                       //claveforanea2,

            }
            rs7.close();

                    } catch (SQLException ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        con.close();
    }
}
