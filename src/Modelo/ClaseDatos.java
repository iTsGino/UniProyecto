
package Modelo;

public class ClaseDatos {
    //Atributos
    private String Dri;
    private String Url;
    private String Usu;
    private String Pas;
    
    //Metodo Constructor
    public ClaseDatos() {
        this.Dri = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.Url = "jdbc:sqlserver://DESKTOP-AM2E94G;databaseName=BDViajes";
        this.Usu = "sa";
        this.Pas = "Arrow2509";
        
//        this.Dri = "com.mysql.jdbc.Driver";
//        this.Url = "jdbc:mysql://localhost:3306/bdparajava";
//        this.Usu = "root";
//        this.Pas = "";
    }
    
    //Metodos Get y Set
    public String getPas() {
        return Pas;
    }
    public void setPas(String Pas) {
        this.Pas = Pas;
    }
    public String getDri() {
        return Dri;
    }
    public void setDri(String Dri) {
        this.Dri = Dri;
    }
    public String getUrl() {
        return Url;
    }
    public void setUrl(String Url) {
        this.Url = Url;
    }
    public String getUsu() {
        return Usu;
    }
    public void setUsu(String Usu) {
        this.Usu = Usu;
    }    
}