
package restful.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PlacaModel {
    private String id_vehiculo;
    private String id_tipo_veh;

    public PlacaModel() {
    }

    public PlacaModel(String id_vehiculo, String id_tipo_veh) {
        this.id_vehiculo = id_vehiculo;
        this.id_tipo_veh = id_tipo_veh;
    }

    public String getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(String id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getId_tipo_veh() {
        return id_tipo_veh;
    }

    public void setId_tipo_veh(String id_tipo_veh) {
        this.id_tipo_veh = id_tipo_veh;
    }
    
    
}
