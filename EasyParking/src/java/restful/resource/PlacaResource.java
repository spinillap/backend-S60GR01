
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
import restful.model.PlacaModel;
import restful.service.PlacaService;


@Path("placas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlacaResource {
    PlacaService servicio = new PlacaService();
    
    @GET
    public ArrayList<PlacaModel> getPlacas() {

        return servicio.getPlacas();
    }

    @Path("/{PlacaId}")
    @GET
    public PlacaModel getPlaca(@PathParam("PlacaId") String id) {

        return servicio.getPlaca(id);
    }

    @POST
    public PlacaModel addPlaca(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        PlacaModel placa = gson.fromJson(JSON, PlacaModel.class);
        
        return servicio.addPlaca(placa);
    }

    @DELETE
    @Path("/{PlacaId}")
    public String delPlaca(@PathParam("PlacaId") String id) {

        return servicio.delPlaca(id);

    }

    @PUT
    public PlacaModel updatePlaca(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        PlacaModel rol = gson.fromJson(JSON, PlacaModel.class);
        return servicio.updatePlaca(rol);
    }
}
