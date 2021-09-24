
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
import restful.model.PlazaModel;
import restful.service.PlazaService;

@Path("plazas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlazaResource {
    PlazaService servicio = new PlazaService();
    
    @GET
    public ArrayList<PlazaModel> getPlazas() {

        return servicio.getPlazas();
    }

    @Path("/{PlazaId}")
    @GET
    public PlazaModel getPlaza(@PathParam("PlazaId") String id) {

        return servicio.getPlaza(id);
    }

    @POST
    public PlazaModel addPlaza(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        PlazaModel plaza = gson.fromJson(JSON, PlazaModel.class);
        
        return servicio.addPlaza(plaza);
    }

    @DELETE
    @Path("/{PlazaId}")
    public String delPlaza(@PathParam("PlazaId") String id) {

        return servicio.delPlaza(id);

    }

    @PUT
    public PlazaModel updatePlaza(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        PlazaModel plaza = gson.fromJson(JSON, PlazaModel.class);
        return servicio.updatePlaza(plaza);
    }
}
