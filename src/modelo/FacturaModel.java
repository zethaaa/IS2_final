package modelo;


import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Factura;

public interface FacturaModel extends Model<FacturaController,Factura,String>{
    List<Factura> listarPorCliente(String nombre);
    List<Factura> listarPorFecha(String fecha);


}
