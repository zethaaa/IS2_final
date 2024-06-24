package modelo.persistencia.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import modelo.persistencia.FacturaDAO;

public class FacturaDAOJDBC implements FacturaDAO {

    public List<Factura> listByCliente(String dni) {
        List<Factura> facturas = new ArrayList<Factura>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM vfacturas where DNI=" + dni);
            String nombre, direccion, id_factura;
            Date fechaPago;
            Double importe;
            while (res.next()) {
                //DNI = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                id_factura = res.getString("identificador");
                importe = res.getDouble("importe");
                fechaPago = res.getDate("Pendiente_de_pago");
                //creo cliente
                Cliente cliente = new ClienteImpl(dni, nombre, direccion);
                //Añado la factura
                facturas.add(new FacturaImpl(id_factura, cliente, importe, fechaPago));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return facturas;
    }
    public List<Factura> listByFecha(String fecha) {
        List<Factura> facturas = new ArrayList<Factura>();
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res;
            if (fecha.equals("")){
                res = stmt.executeQuery("SELECT * FROM facturas f,vfacturas vf WHERE vf.id_cliente =f.id_cliente AND Pendiente_de_pago IS NULL");
            }else {
                 res = stmt.executeQuery("SELECT * FROM facturas f,vfacturas vf WHERE vf.id_cliente =f.id_cliente AND EXTRACT(YEAR FROM Pendiente_de_pago)=" + Integer.valueOf(fecha));
            }String nombre, direccion, id_factura,DNI;
            Date fechaPago;
            Double importe;
            while (res.next()) {
                DNI = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                id_factura = res.getString("identificador");
                importe = res.getDouble("importe");
                fechaPago = res.getDate("Pendiente_de_pago");
                //creo cliente
                Cliente cliente = new ClienteImpl(DNI, nombre, direccion);
                //Añado la factura
                facturas.add(new FacturaImpl(id_factura, cliente, importe, fechaPago));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return facturas;
    }

    public void create(Factura entidad) {
        String sql = "insert into facturas(identificador,id_cliente,importe, Pendiente_de_pago) values (?,?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getIdentificador());
            stm.setString(2, entidad.getCliente().getDNI());
            stm.setDouble(3, entidad.getImporte());
            stm.setDate(4, entidad.getFechaPago());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Factura read(String pk) {
        Factura f = null;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM facturas where identificador=" + pk);
            String identificador, id_cliente;
            Double importe;
            Date fechaPago;
            if (res.next()) {
                identificador = res.getString("identificador");
                id_cliente = res.getString("id_cliente");
                importe = res.getDouble("importe");
                fechaPago = res.getDate("Pendiente de pago");
                //Leo el w  
                Cliente cliente = (new ClienteDAOJDBC()).read(id_cliente);
                //Creo la factura
                f = new FacturaImpl(identificador, cliente, importe,fechaPago);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return f;
    }

    public void update(Factura entidad) {
        String sql = "update facturas set id_cliente=?, importe=?, Pendiente_de_pago=? where identificador like ?";

        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(4, entidad.getIdentificador());
            stm.setString(1, entidad.getCliente().getDNI());
            stm.setDouble(2, entidad.getImporte());
            stm.setDate(3,entidad.getFechaPago());
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void delete(Factura entidad) {
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate("DELETE FROM facturas where identificador=" + entidad.getIdentificador());


        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public List<Factura> list() {
        List<Factura> facturas = new ArrayList<Factura>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM vfacturas INNER JOIN facturas ON vfacturas.id_cliente=facturas.id_cliente");


            String DNI, nombre, direccion, id_factura;
            Date fechaPago;
            Double importe;
            while (res.next()) {
                DNI = res.getString("dni");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                id_factura = res.getString("identificador");
                importe = res.getDouble("importe");
                fechaPago =res.getDate("Pendiente_de_pago");
                //creo cliente
                Cliente cliente = new ClienteImpl(DNI, nombre, direccion);
                //Añado la factura
                facturas.add(new FacturaImpl(id_factura, cliente, importe,fechaPago));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return facturas;
    }
}
