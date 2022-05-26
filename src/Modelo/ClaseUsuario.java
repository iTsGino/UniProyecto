
package Modelo;

public class ClaseUsuario { //Inicio ClaseUsuario
    //Atributos que se utilizarán
    private String Usu;
    private String PasUsu;
    private String NomUsu;
    private String CorUsu;
    private int TelUsu;
    private String PaiUsu;

    //Metodos Construxtores
    public ClaseUsuario() {
    }
    
    public ClaseUsuario(String Usu, String PasUsu, String NomUsu, String CorUsu, int TelUsu, String PaiUsu) {
        this.Usu = Usu;
        this.PasUsu = PasUsu;
        this.NomUsu = NomUsu;
        this.CorUsu = CorUsu;
        this.TelUsu = TelUsu;
        this.PaiUsu = PaiUsu;
    }
    
    //Metodos Get y Set
    public String getPaiUsu() {
        return PaiUsu;
    }

    public void setPaiUsu(String PaiUsu) {
        this.PaiUsu = PaiUsu;
    }
    public String getUsu() {
        return Usu;
    }
    public void setUsu(String Usu) {
        this.Usu = Usu;
    }
    public String getPasUsu() {
        return PasUsu;
    }
    public void setPasUsu(String PasUsu) {
        this.PasUsu = PasUsu;
    }
    public String getNomUsu() {
        return NomUsu;
    }
    public void setNomUsu(String NomUsu) {
        this.NomUsu = NomUsu;
    }
    public String getCorUsu() {
        return CorUsu;
    }
    public void setCorUsu(String CorUsu) {
        this.CorUsu = CorUsu;
    }
    public int getTelUsu() {
        return TelUsu;
    }
    public void setTelUsu(int TelUsu) {
        this.TelUsu = TelUsu;
    }
}   //Fin ClaseUsuario