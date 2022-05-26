
package Modelo;
import java.util.Date;

public class ClaseViaje {   //Inicio ClaseViaje
    
    //Atributos para la clase
    private String NroVia;
    private Date FecVia;

    //Metodos Constructores
    public ClaseViaje() {
    }

    public ClaseViaje(String NroVia, Date FecVia) {
        this.NroVia = NroVia;
        this.FecVia = FecVia;
    }
    
    //Metodo para Obtener el Numero de Viaje y la Fecha del Viaje
    public String NroViaje(){
        return NroVia+" - "+FecVia;
    }
    
    //Metodos Get y Set
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
