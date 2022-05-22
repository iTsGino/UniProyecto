
package Controlador;

import Modelo.ClaseUsuario;
import java.util.List;

public interface InterfaceUsuario {
    
    public List<ClaseUsuario> ListaUsuarios();
    public void AdicionaUsuario(ClaseUsuario u);
    public boolean EditaUsuario (ClaseUsuario u);
    public boolean EliminaUsuario(String Cod);
    public int GetUsuario(ClaseUsuario u);
}
