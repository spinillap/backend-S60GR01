
package restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TarifaModel {
    private String id_tarifa;
    private double valor_tar;
    private String nombre_tar;

    public TarifaModel() {
    }

    public TarifaModel(String id_tarifa, double valor_tar, String nombre_tar) {
        this.id_tarifa = id_tarifa;
        this.valor_tar = valor_tar;
        this.nombre_tar = nombre_tar;
    }

    public String getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(String id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public double getValor_tar() {
        return valor_tar;
    }

    public void setValor_tar(double valor_tar) {
        this.valor_tar = valor_tar;
    }

    public String getNombre_tar() {
        return nombre_tar;
    }

    public void setNombre_tar(String nombre_tar) {
        this.nombre_tar = nombre_tar;
    } 
    
}
