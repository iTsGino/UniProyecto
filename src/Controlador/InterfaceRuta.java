
package Controlador;
import Modelo.ClaseRuta;
import java.util.List;

public interface InterfaceRuta {
    
    public List<ClaseRuta> ListaRutas();
    public void AgregaRuta(ClaseRuta r);
}
