
package Controlador;

import Modelo.ClaseGetPasajero;
import Modelo.ClasePasajero;
import Modelo.ClaseViaje;
import java.util.*;

public interface InterfacePasajero {
    
    public List<ClasePasajero> ListadoPasajero();
    public void AgregaPasajero(ClasePasajero p);
    public boolean EditaPasajero(ClasePasajero p);
    public boolean EliminaPasajero(String Cod);
    public ClaseGetPasajero GetPasajeroRuta(String Cod);
    public List<ClaseViaje> GetViaje();
}
