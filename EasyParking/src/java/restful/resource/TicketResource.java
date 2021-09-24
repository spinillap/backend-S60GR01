
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
import restful.model.TicketModel;
import restful.service.TicketService;

@Path("tickets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketResource {
    TicketService servicio = new TicketService();

    @GET
    public ArrayList<TicketModel> getTickets() {

        return servicio.getTickets();
    }

    @Path("/{TicketId}")
    @GET
    public TicketModel getTicket(@PathParam("TicketId") String id) {

        return servicio.getTicket(id);
    }

    @POST
    public TicketModel addTicket(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        TicketModel ticket = gson.fromJson(JSON, TicketModel.class);
        return servicio.addTicket(ticket);
    }

    @DELETE
    @Path("/{TicketId}")
    public String delTicket(@PathParam("TicketId") String id) {

        return servicio.delTicket(id);

    }

    @PUT
    public TicketModel updateTicket(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        TicketModel ticket = gson.fromJson(JSON, TicketModel.class);
        return servicio.updateTicket(ticket);
    }
}
