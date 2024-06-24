package modelo.entidades;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class FacturaImpl implements Factura {

    private String identificador;
    private Cliente cliente;
    private Double importe;
    private Date fechaPago;
    public FacturaImpl(String identifiador, Cliente cliente, Double importe,Date fechaPago) {
        this.identificador = identifiador;
        this.cliente = cliente;
        this.importe = importe;
        this.fechaPago = fechaPago;
    }

    public FacturaImpl(String identifiador, Cliente cliente, Double importe) {
        this.identificador = identifiador;
        this.cliente = cliente;
        this.importe = importe;
        this.fechaPago = null;
    }
    public FacturaImpl(String identificador) {
        this(identificador,null,null,null);
    }

    @Override
    public String getIdentificador() {
        return this.identificador;
    }

    @Override
    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public Double getImporte() {
        return this.importe;
    }

    @Override
    public void setIdentificador(String id) {
        this.identificador = id;
    }

    @Override
    public void setCliente(Cliente cl) {

    }

    @Override
    public void setImporte(Double im) {

    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
