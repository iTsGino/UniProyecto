
package Modelo;

public class ClasePasajero {
    private String NroBol;
    private String ViaNro;
    private String NomPas;
    private int NroAsi;
    private String TipAsi;
    private double PagVia;

    public ClasePasajero() {
    }

    public ClasePasajero(String NroBol, String ViaNro, String NomPas, int NroAsi, String TipAsi, double PagVia) {
        this.NroBol = NroBol;
        this.ViaNro = ViaNro;
        this.NomPas = NomPas;
        this.NroAsi = NroAsi;
        this.TipAsi = TipAsi;
        this.PagVia = PagVia;
    }
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
    public int getNroAsi() {
        return NroAsi;
    }
    public void setNroAsi(int NroAsi) {
        this.NroAsi = NroAsi;
    }
    public String getTipAsi() {
        return TipAsi;
    }
    public void setTipAsi(String TipAsi) {
        this.TipAsi = TipAsi;
    }    
}