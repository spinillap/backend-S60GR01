
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.model.Conexion;
import restful.model.FacturaModel;


public class FacturaService {
    public ArrayList<FacturaModel> getFacturas() {
        ArrayList<FacturaModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM factura";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                FacturaModel factura = new FacturaModel();
                factura.setId_factura(rs.getString("id_factura"));
                factura.setHora_sal(rs.getString("hora_sal"));
                factura.setId_usuario(rs.getString("id_usuario"));
                factura.setId_tarifa(rs.getString("id_tarifa"));
                factura.setId_ticket(rs.getString("id_ticket"));
                factura.setValor_tot(rs.getDouble("valor_tot"));
                lista.add(factura);                              
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public FacturaModel getFactura(String id_factura) {
        FacturaModel factura = new FacturaModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM factura WHERE id_factura = ?";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id_factura);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                factura.setId_factura(rs.getString("id_factura"));
                factura.setHora_sal(rs.getString("hora_sal"));
                factura.setId_usuario(rs.getString("id_usuario"));
                factura.setId_tarifa(rs.getString("id_tarifa"));
                factura.setId_ticket(rs.getString("id_ticket"));
                factura.setValor_tot(rs.getDouble("valor_tot"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return factura;
    }

    public FacturaModel addFactura(FacturaModel factura) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO factura(id_factura,hora_sal,id_usuario,id_tarifa,id_ticket,valor_tot)";
        Sql = Sql + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, factura.getId_factura());
            pstm.setString(2, factura.getHora_sal());
            pstm.setString(3, factura.getId_usuario());
            pstm.setString(4, factura.getId_tarifa());
            pstm.setString(5, factura.getId_ticket());
            pstm.setDouble(6, factura.getValor_tot());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return factura;
    }

    public FacturaModel updateFactura(FacturaModel factura) {
        Conexion conn = new Conexion();
        String sql = "UPDATE factura SET hora_sal=?,id_usuario=?,id_tarifa=?,id_ticket=?,valor_tot=? WHERE id_tarifa=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, factura.getHora_sal());
            pstm.setString(2, factura.getId_usuario());
            pstm.setString(3, factura.getId_tarifa());
            pstm.setString(4, factura.getId_ticket());
            pstm.setDouble(5, factura.getValor_tot());
            pstm.setString(6, factura.getId_factura());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return factura;
    }

    public String delFactura(String id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM factura WHERE id_factura= ?";
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
