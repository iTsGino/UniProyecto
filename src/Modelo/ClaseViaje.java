
package Modelo;
import java.util.Date;

public class ClaseViaje {
    
    private String NroVia;
    private Date FecVia;

    public ClaseViaje() {
    }

    public ClaseViaje(String NroVia, Date FecVia) {
        this.NroVia = NroVia;
        this.FecVia = FecVia;
    }
    
    public String getNroVia() {
        return NroVia;
    }

    public void setNroVia(String NroVia) {
        this.NroVia = NroVia;
    }

    public Date getFecVia() {
        return FecVia;
    }

    public void setFecVia(Date FecVia) {
        this.FecVia = FecVia;
    }
    
}
