package main;


import controlador.ClienteController;
import controlador.ClienteControllerImpl;
import controlador.FacturaController;
import controlador.FacturaControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.ClienteModel;
import modelo.ClienteModelImpl;
import modelo.FacturaModel;
import modelo.FacturaModelImpl;
import vista.cliente.ClienteView;
import vista.cliente.ClienteViewImpl;
import vista.VistaGlobal;
import vista.factura.FacturaView;
import vista.factura.FacturaViewImpl;


public class SingleEntryPoint {


    public static void main(String[] args) {

        ClienteModel clienteModel = new ClienteModelImpl();

        
        ClienteView clienteView1 =new ClienteViewImpl();
        List<ClienteView> clienteViews= new ArrayList<ClienteView>();
        clienteViews.add(clienteView1);


        ClienteController clienteController = new ClienteControllerImpl();
        
        clienteController.setup(clienteModel, clienteViews);


        FacturaModel facturaModel = new FacturaModelImpl();


        FacturaView facturaView1 =new FacturaViewImpl();
        List<FacturaView> facturaViews= new ArrayList<FacturaView>();
        facturaViews.add(facturaView1);

        FacturaController facturaController = new FacturaControllerImpl();

        facturaController.setup(facturaModel, facturaViews);
        

        VistaGlobal vista1=new VistaGlobal(clienteView1,facturaView1);
        vista1.display();

    }

}
