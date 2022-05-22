
package Controlador;
import Modelo.ClaseDatos;
import java.sql.*;

public class ClaseConexion extends ClaseDatos{
    
    Connection Con;
    Statement st;
    
    public Connection GetConexion(){
        try {
            Class.forName(super.getDri()).newInstance();
            Con = DriverManager.getConnection(super.getUrl(), super.getUsu(), super.getPas());
            System.out.println("¡Conexion Ok!");
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return Con;
    }
}
