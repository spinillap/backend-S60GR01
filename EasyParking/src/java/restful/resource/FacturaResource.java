
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
import restful.model.FacturaModel;
import restful.service.FacturaService;

@Path("facturas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturaResource {
    FacturaService servicio = new FacturaService();

    @GET
    public ArrayList<FacturaModel> getFacturas() {

        return servicio.getFacturas();
    }

    @Path("/{FacturaId}")
    @GET
    public FacturaModel getFactura(@PathParam("FacturaId") String id) {

        return servicio.getFactura(id);
    }

    @POST
    public FacturaModel addFactura(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        FacturaModel factura = gson.fromJson(JSON, FacturaModel.class);
        return servicio.addFactura(factura);
    }

    @DELETE
    @Path("/{FacturaId}")
    public String delFactura(@PathParam("FacturaId") String id) {

        return servicio.delFactura(id);

    }

    @PUT
    public FacturaModel updateFactura(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        FacturaModel factura = gson.fromJson(JSON, FacturaModel.class);
        return servicio.updateFactura(factura);
    }
}
