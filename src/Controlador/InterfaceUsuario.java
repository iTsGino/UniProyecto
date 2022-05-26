
package Controlador;
import Modelo.ClaseUsuario;
import java.util.List;

public interface InterfaceUsuario { //Inicio InterfaceUsuario
    
    //Metodo para Listar los Usuarios
    public List<ClaseUsuario> ListaUsuarios();
    
    //Metodo para Agregar un Usuario
    public void AdicionaUsuario(ClaseUsuario u);
    
    //Metodo para Editar un Usuario
    public boolean EditaUsuario (ClaseUsuario u);
    
    //Metodo para Eliminar un Usuario por su Codigo
    public boolean EliminaUsuario(String Cod);
    
    //Metodo para Buscar un Usuario
    public int GetUsuario(ClaseUsuario u);

}   //Fin InterfaceUsuario