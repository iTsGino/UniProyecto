
package Controlador;
import Modelo.ClaseGetPasajero;
import Modelo.ClasePasajero;
import Modelo.ClaseViaje;
import java.sql.*;
import java.util.*;

public class NegocioPasajero implements InterfacePasajero{
    
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
    
    @Override
    public List<ClasePasajero> ListadoPasajero(){
        Lis = new ArrayList();
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("Select * from Pasajeros");
            rs = ps.executeQuery();
            while (rs.next()) {
                Cp = new ClasePasajero();
                Cp.setNroBol(rs.getString("BOLNRO"));
                Cp.setViaNro(rs.getString("VIANRO"));
                Cp.setNomPas(rs.getString("Nom_pas"));
                Cp.setNroAsi(rs.getDouble("Nro_asi"));
                Cp.setTipAsi(rs.getString("tipo"));
                Cp.setPagVia(rs.getDouble("pago"));
                Lis.add(Cp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(Con != null)
                    Con.close();
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
        return Lis;
    }
    
    @Override
    public void AgregaPasajero(ClasePasajero p) {
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("insert PASAJEROS values (?, ?, ?, ?, ?, ?)");
            ps.setString(1, p.getNroBol());
            ps.setString(2, p.getViaNro());
            ps.setString(3, p.getNomPas());
            ps.setDouble(4, p.getNroAsi());
            ps.setString(5, p.getTipAsi());
            ps.setDouble(6, p.getPagVia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(Con != null)
                    Con.close();
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
    }

    @Override
    public boolean EditaPasajero(ClasePasajero p) {
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("update PASAJEROS set VIANRO=?, Nom_pas=?, Nro_asi=?, tipo=?, pago=? where BOLNRO=?");
            ps.setString(6, p.getNroBol());
            ps.setString(1, p.getViaNro());
            ps.setString(2, p.getNomPas());
            ps.setDouble(3, p.getNroAsi());
            ps.setString(4, p.getTipAsi());
            ps.setDouble(5, p.getPagVia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(Con != null)
                    Con.close();
            } catch (Exception e) {
                System.out.println("Erro: "+e);
            }
        }
        return false;
    }

    @Override
    public boolean EliminaPasajero(String Cod) {
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("delete from PASAJEROS where BOLNRO=?");
            ps.setString(1, Cod);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(Con != null)
                    Con.close();
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
        return false;
    }
    
    @Override
    public List<ClaseGetPasajero> GetPasajeroRuta(String Cod){
        Lis3 = new ArrayList();
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("select v.VIANRO, Nom_pas, Nro_asi, VIAHRS, VIAFCH, COSVIA from "
                    + " PASAJEROS p, VIAJE v, RUTA r where v.VIANRO=p.VIANRO and v.RUTCOD=r.RUTCOD and r.RUTNOM = ? ");
            ps.setString(1, Cod);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cg = new ClaseGetPasajero();
                Cg.setViaNro(rs.getString(1));
                Cg.setNomPas(rs.getString(2));
                Cg.setNroAsi(rs.getDouble(3));
                Cg.setHroVia(rs.getString(4));
                Cg.setFecVia(rs.getDate(5));
                Cg.setCosVia(rs.getDouble(6));
                Lis3.add(Cg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(Con != null)
                    Con.close();
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
        return Lis3;
    }

    @Override
    public List<ClaseViaje> GetViaje() {
        Lis2 = new ArrayList();
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("Select VIANRO, VIAFCH from VIAJE");
            rs = ps.executeQuery();
            while (rs.next()) {
                Cv = new ClaseViaje();
                Cv.setNroVia(rs.getString(1));
                Cv.setFecVia(rs.getDate(2));
                Lis2.add(Cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(Con != null){
                    Con.close();
                }
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
        return Lis2;
    }
}