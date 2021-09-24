
package restful.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement  
public class UsuarioModel {
    private String id_usuario;
    private String nombre_usu;
    private String telefono_usu;
    private String email_usu;
    private String direccion_usu;
    private String id_rol;
    private String user;
    private String password;
    
   
    public UsuarioModel() {
    }

    public UsuarioModel(String id_usuario, String nombre_usu, String telefono_usu, String email_usu, String direccion_usu, String id_rol, String user, String password) {
        this.id_usuario = id_usuario;
        this.nombre_usu = nombre_usu;
        this.telefono_usu = telefono_usu;
        this.email_usu = email_usu;
        this.direccion_usu = direccion_usu;
        this.id_rol = id_rol;
        this.user = user;
        this.password = password;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public String getTelefono_usu() {
        return telefono_usu;
    }

    public void setTelefono_usu(String telefono_usu) {
        this.telefono_usu = telefono_usu;
    }

    public String getEmail_usu() {
        return email_usu;
    }

    public void setEmail_usu(String email_usu) {
        this.email_usu = email_usu;
    }

    public String getDireccion_usu() {
        return direccion_usu;
    }

    public void setDireccion_usu(String direccion_usu) {
        this.direccion_usu = direccion_usu;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
