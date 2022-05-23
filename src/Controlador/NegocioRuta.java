
package Controlador;
import Modelo.ClaseRuta;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
        
public class NegocioRuta implements InterfaceRuta{
    
    ClaseConexion Obj = new ClaseConexion();
    List<ClaseRuta> Lis;
    ClaseRuta Cr;
    Connection Con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<ClaseRuta> ListaRutas(){
        Lis = new ArrayList();
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("Select * from RUTA");
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cr = new ClaseRuta();
                Cr.setCodRut(rs.getString("RUTCOD"));
                Cr.setNomRut(rs.getString("RUTNOM"));
                Cr.setPagCho(rs.getDouble("pago_cho"));
                Lis.add(Cr);
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
    public void AgregaRuta(ClaseRuta r){
        Con = Obj.GetConexion();
        try {
            ps = Con.prepareStatement("insert RUTA values(?, ?, ?)");
            ps.setString(1, r.getCodRut());
            ps.setString(2, r.getNomRut());
            ps.setDouble(3, r.getPagCho());
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
}
