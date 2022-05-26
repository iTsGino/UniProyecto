
package Controlador;
import Modelo.ClaseUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NegocioUsuario implements InterfaceUsuario{    //Inicio Clase NegocioUsuario
    
    //Atributos
    List<ClaseUsuario> Lis;
    ClaseUsuario Cu;
    ClaseConexion ObjCon = new ClaseConexion();
    Connection Con;
    PreparedStatement ps;
    ResultSet rs;
    
    //Metodo para Listar los Usuarios
    @Override
    public List<ClaseUsuario> ListaUsuarios(){  //Inicio Metodo ListaUsuario
        Lis = new ArrayList();  //Inicializamos un ArrayList
        Con = ObjCon.GetConexion(); //Extablecemos la Conexion
        try {
            ps = Con.prepareStatement("Select * from USUARIO"); //Preparamos la sentencia SQL
            rs = ps.executeQuery(); //Ejecutamos la sentencia
            while (rs.next()) { //Inicio While
                Cu = new ClaseUsuario();
                //Llenamos los campos de la ClaseUsuario
                Cu.setUsu(rs.getString("USUARIO"));
                Cu.setPasUsu(rs.getString("CLAVE"));
                Cu.setNomUsu(rs.getString("NOMBRE"));
                Cu.setCorUsu(rs.getString("CORREO"));
                Cu.setTelUsu(rs.getInt("TELEFONO"));
                Cu.setPaiUsu(rs.getString("PAIS"));
                Lis.add(Cu);
            }   //Fin While
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(Con != null)
                    Con.close();    //Cerramos la conexion
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
        return Lis;
    }   //Fin Metodo ListaUsuario

    //Metodo para Agregar un Usuario
    @Override
    public void AdicionaUsuario(ClaseUsuario u) {   //Inicio Metodo AdicionaUsuario
        Con = ObjCon.GetConexion(); //Establecemos la conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("insert USUARIO values(?, ?, ?, ?, ?, ?)");   //Preparamos la sentecnia SQL
            //Relacionamos cada Simbolo (?)
            ps.setString(1, u.getUsu());
            ps.setString(2, u.getPasUsu());
            ps.setString(3, u.getNomUsu());
            ps.setString(4, u.getCorUsu());
            ps.setInt(5, u.getTelUsu());
            ps.setString(6, u.getPaiUsu());
            ps.executeUpdate(); //Ejecutamos la Sentencia
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
    }   //Fin Metodo AdicionaUsuario

    //Metodo para Editar un Usuario
    @Override
    public boolean EditaUsuario(ClaseUsuario u) {   //Inicio Metodo EditaUsuario
        Con = ObjCon.GetConexion();
        try {   //Inicio Try
            ps = Con.prepareStatement("update USUARIO set CLAVE=?, NOMBRE=?, CORREO=?, TELEFONO=?, PAIS=? where USUARIO=?");    //Preparamos la sentencia SQL
            //Preparamos y relacionamos cada simbolo (?)
            ps.setString(6, u.getUsu());
            ps.setString(1, u.getPasUsu());
            ps.setString(2, u.getNomUsu());
            ps.setString(3, u.getCorUsu());
            ps.setInt(4, u.getTelUsu());
            ps.setString(5, u.getPaiUsu());
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
        return false;
    }   //Fin Metodo EditaUsuario

    //Metodo para Eliminar un Usuario por su Codigo
    @Override
    public boolean EliminaUsuario(String Usu) { //Inicio Metodo EliminaUsuario
        Con = ObjCon.GetConexion(); //Establecemos la conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("delete from USUARIO where USUARIO=?");   //Preparamos la sentencia SQL
            ps.setString(1, Usu);
            ps.executeUpdate(); //Ejecutamos la conexion
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
    }   //Fin Metodo EliminaUsuario

    //Metodo para Buscar un Usuario
    @Override
    public int GetUsuario(ClaseUsuario u) { //Inicio metodo GetUsuario
        int Res = 0;
        Con = ObjCon.GetConexion(); //Establecemos la conexion
        try {   //Inicio Try
            ps = Con.prepareStatement("Select * from USUARIO where USUARIO=? and CLAVE=?"); //Preparamos la satencia SQL
            //Relacion los datos con los simbolos (?)
            ps.setString(1, u.getUsu());
            ps.setString(2, u.getPasUsu());
            rs = ps.executeQuery(); //Ejecutamos la sentencia SQL
            while (rs.next()) { //Inicio While
                Res = 1;
                u.setUsu(rs.getString("USUARIO"));
                u.setPasUsu(rs.getString("CLAVE"));
            }   //Fin While
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
        return Res;
    }   //Fin metodo GetUsuario
}   //Fin Clase NegocioUsuario