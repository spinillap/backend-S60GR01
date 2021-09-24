
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.model.Conexion;
import restful.model.TicketModel;


public class TicketService {
    public ArrayList<TicketModel> getTickets() {
        ArrayList<TicketModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM ticket";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                TicketModel ticket = new TicketModel();
                ticket.setId_ticket(rs.getString("id_ticket"));
                ticket.setHora_ent(rs.getString("hora_ent"));
                ticket.setId_vehiculo(rs.getString("id_vehiculo"));
                ticket.setId_plaza(rs.getString("id_plaza"));
                lista.add(ticket);                              
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public TicketModel getTicket(String id_ticket) {
        TicketModel ticket = new TicketModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM ticket WHERE id_ticket = ?";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id_ticket);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ticket.setId_ticket(rs.getString("id_ticket"));
                ticket.setHora_ent(rs.getString("hora_ent"));
                ticket.setId_vehiculo(rs.getString("id_vehiculo"));
                ticket.setId_plaza(rs.getString("id_plaza"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return ticket;
    }

    public TicketModel addTicket(TicketModel ticket) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO ticket(id_ticket,hora_ent,id_vehiculo,id_plaza)";
        Sql = Sql + "values (?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, ticket.getId_ticket());
            pstm.setString(2, ticket.getHora_ent());
            pstm.setString(3, ticket.getId_vehiculo());
            pstm.setString(4, ticket.getId_plaza());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return ticket;
    }

    public TicketModel updateTicket(TicketModel ticket) {
        Conexion conn = new Conexion();
        String sql = "UPDATE ticket SET hora_ent=?,id_vehiculo=?,id_plaza=? WHERE id_ticket=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, ticket.getHora_ent());
            pstm.setString(2, ticket.getId_vehiculo());
            pstm.setString(3, ticket.getId_plaza());
            pstm.setString(4, ticket.getId_ticket());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return ticket;
    }

    public String delTicket(String id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM ticket WHERE id_ticket= ?";
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
