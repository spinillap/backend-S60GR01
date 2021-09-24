
package restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RolModel {
    private String id_rol;
    private String nombre_rol;

    public RolModel() {
    }

    public RolModel(String id_rol, String nombre_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    
}
