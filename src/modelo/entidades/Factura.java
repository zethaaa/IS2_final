package modelo.entidades;

import java.io.Serializable;
import java.sql.Date;

public interface Factura extends Entidad{
    
    public String getIdentificador();
    public Cliente getCliente();
    public Double getImporte();
    
    public void setIdentificador(String id);

    void setCliente(Cliente cl);
    void setImporte(Double im);
    public Date getFechaPago() ;
    public void setFechaPago(Date fechaPago);


    }
