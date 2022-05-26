
package Controlador;
import Modelo.ClaseDatos;
import java.sql.*;

public class ClaseConexion extends ClaseDatos{  //Inicio ClaseDatos
    
    //Atributos
    Connection Con;
    Statement st;
    
    //Metodo para realizar la conexion con la BD (Driver, Url, Usuario, Password)
    public Connection GetConexion(){    //Inicio Metodo GetConexion
        try {
            Class.forName(super.getDri()).newInstance();    //Para el Driver
            Con = DriverManager.getConnection(super.getUrl(), super.getUsu(), super.getPas());
            System.out.println("¡Conexion Ok!");
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return Con;
    }   //Fin Metodo GetConexion
}   //Fin ClaseDatos