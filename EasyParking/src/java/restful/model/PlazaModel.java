
package restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlazaModel {
    private String id_plaza;
    private int numero_pla;
    private String estado_pla;

    public PlazaModel() {
    }

    public PlazaModel(String id_plaza, int numero_pla, String estado_pla) {
        this.id_plaza = id_plaza;
        this.numero_pla = numero_pla;
        this.estado_pla = estado_pla;
    }

    public String getId_plaza() {
        return id_plaza;
    }

    public void setId_plaza(String id_plaza) {
        this.id_plaza = id_plaza;
    }

    public int getNumero_pla() {
        return numero_pla;
    }

    public void setNumero_pla(int numero_pla) {
        this.numero_pla = numero_pla;
    }

    public String getEstado_pla() {
        return estado_pla;
    }

    public void setEstado_pla(String estado_pla) {
        this.estado_pla = estado_pla;
    }
    
    
}
