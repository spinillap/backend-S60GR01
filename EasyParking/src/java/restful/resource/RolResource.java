
package restful.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restful.model.RolModel;
import restful.service.RolService;


@Path("roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RolResource {
    RolService servicio = new RolService();
    
    @GET
    public ArrayList<RolModel> getRoles() {

        return servicio.getRoles();
    }

    @Path("/{RolId}")
    @GET
    public RolModel getRol(@PathParam("RolId") String id) {

        return servicio.getRol(id);
    }

    @POST
    public RolModel addRol(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        RolModel rol = gson.fromJson(JSON, RolModel.class);
        
        return servicio.addRol(rol);
    }

    @DELETE
    @Path("/{RolId}")
    public String delRol(@PathParam("RolId") String id) {

        return servicio.delRol(id);

    }

    @PUT
    public RolModel updateRol(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        RolModel rol = gson.fromJson(JSON, RolModel.class);
        return servicio.updateRol(rol);
    }
}
