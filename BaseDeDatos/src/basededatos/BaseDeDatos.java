package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Statement;
//package basededatos;
public class BaseDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        metodos bd = new metodos();
        bd.crearBase();
        bd.crearTabla();
    }
}
