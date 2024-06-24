package modelo;

import controlador.Controller;
import java.io.Serializable;
import java.util.List;
import modelo.entidades.Entidad;
import modelo.persistencia.GenericDAO;

public abstract class AbstractModelImpl <C extends Controller, T extends Entidad, K extends Serializable>
        implements Model<C,T,K>{
    private C controller;

    public C getController() {
        return controller;
    }

    public void setController(C controller) {
        this.controller=controller;
    }

    public void nuevaEntidad(T entidad) {
        GenericDAO dao=obtenerImplementacionDAO();
        dao.create(entidad);
        controller.fireDataModelChanged();
    }

    public T obtenerEntidad(K pk) {
        GenericDAO dao=obtenerImplementacionDAO();
        return (T)dao.read(pk);

    }

    public void eliminarEntidad(T entidad) {
        GenericDAO dao=obtenerImplementacionDAO();
        dao.delete(entidad);
        controller.fireDataModelChanged();
    }

    public void actualizarEntidad(T entidad) {
        GenericDAO dao=obtenerImplementacionDAO();
        dao.update(entidad);
        controller.fireDataModelChanged();
    }

    public List<T> listar() {
        GenericDAO dao=obtenerImplementacionDAO();
        return dao.list();

    }

    abstract GenericDAO obtenerImplementacionDAO();

}
