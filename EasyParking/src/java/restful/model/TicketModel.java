
package restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TicketModel {
    private String id_ticket;
    private String hora_ent;
    private String id_vehiculo;
    private String id_plaza;

    public TicketModel() {
    }
    
    public TicketModel(String id_ticket, String hora_ent, String id_vehiculo, String id_plaza) {
        this.id_ticket = id_ticket;
        this.hora_ent = hora_ent;
        this.id_vehiculo = id_vehiculo;
        this.id_plaza = id_plaza;
    }

    public String getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(String id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getHora_ent() {
        return hora_ent;
    }

    public void setHora_ent(String hora_ent) {
        this.hora_ent = hora_ent;
    }

    public String getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(String id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getId_plaza() {
        return id_plaza;
    }

    public void setId_plaza(String id_plaza) {
        this.id_plaza = id_plaza;
    }
    
    
}
