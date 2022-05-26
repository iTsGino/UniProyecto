
package Modelo;

public class ClaseRuta {    //Inicio ClaseRuta
    
    //Atrbituos para la clase
    private String CodRut;
    private String NomRut;
    private double PagCho;

    //Metodos Constructores
    public ClaseRuta() {
    }

    public ClaseRuta(String CodRut, String NomRut, double PagCho) {
        this.CodRut = CodRut;
        this.NomRut = NomRut;
        this.PagCho = PagCho;
    }
    
    //Metodo para Obtener el Codigo y Nombre de la Ruta
    public String NombreRuta(){
        String Cad = CodRut+" - "+NomRut;
        return Cad;
    }
    
    //Metodos Get y Set
    public double getPagCho() {
        return PagCho;
    }
    public void setPagCho(double PagCho) {
        this.PagCho = PagCho;
    }
    public String getCodRut() {
        return CodRut;
    }
    public void setCodRut(String CodRut) {
        this.CodRut = CodRut;
    }
    public String getNomRut() {
        return NomRut;
    }
    public void setNomRut(String NomRut) {
        this.NomRut = NomRut;
    }     
}   //Fin ClaseRuta