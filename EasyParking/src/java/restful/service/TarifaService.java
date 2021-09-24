
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.model.Conexion;
import restful.model.TarifaModel;


public class TarifaService {
    public ArrayList<TarifaModel> getTarifas() {
        ArrayList<TarifaModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM tarifa";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                TarifaModel tarifa = new TarifaModel();
                tarifa.setId_tarifa(rs.getString("id_tarifa"));
                tarifa.setValor_tar(rs.getDouble("valor_tar"));
                tarifa.setNombre_tar(rs.getString("nombre_tar"));
                lista.add(tarifa);                              
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public TarifaModel getTarifa(String id_tarifa) {
        TarifaModel tarifa = new TarifaModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM tarifa WHERE id_tarifa = ?";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id_tarifa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tarifa.setId_tarifa(rs.getString("id_tarifa"));
                tarifa.setValor_tar(rs.getDouble("valor_tar"));
                tarifa.setNombre_tar(rs.getString("nombre_tar"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return tarifa;
    }

    public TarifaModel addTarifa(TarifaModel tarifa) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO tarifa(id_tarifa,valor_tar,nombre_tar)";
        Sql = Sql + "values (?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, tarifa.getId_tarifa());
            pstm.setDouble(2, tarifa.getValor_tar());
            pstm.setString(3, tarifa.getNombre_tar());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return tarifa;
    }

    public TarifaModel updateTarifa(TarifaModel tarifa) {
        Conexion conn = new Conexion();
        String sql = "UPDATE tarifa SET valor_tar=?,nombre_tar=? WHERE id_tarifa=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setDouble(1, tarifa.getValor_tar());
            pstm.setString(2, tarifa.getNombre_tar());
            pstm.setString(3, tarifa.getId_tarifa());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return tarifa;
    }

    public String delTarifa(String id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM tarifa WHERE id_tarifa= ?";
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
