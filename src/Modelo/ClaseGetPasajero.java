
package Modelo;
import java.util.*;

public class ClaseGetPasajero { //Inicio ClaseGetPasajero

    //Atrbituos necesarios para la Clase
    private String ViaNro;
    private String NomPas;
    private double NroAsi;
    private String HroVia;
    private Date FecVia;
    private double CosVia;

    //Metodos Constructores
    public ClaseGetPasajero() {
    }

    public ClaseGetPasajero(String ViaNro, String NomPas, double NroAsi, String HroVia, Date FecVia, double CosVia) {
        this.ViaNro = ViaNro;
        this.NomPas = NomPas;
        this.NroAsi = NroAsi;
        this.HroVia = HroVia;
        this.FecVia = FecVia;
        this.CosVia = CosVia;
    }
    
    //Metodos Get y Set
    public double getCosVia() {
        return CosVia;
    }
    public void setCosVia(double CosVia) {
        this.CosVia = CosVia;
    }
    public String getViaNro() {
        return ViaNro;
    }
    public void setViaNro(String ViaNro) {
        this.ViaNro = ViaNro;
    }
    public String getNomPas() {
        return NomPas;
    }
    public void setNomPas(String NomPas) {
        this.NomPas = NomPas;
    }
    public double getNroAsi() {
        return NroAsi;
    }
    public void setNroAsi(double NroAsi) {
        this.NroAsi = NroAsi;
    }
    public String getHroVia() {
        return HroVia;
    }
    public void setHroVia(String HroVia) {
        this.HroVia = HroVia;
    }
    public Date getFecVia() {
        return FecVia;
    }
    public void setFecVia(Date FecVia) {
        this.FecVia = FecVia;
    }
}   //Fin ClaseGetPasajero