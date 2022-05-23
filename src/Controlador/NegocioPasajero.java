
package Controlador;
import Modelo.ClasePasajero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NegocioPasajero {
    
    ClaseConexion Obj = new ClaseConexion();
    List<ClasePasajero> Lis;
    ClasePasajero Cp;
    Connection Con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<ClasePasajero> ListadoPasajero(){
        Lis = new ArrayList();
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("Select * from Pasajeros");
            
            /*
            select v.VIANRO, Nom_pas, RUTNOM, VIAHRS, VIAFCH, COSVIA, Nro_asi
            from PASAJEROS p, VIAJE v, RUTA r
            where v.VIANRO=p.VIANRO and v.RUTCOD=r.RUTCOD;
            */
        } catch (Exception e) {
        }
        return Lis;
    }
}
