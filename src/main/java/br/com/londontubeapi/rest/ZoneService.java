package br.com.londontubeapi.rest;

import br.com.londontubeapi.controler.ZoneControler;
import br.com.londontubeapi.entity.Zones;
import com.google.gson.JsonSyntaxException;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

@Path("/zones")
public class ZoneService {

    @Inject
    private ZoneControler zoneControler;

    @GET
    @Path("/list/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Wrapped(element = "zones")
    public List<Zones> findAllZones() {
        System.out.println("HTTP Method - GET: Find all zones... ");
        List<Zones> listZones = this.zoneControler.findAllZones();
        return listZones;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createZone(Zones zone) {
        try {
            System.out.println("HTTP Method - POST: Creating a new zone... ");
            this.zoneControler.createZone(zone);
            URI uri = URI.create("/list/" + zone.getId());
            return Response.created(uri).build();
        } catch (JsonSyntaxException e) {
            return Response.serverError().build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteZoneById(@PathParam("id") long id) {
        System.out.println("HTTP Method - DELETE: Deleting a zone by id...");
        this.zoneControler.deleteZoneById(id);
        return Response.ok().build();
    }
    
    @PUT
    @Path("/{id}")
    public Response updateZone(@PathParam("id") long id, Zones zone) {
        System.out.println("HTTP Method - PUT: Updating a zone...");
        this.zoneControler.updateZoneById(id, zone);
        return Response.ok().build();
    }

}
