
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.model.UsuarioModel;
import restful.model.Conexion;

public class UsuarioService {
    public ArrayList<UsuarioModel> getUsuarios() {
        ArrayList<UsuarioModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM usuario";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId_usuario(rs.getString("id_usuario"));
                usuario.setNombre_usu(rs.getString("nombre_usu"));
                usuario.setTelefono_usu(rs.getString("telefono_usu"));
                usuario.setEmail_usu(rs.getString("email_usu"));
                usuario.setDireccion_usu(rs.getString("direccion_usu"));
                usuario.setId_rol(rs.getString("id_rol"));
                usuario.setUser(rs.getString("user"));
                usuario.setPassword(rs.getString("password"));
                lista.add(usuario);                              
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public UsuarioModel getUsuario(String id_usuario) {
        UsuarioModel usuario = new UsuarioModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id_usuario);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                usuario.setId_usuario(rs.getString("id_usuario"));
                usuario.setNombre_usu(rs.getString("nombre_usu"));
                usuario.setTelefono_usu(rs.getString("telefono_usu"));
                usuario.setEmail_usu(rs.getString("email_usu"));
                usuario.setDireccion_usu(rs.getString("direccion_usu"));
                usuario.setId_rol(rs.getString("id_rol"));
                usuario.setUser(rs.getString("user"));
                usuario.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuario;
    }

    public UsuarioModel addUsuario(UsuarioModel usuario) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO usuario(id_usuario,nombre_usu,telefono_usu,email_usu,direccion_usu,id_rol,user,password)";
        Sql = Sql + "values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, usuario.getId_usuario());
            pstm.setString(2, usuario.getNombre_usu());
            pstm.setString(3, usuario.getTelefono_usu());
            pstm.setString(4, usuario.getEmail_usu());
            pstm.setString(5, usuario.getDireccion_usu());
            pstm.setString(6, usuario.getId_rol());
            pstm.setString(7, usuario.getUser());
            pstm.setString(8, usuario.getPassword());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return usuario;
    }

    public UsuarioModel updateUsuario(UsuarioModel usuario) {
        Conexion conn = new Conexion();
        String sql = "UPDATE usuario SET nombre_usu=?,telefono_usu=?,email_usu=?,direccion_usu=?,id_rol=?,user=?,password=? WHERE id_usuario=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, usuario.getNombre_usu());
            pstm.setString(2, usuario.getTelefono_usu());
            pstm.setString(3, usuario.getEmail_usu());
            pstm.setString(4, usuario.getDireccion_usu());
            pstm.setString(5, usuario.getId_rol());
            pstm.setString(6, usuario.getUser());
            pstm.setString(7, usuario.getPassword());
            pstm.setString(8, usuario.getId_usuario());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return usuario;
    }

    public String delUsuario(String id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM usuario WHERE id_usuario= ?";
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
