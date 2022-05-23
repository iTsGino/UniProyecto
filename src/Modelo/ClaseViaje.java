
package Modelo;

import java.util.Date;

public class ClaseViaje {
    private String ViaNro;
    private String CodRut;
    private String HroVia;
    private Date FecVia;
    private double CosVia;

    public ClaseViaje() {
    }

    public ClaseViaje(String ViaNro, String CodRut, String HroVia, Date FecVia, double CosVia) {
        this.ViaNro = ViaNro;
        this.CodRut = CodRut;
        this.HroVia = HroVia;
        this.FecVia = FecVia;
        this.CosVia = CosVia;
    }
    
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
    public String getCodRut() {
        return CodRut;
    }
    public void setCodRut(String CodRut) {
        this.CodRut = CodRut;
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
}