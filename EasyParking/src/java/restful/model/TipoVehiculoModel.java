
package restful.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TipoVehiculoModel {
    private String id_tipo_veh;
    private String nombre_tipo_veh;

    public TipoVehiculoModel() {
    }

    public TipoVehiculoModel(String id_tipo_veh, String nombre_tipo_veh) {
        this.id_tipo_veh = id_tipo_veh;
        this.nombre_tipo_veh = nombre_tipo_veh;
    }

    public String getId_tipo_veh() {
        return id_tipo_veh;
    }

    public void setId_tipo_veh(String id_tipo_veh) {
        this.id_tipo_veh = id_tipo_veh;
    }

    public String getNombre_tipo_veh() {
        return nombre_tipo_veh;
    }

    public void setNombre_tipo_veh(String nombre_tipo_veh) {
        this.nombre_tipo_veh = nombre_tipo_veh;
    }
    
    
}
