
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
import restful.model.TarifaModel;
import restful.service.TarifaService;

@Path("tarifas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarifaResource {
    TarifaService servicio = new TarifaService();
    
    @GET
    public ArrayList<TarifaModel> getTarifas() {

        return servicio.getTarifas();
    }

    @Path("/{TarifaId}")
    @GET
    public TarifaModel getTarifa(@PathParam("TarifaId") String id) {

        return servicio.getTarifa(id);
    }

    @POST
    public TarifaModel addTarifa(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        TarifaModel tarifa = gson.fromJson(JSON, TarifaModel.class);
        
        return servicio.addTarifa(tarifa);
    }

    @DELETE
    @Path("/{TarifaId}")
    public String delTarifa(@PathParam("TarifaId") String id) {

        return servicio.delTarifa(id);

    }

    @PUT
    public TarifaModel updateTarifa(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        TarifaModel tarifa = gson.fromJson(JSON, TarifaModel.class);
        return servicio.updateTarifa(tarifa);
    }
}
