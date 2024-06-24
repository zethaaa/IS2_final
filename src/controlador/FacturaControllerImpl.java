package controlador;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import vista.factura.FacturaView;

public class FacturaControllerImpl extends AbstractControllerImpl<FacturaModel, FacturaView, Serializable> implements FacturaController {

    @Override
    protected Factura generaEntidad(List<Serializable> datos) {

        String identificador = (String) datos.get(0);
        Cliente cliente = (Cliente) datos.get(1);
        String importe = (String) datos.get(2);
        Double impDouble = Double.valueOf(importe);
        Date fechaPago = (Date) datos.get(3);
        Factura f = new FacturaImpl(identificador, cliente, impDouble, fechaPago);
        f.setFechaPago(fechaPago);
        return f;

    }

    @Override
    protected Factura generaEntidad(Serializable pk) {
        return new FacturaImpl((String) pk);
    }

    @Override
    public List<Factura> listaFacturaEntidadGesture() {
        return getModel().listar();
    }

    @Override
    public List<Factura> listarFacuraEntidadPorClienteGesture(String nombre) {
        return getModel().listarPorCliente(nombre);
    }

    @Override
    public Date toDate(String fechaString) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC")); // Asegurar que se maneja la misma zona horaria

            java.util.Date fecha = null; // Variable que almacenará la fecha
// fechaEnString es de tipo String y contiene la fecha a convertir
            if (fechaString.length() > 0) {
                try {
                    fecha = formatter.parse(fechaString);
                } catch (ParseException ex) {

                    Logger.getLogger(FacturaControllerImpl.class.getName()).log(Level.SEVERE, null, ex);

                }
                return new java.sql.Date(fecha.getTime());

            }else {

                return null;
            }

        }


    @Override
    public List<Factura> listarFacuraEntidadPorFechaPagoGesture(String fechaPago) {


        return getModel().listarPorFecha(fechaPago);


    }

}
