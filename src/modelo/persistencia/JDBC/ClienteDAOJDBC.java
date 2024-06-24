package modelo.persistencia.JDBC;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.persistencia.ClienteDAO;

public class ClienteDAOJDBC implements ClienteDAO {

    public void create(Cliente entidad) {

        String sql = "insert into clientes(dni,nombre,direccion) values (?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getDNI());
            stm.setString(2, entidad.getNombre());
            stm.setString(3, entidad.getDireccion());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Cliente read(String pk) {
        Cliente c = null;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM clientes where DNI=" + pk);
            String dni, nombre, direccion;
            if (res.next()) {
                dni = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                c = new ClienteImpl(dni, nombre, direccion);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return c;
    }

    public void update(Cliente entidad) {
        String sql = "update clientes set nombre=?, direccion=? where DNI like ?";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getNombre());
            stm.setString(2, entidad.getDireccion());
            stm.setString(3, entidad.getDNI());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void delete(Cliente entidad) {
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate("DELETE FROM clientes where DNI=" + entidad.getDNI());



        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public List<Cliente> list() {
        List<Cliente> contactos = new ArrayList<Cliente>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM clientes ");
            String dni, nombre, direccion;
            while (res.next()) {

                dni = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                contactos.add(new ClienteImpl(dni, nombre, direccion));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return contactos;
    }
}
