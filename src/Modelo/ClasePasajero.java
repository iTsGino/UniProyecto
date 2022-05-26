
package Modelo;

public class ClasePasajero {    //Inicio ClasePasajero
    
    //Atributos para la Clase
    private String NroBol;
    private String ViaNro;
    private String NomPas;
    private double NroAsi;
    private String TipAsi;
    private double PagVia;

    //Meetodos Constructores
    public ClasePasajero() {
    }

    public ClasePasajero(String NroBol, String ViaNro, String NomPas, double NroAsi, String TipAsi, double PagVia) {
        this.NroBol = NroBol;
        this.ViaNro = ViaNro;
        this.NomPas = NomPas;
        this.NroAsi = NroAsi;
        this.TipAsi = TipAsi;
        this.PagVia = PagVia;
    }
    
    //Metodos Get y Set
    public double getPagVia() {
        return PagVia;
    }
    public void setPagVia(double PagVia) {
        this.PagVia = PagVia;
    }
    public String getNroBol() {
        return NroBol;
    }
    public void setNroBol(String NroBol) {
        this.NroBol = NroBol;
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
    public String getTipAsi() {
        return TipAsi;
    }
    public void setTipAsi(String TipAsi) {
        this.TipAsi = TipAsi;
    }    
}   //Fin ClasePasajero