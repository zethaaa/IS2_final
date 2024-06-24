package modelo.entidades;

import java.io.Serializable;

public interface Cliente extends Entidad {
    
    public String getDNI();
    public String getNombre();
    public String getDireccion();
    
    public void setDNI(String dni);
    public void setNombre(String nombre);
    public void setDireccion(String direccion);
}
