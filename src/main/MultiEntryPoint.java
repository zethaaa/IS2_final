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



public class MultiEntryPoint {


    public static void main(String[] args) {

        ClienteModel clienteModel = new ClienteModelImpl();

        
        ClienteView clienteView1 =new ClienteViewImpl();
        ClienteView clienteView2 =new ClienteViewImpl();
        List<ClienteView> clienteViews= new ArrayList<ClienteView>();
        clienteViews.add(clienteView1);
        clienteViews.add(clienteView2);

        ClienteController clienteController = new ClienteControllerImpl();
        
        clienteController.setup(clienteModel, clienteViews);


        FacturaModel facturaModel = new FacturaModelImpl();


        FacturaView facturaView1 =new FacturaViewImpl();
        FacturaView facturaView2 =new FacturaViewImpl();
        List<FacturaView> facturaViews= new ArrayList<FacturaView>();
        facturaViews.add(facturaView1);
        facturaViews.add(facturaView2);

        FacturaController facturaController = new FacturaControllerImpl();

        facturaController.setup(facturaModel, facturaViews);
        

        VistaGlobal vista1=new VistaGlobal(clienteView1,facturaView1);
        VistaGlobal vista2=new VistaGlobal(clienteView2,facturaView2);
        vista1.display();
        vista2.display();

    }

}
