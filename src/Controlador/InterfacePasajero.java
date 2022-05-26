
package Controlador;
import Modelo.ClaseGetPasajero;
import Modelo.ClasePasajero;
import Modelo.ClaseViaje;
import java.util.*;

public interface InterfacePasajero {    //Inicio InterfacePasajero
    
    //Metodo para Listar los Pasajeros
    public List<ClasePasajero> ListadoPasajero();
    
    //Metodo para Agregar un pasajero
    public void AgregaPasajero(ClasePasajero p);
    
    //Metodo para Editar un Pasajero
    public boolean EditaPasajero(ClasePasajero p);
    
    //Metodo para Eliminar un Pasajero por su codigo
    public boolean EliminaPasajero(String Cod);
    
    //Metodo para Listar Pasajeros por su Ruta
    public List<ClaseGetPasajero> GetPasajeroRuta(String Cod);
    
    //Metodo para Listar Viajes
    public List<ClaseViaje> GetViaje();
    
}   //Fin InterfacePasajero