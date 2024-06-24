package controlador;

import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import vista.cliente.ClienteView;

public class ClienteControllerImpl extends AbstractControllerImpl<ClienteModel, ClienteView, String> implements ClienteController{
    
    @Override
    protected Cliente generaEntidad(List<String> datos){
        String DNI=datos.get(0);
        String nombre=datos.get(1);
        String direccion=datos.get(2);
        Cliente c=new ClienteImpl(DNI);
        c.setNombre(nombre);
        c.setDireccion(direccion);
        return c;

    }
    @Override
    protected Cliente generaEntidad(String pk){
        return new ClienteImpl(pk);
    }

    @Override
    public List<Cliente> listaClienteEntidadGesture (){
        return getModel().listar();
    }
    
}
