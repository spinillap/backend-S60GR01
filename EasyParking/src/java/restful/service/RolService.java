
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.model.Conexion;
import restful.model.RolModel;


public class RolService {
    public ArrayList<RolModel> getRoles() {
        ArrayList<RolModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM rol";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                RolModel rol = new RolModel();
                rol.setId_rol(rs.getString("id_rol"));
                rol.setNombre_rol(rs.getString("nombre_rol"));
                lista.add(rol);                              
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public RolModel getRol(String id_rol) {
        RolModel rol = new RolModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM rol WHERE id_rol = ?";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id_rol);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                rol.setId_rol(rs.getString("id_rol"));
                rol.setNombre_rol(rs.getString("nombre_rol"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return rol;
    }

    public RolModel addRol(RolModel rol) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO rol(id_rol,nombre_rol)";
        Sql = Sql + "values (?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, rol.getId_rol());
            pstm.setString(2, rol.getNombre_rol());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return rol;
    }

    public RolModel updateRol(RolModel rol) {
        Conexion conn = new Conexion();
        String sql = "UPDATE rol SET nombre_rol=? WHERE id_rol=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, rol.getNombre_rol());
            pstm.setString(2, rol.getId_rol());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return rol;
    }

    public String delRol(String id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM rol WHERE id_rol= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, id);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Registro Borrado\"}";
    }
}
