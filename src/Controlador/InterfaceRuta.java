
package Controlador;
import Modelo.ClaseRuta;
import java.util.List;

public interface InterfaceRuta {    //Inicio InterfaceRuta
    
    //Metodo para Listar Rutas
    public List<ClaseRuta> ListaRutas();
    
    //Metodo para Agregar una Ruta
    public void AgregaRuta(ClaseRuta r);
    
}   //Fin InterfaceRuta
