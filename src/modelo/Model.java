package modelo;


import modelo.entidades.Entidad;
import controlador.Controller;
import java.io.Serializable;
import java.util.List;

public interface Model <C extends Controller, T extends Entidad, K extends Serializable>{
    //Enlaces con el controlador
    C getController();
    void setController(C controller);


    //Funciones que debe permitir el modelo
    void nuevaEntidad(T entidad);
    T obtenerEntidad(K pk);
    void eliminarEntidad(T entidad);
    void actualizarEntidad(T entidad);
    List<T> listar();

}
