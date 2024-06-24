package controlador;

import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import vista.cliente.ClienteView;


public interface ClienteController extends Controller<ClienteModel, ClienteView, String>{
    
    public List<Cliente> listaClienteEntidadGesture ();
}
