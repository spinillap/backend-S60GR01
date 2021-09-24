
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.model.Conexion;
import restful.model.TipoVehiculoModel;


public class TipoVehiculoService {
    public ArrayList<TipoVehiculoModel> getTipoVehiculos() {
        ArrayList<TipoVehiculoModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM tipo_vehiculo";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                TipoVehiculoModel tipo_vehiculo = new TipoVehiculoModel();
                tipo_vehiculo.setId_tipo_veh(rs.getString("id_tipo_veh"));
                tipo_vehiculo.setNombre_tipo_veh(rs.getString("nombre_tipo_veh"));
                lista.add(tipo_vehiculo);                              
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public TipoVehiculoModel getTipoVehiculo(String id_tipo_vehiculo) {
        TipoVehiculoModel tipo_vehiculo = new TipoVehiculoModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM tipo_vehiculo WHERE id_tipo_vehiculo = ?";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id_tipo_vehiculo);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tipo_vehiculo.setId_tipo_veh(rs.getString("id_tipo_veh"));
                tipo_vehiculo.setNombre_tipo_veh(rs.getString("nombre_tipo_veh"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return tipo_vehiculo;
    }

    public TipoVehiculoModel addTipoVehiculo(TipoVehiculoModel tipo_vehiculo) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO tipo_vehiculo(id_tipo_veh,nombre_tipo_veh)";
        Sql = Sql + "values (?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, tipo_vehiculo.getId_tipo_veh());
            pstm.setString(2, tipo_vehiculo.getNombre_tipo_veh());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return tipo_vehiculo;
    }

    public TipoVehiculoModel updateTipoVehiculo(TipoVehiculoModel tipo_vehiculo) {
        Conexion conn = new Conexion();
        String sql = "UPDATE tipo_vehiculo SET nombre_tipo_veh=? WHERE id_tipo_veh=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, tipo_vehiculo.getNombre_tipo_veh());
            pstm.setString(2, tipo_vehiculo.getId_tipo_veh());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return tipo_vehiculo;
    }

    public String delTipoVehiculo(String id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM tipo_vehiculo WHERE id_tipo_veh= ?";
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
