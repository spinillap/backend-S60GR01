
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
import restful.model.TipoVehiculoModel;
import restful.service.TipoVehiculoService;


@Path("tipo-vehiculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoVehiculoResource {
    TipoVehiculoService servicio = new TipoVehiculoService();
    
    @GET
    public ArrayList<TipoVehiculoModel> getTipoVehiculos() {

        return servicio.getTipoVehiculos();
    }

    @Path("/{TipoVehiculoId}")
    @GET
    public TipoVehiculoModel getTipoVehiculo(@PathParam("TipoVehiculoId") String id) {

        return servicio.getTipoVehiculo(id);
    }

    @POST
    public TipoVehiculoModel addRol(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        TipoVehiculoModel rol = gson.fromJson(JSON, TipoVehiculoModel.class);
        
        return servicio.addTipoVehiculo(rol);
    }

    @DELETE
    @Path("/{TipoVehiculoId}")
    public String delTipoVehiculo(@PathParam("TipoVehiculoId") String id) {

        return servicio.delTipoVehiculo(id);

    }

    @PUT
    public TipoVehiculoModel updateRol(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        TipoVehiculoModel rol = gson.fromJson(JSON, TipoVehiculoModel.class);
        return servicio.updateTipoVehiculo(rol);
    }
}
