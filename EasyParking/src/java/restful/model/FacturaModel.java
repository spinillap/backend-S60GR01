
package restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FacturaModel {
    private String id_factura;
    private String hora_sal;
    private String id_usuario;
    private String id_tarifa;
    private String id_ticket;
    private double valor_tot;

    public FacturaModel() {
    }

    public FacturaModel(String id_factura, String hora_sal, String id_usuario, String id_tarifa, String id_ticket, double valor_tot) {
        this.id_factura = id_factura;
        this.hora_sal = hora_sal;
        this.id_usuario = id_usuario;
        this.id_tarifa = id_tarifa;
        this.id_ticket = id_ticket;
        this.valor_tot = valor_tot;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getHora_sal() {
        return hora_sal;
    }

    public void setHora_sal(String hora_sal) {
        this.hora_sal = hora_sal;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(String id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public String getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(String id_ticket) {
        this.id_ticket = id_ticket;
    }

    public double getValor_tot() {
        return valor_tot;
    }

    public void setValor_tot(double valor_tot) {
        this.valor_tot = valor_tot;
    }
    
    
}
