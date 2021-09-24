
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.model.Conexion;
import restful.model.PlacaModel;


public class PlacaService {
    public ArrayList<PlacaModel> getPlacas() {
        ArrayList<PlacaModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM placa";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                PlacaModel placa = new PlacaModel();
                placa.setId_vehiculo(rs.getString("id_vehiculo"));
                placa.setId_tipo_veh(rs.getString("id_tipo_veh"));
                lista.add(placa);                              
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public PlacaModel getPlaca(String id_vehiculo) {
        PlacaModel placa = new PlacaModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM placa WHERE id_vehiculo = ?";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id_vehiculo);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                placa.setId_vehiculo(rs.getString("id_vehiculo"));
                placa.setId_tipo_veh(rs.getString("id_tipo_veh"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return placa;
    }

    public PlacaModel addPlaca(PlacaModel placa) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO placa(id_vehiculo,id_tipo_veh)";
        Sql = Sql + "values (?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, placa.getId_vehiculo());
            pstm.setString(2, placa.getId_tipo_veh());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return placa;
    }

    public PlacaModel updatePlaca(PlacaModel placa) {
        Conexion conn = new Conexion();
        String sql = "UPDATE placa SET id_tipo_veh=? WHERE id_vehiculo=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, placa.getId_tipo_veh());
            pstm.setString(2, placa.getId_vehiculo());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return placa;
    }

    public String delPlaca(String id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM placa WHERE id_vehiculo= ?";
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
