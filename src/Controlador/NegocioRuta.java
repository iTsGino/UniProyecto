
package Controlador;
import Modelo.ClaseRuta;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
        
public class NegocioRuta implements InterfaceRuta{  //Inicio Clase NegocioRuta
    
    //Atrbituos necesarios
    ClaseConexion Obj = new ClaseConexion();
    List<ClaseRuta> Lis;
    ClaseRuta Cr;
    Connection Con;
    PreparedStatement ps;
    ResultSet rs;
    
    //Metodo para Listar Rutas
    @Override
    public List<ClaseRuta> ListaRutas(){    //Inicio Metodo ListaRuta
        Lis = new ArrayList();  //Inicializamos un Arraylist
        Con = Obj.GetConexion();    //Establecemos la conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("Select * from RUTA");    //Preparamos la sentencia SQL
            rs = ps.executeQuery(); //Ejecutamos la sentencia SQL
            while (rs.next()) { //Inicio While
                Cr = new ClaseRuta();
                //Mandamos los datos al Objeto de la ClaseRuta
                Cr.setCodRut(rs.getString("RUTCOD"));
                Cr.setNomRut(rs.getString("RUTNOM"));
                Cr.setPagCho(rs.getDouble("pago_cho"));
                Lis.add(Cr);
            }   //Fin While
            //Fin Try
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //Inicio Finally
            try {
                if(Con != null)
                    Con.close();
            } catch (Exception e) { //Inicio Catch
                System.out.println("Error: "+e);
            }   //Fin Catch
        }   //Fin Finally
        return Lis;
    }   //Fin Metodo ListaRuta
    
    //Metodo para Agregar una Ruta
    @Override
    public void AgregaRuta(ClaseRuta r){    //Inicio Metodo AgregaRuta
        Con = Obj.GetConexion();    //Establecemos la Conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("insert RUTA values(?, ?, ?)");   //Preparamos la sentencia SQL
            //Relacionamos cada simbolo (?)
            ps.setString(1, r.getCodRut());
            ps.setString(2, r.getNomRut());
            ps.setDouble(3, r.getPagCho());
            ps.executeUpdate(); //Ejecutamos la sentencia SQL
            //Fin Try
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //Inicio Finally
            try {
                if(Con != null)
                    Con.close();    //Cerramos la Conexion
            } catch (Exception e) { //Inicio Catch
                System.out.println("Error: "+e);
            }   //Fin Catch
        }   //Fin Finally
    }   //Fin Metodo AgregaRuta
}   //Fin Clase NegocioRuta