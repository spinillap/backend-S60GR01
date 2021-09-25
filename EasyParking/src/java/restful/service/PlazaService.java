
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.model.Conexion;
import restful.model.PlazaModel;


public class PlazaService {
    public ArrayList<PlazaModel> getPlazas() {
        ArrayList<PlazaModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM plaza";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                PlazaModel plaza = new PlazaModel();
                plaza.setId_plaza(rs.getString("id_plaza"));
                plaza.setNumero_pla(rs.getInt("numero_pla"));
                plaza.setEstado_pla(rs.getString("estado_pla"));
                lista.add(plaza);                              
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public PlazaModel getPlaza(String id_plaza) {
        PlazaModel plaza = new PlazaModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM plaza WHERE id_plaza = ?";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id_plaza);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                plaza.setId_plaza(rs.getString("id_plaza"));
                plaza.setNumero_pla(rs.getInt("numero_pla"));
                plaza.setEstado_pla(rs.getString("estado_pla"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return plaza;
    }

    public PlazaModel addPlaza(PlazaModel plaza) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO plaza(id_plaza,numero_pla,estado_pla)";
        Sql = Sql + "values (?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, plaza.getId_plaza());
            pstm.setInt(2, plaza.getNumero_pla());
            pstm.setString(3, plaza.getEstado_pla());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return plaza;
    }

    public PlazaModel updatePlaza(PlazaModel plaza) {
        Conexion conn = new Conexion();
        String sql = "UPDATE plaza SET numero_pla=?,estado_pla=? WHERE id_plaza=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, plaza.getNumero_pla());
            pstm.setString(2, plaza.getEstado_pla());
            pstm.setString(3, plaza.getId_plaza());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return plaza;
    }

    public String delPlaza(String id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM plaza WHERE id_plaza= ?";
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
