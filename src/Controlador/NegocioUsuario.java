
package Controlador;
import Modelo.ClaseUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NegocioUsuario implements InterfaceUsuario{
    
    List<ClaseUsuario> Lis;
    ClaseUsuario Cu;
    ClaseConexion ObjCon = new ClaseConexion();
    Connection Con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<ClaseUsuario> ListaUsuarios(){
        Lis = new ArrayList();
        Con = ObjCon.GetConexion();
        try {
            ps = Con.prepareStatement("Select * from USUARIO");
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cu = new ClaseUsuario();
                Cu.setUsu(rs.getString("USUARIO"));
                Cu.setPasUsu(rs.getString("CLAVE"));
                Cu.setNomUsu(rs.getString("NOMBRE"));
                Cu.setCorUsu(rs.getString("CORREO"));
                Cu.setTelUsu(rs.getInt("TELEFONO"));
                Cu.setPaiUsu(rs.getString("PAIS"));
                Lis.add(Cu);
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
    public void AdicionaUsuario(ClaseUsuario u) {
        Con = ObjCon.GetConexion();
        try {
            ps = Con.prepareStatement("insert USUARIO values(?, ?, ?, ?, ?, ?)");
            ps.setString(1, u.getUsu());
            ps.setString(2, u.getPasUsu());
            ps.setString(3, u.getNomUsu());
            ps.setString(4, u.getCorUsu());
            ps.setInt(5, u.getTelUsu());
            ps.setString(6, u.getPaiUsu());
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
    public boolean EditaUsuario(ClaseUsuario u) {
        Con = ObjCon.GetConexion();
        try {
            ps = Con.prepareStatement("update USUARIO set CLAVE=?, NOMBRE=?, CORREO=?, TELEFONO=?, PAIS=? where USUARIO=?");
            ps.setString(6, u.getUsu());
            ps.setString(1, u.getPasUsu());
            ps.setString(2, u.getNomUsu());
            ps.setString(3, u.getCorUsu());
            ps.setInt(4, u.getTelUsu());
            ps.setString(5, u.getPaiUsu());
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
    public boolean EliminaUsuario(String Usu) {
        Con = ObjCon.GetConexion();
        try {
            ps = Con.prepareStatement("delete from USUARIO where USUARIO=?");
            ps.setString(1, Usu);
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
    public int GetUsuario(ClaseUsuario u) {
        int Res = 0;
        Con = ObjCon.GetConexion();
        try {
            ps = Con.prepareStatement("Select * from USUARIO where USUARIO=? and CLAVE=?");
            ps.setString(1, u.getUsu());
            ps.setString(2, u.getPasUsu());
            rs = ps.executeQuery();
            while (rs.next()) {                
                Res = 1;
                u.setUsu(rs.getString("USUARIO"));
                u.setPasUsu(rs.getString("CLAVE"));
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
        return Res;
    }
}