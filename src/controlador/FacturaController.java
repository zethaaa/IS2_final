package controlador;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import modelo.FacturaModel;
import modelo.entidades.Factura;
import vista.factura.FacturaView;


public interface FacturaController extends Controller<FacturaModel, FacturaView, Serializable> {

    public List<Factura> listaFacturaEntidadGesture();

    public List<Factura> listarFacuraEntidadPorClienteGesture(String nombre);

    public List<Factura> listarFacuraEntidadPorFechaPagoGesture(String fechaPago);

    Date toDate(String fecha);


}
