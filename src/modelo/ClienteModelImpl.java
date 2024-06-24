package modelo;

import modelo.entidades.Cliente;
import controlador.ClienteController;
import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.ClienteDAOJDBC;

public class ClienteModelImpl extends AbstractModelImpl<ClienteController,Cliente,String> implements ClienteModel{

    protected GenericDAO obtenerImplementacionDAO(){
        return new ClienteDAOJDBC();
        //return new ClienteDAOJPA();
    }

}
