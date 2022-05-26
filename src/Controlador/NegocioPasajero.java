
package Controlador;
import Modelo.ClaseGetPasajero;
import Modelo.ClasePasajero;
import Modelo.ClaseViaje;
import java.sql.*;
import java.util.*;

public class NegocioPasajero implements InterfacePasajero{  //Inicio Clase NegocioPasajero
    
    //Atributos necesarios
    ClaseConexion Obj = new ClaseConexion();
    List<ClasePasajero> Lis;
    List<ClaseViaje> Lis2;
    List<ClaseGetPasajero> Lis3;
    ClasePasajero Cp;
    ClaseGetPasajero Cg;
    ClaseViaje Cv;
    Connection Con;
    PreparedStatement ps;
    ResultSet rs;
    
    //Metodo para Listar los Pasajeros
    @Override
    public List<ClasePasajero> ListadoPasajero(){   //Inicio Metodo ListadoPasajero
        Lis = new ArrayList();  //Inicializamos un ArrayList
        Con = Obj.GetConexion();    //Establecemos la conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("Select * from Pasajeros");   //Preparamos la sentencia SQL
            rs = ps.executeQuery(); //Ejecutamos la sentencia SQL
            while (rs.next()) { //Inicio While
                Cp = new ClasePasajero();
                //Mandamos datos al objeto de la ClasePasajero
                Cp.setNroBol(rs.getString("BOLNRO"));
                Cp.setViaNro(rs.getString("VIANRO"));
                Cp.setNomPas(rs.getString("Nom_pas"));
                Cp.setNroAsi(rs.getDouble("Nro_asi"));
                Cp.setTipAsi(rs.getString("tipo"));
                Cp.setPagVia(rs.getDouble("pago"));
                Lis.add(Cp);
            }   //Fin While
            //Fin Try
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //Inicio Finally
            try {
                if(Con != null)
                    Con.close();    //Cerramnos la conexion
            } catch (Exception e) { //Inicio Catch
                System.out.println("Error: "+e);
            }   //Fin Catch
        }   //Fin Finally
        return Lis;
    }   //Fin Metodo ListadoPasajero
    
    //Metodo para Agregar un pasajero
    @Override
    public void AgregaPasajero(ClasePasajero p) {   //Inicio Metodo AgregaPasajero
        Con = Obj.GetConexion();    //Establecemos la conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("insert PASAJEROS values (?, ?, ?, ?, ?, ?)");    //Preparamos la sentencia SQL
            //Relacionamos cada Simbolo (?)
            ps.setString(1, p.getNroBol());
            ps.setString(2, p.getViaNro());
            ps.setString(3, p.getNomPas());
            ps.setDouble(4, p.getNroAsi());
            ps.setString(5, p.getTipAsi());
            ps.setDouble(6, p.getPagVia());
            ps.executeUpdate(); //Ejecutamos la sentencia SQL
            //Fin Try
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //Inicio Finally
            try {
                if(Con != null)
                    Con.close();    //Cerramos la conexion
            } catch (Exception e) { //Inicio Catch
                System.out.println("Error: "+e);
            }   //Fin Catch
        }   //Fin Finally
    }   //Fin Metodo AgregaPasajero

    //Metodo para Editar un Pasajero
    @Override
    public boolean EditaPasajero(ClasePasajero p) { //Inicio Metodo EditaPasajero
        Con = Obj.GetConexion();    //Establecemos la conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("update PASAJEROS set VIANRO=?, Nom_pas=?, Nro_asi=?, tipo=?, pago=? where BOLNRO=?");    //Preparamos la sentecnai SQL
            //Relacionamos cada simbolo (?)
            ps.setString(6, p.getNroBol());
            ps.setString(1, p.getViaNro());
            ps.setString(2, p.getNomPas());
            ps.setDouble(3, p.getNroAsi());
            ps.setString(4, p.getTipAsi());
            ps.setDouble(5, p.getPagVia());
            ps.executeUpdate(); //Ejecutamos la conexion
            //Fin Try
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //Inicio Finally
            try {
                if(Con != null)
                    Con.close();    //Cerramos la conexion
            } catch (Exception e) { //Inicio Catch
                System.out.println("Erro: "+e);
            }   //Fin Catch
        }   //Fin Finally
        return false;
    }

    //Metodo para Eliminar un Pasajero por su codigo
    @Override
    public boolean EliminaPasajero(String Cod) {    //Inicio Metodo EliminaPasajero
        Con = Obj.GetConexion();    //Ejecutamos la Conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("delete from PASAJEROS where BOLNRO=?");  //Preparamos la sentencia SQL
            ps.setString(1, Cod);
            ps.executeUpdate(); //Ejecutamos Snetencia SQL
            //Fin Try
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //Inicio Finally
            try {
                if(Con != null)
                    Con.close();    //Cerramos la conexion
            } catch (Exception e) { //Inicio Catch
                System.out.println("Error: "+e);
            }   //Fin Catch
        }   //Fin Finally
        return false;
    }   //Fin Metodo EliminaPasajero
    
    //Metodo para Listar Pasajeros por su Ruta
    @Override
    public List<ClaseGetPasajero> GetPasajeroRuta(String Cod){  //Inicio Metodo GetPasajeroRuta
        Lis3 = new ArrayList(); //Inicializamos un Aobjeto ArralyList
        Con = Obj.GetConexion();    //Establecemos la conexion
        try {   //Inicio Try
            //Preparamos la sentencia Sql
            ps = Con.prepareStatement("select v.VIANRO, Nom_pas, Nro_asi, VIAHRS, VIAFCH, COSVIA from "
                    + " PASAJEROS p, VIAJE v, RUTA r where v.VIANRO=p.VIANRO and v.RUTCOD=r.RUTCOD and r.RUTNOM = ? ");
            ps.setString(1, Cod);
            rs = ps.executeQuery(); //Ejecutamos la sentencia SQL
            while (rs.next()) { //Inicio While
                Cg = new ClaseGetPasajero();
                //Mandamos datos al objeto de la Clase GetPasajeroRuta
                Cg.setViaNro(rs.getString(1));
                Cg.setNomPas(rs.getString(2));
                Cg.setNroAsi(rs.getDouble(3));
                Cg.setHroVia(rs.getString(4));
                Cg.setFecVia(rs.getDate(5));
                Cg.setCosVia(rs.getDouble(6));
                Lis3.add(Cg);
            }   //Fin While
            //Fin Try
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //Inicio Finally
            try {
                if(Con != null)
                    Con.close();    //Cerramos la conexion SQL
            } catch (Exception e) { //Inicio Catch
                System.out.println("Error: "+e);
            }   //Fin Catch
        }   //Fin Finally
        return Lis3;
    }   //Fin Metodo GetPasajeroRuta

    //Metodo para Listar Viajes
    @Override
    public List<ClaseViaje> GetViaje() {    //Inicio Metodo GetViaje
        Lis2 = new ArrayList(); //Inicializamos un ArrayList
        Con = Obj.GetConexion();    //establecemos la conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("Select VIANRO, VIAFCH from VIAJE");  //Preparamos la sentencia SQL
            rs = ps.executeQuery(); //Ejecutamos la sentencia SQL
            while (rs.next()) { //Inicio While
                Cv = new ClaseViaje();
                //Mandamos datos al objeto de la ClaseViaje
                Cv.setNroVia(rs.getString(1));
                Cv.setFecVia(rs.getDate(2));
                Lis2.add(Cv);
            }   //Fin While
            //Fin Try
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //Inicio Finally
            try {
                if(Con != null){
                    Con.close();    //Cerramos la conexion SQL
                }
            } catch (Exception e) { //Inicio Catch
                System.out.println("Error: "+e);
            }   //Fin Catch
        }   //Fin Finally
        return Lis2;
    }   //Fin Metodo GetViaje
}   //Fin Clase NegocioPasajero