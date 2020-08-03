package br.com.londontubeapi.rest;

import br.com.londontubeapi.controler.ZoneControler;
import br.com.londontubeapi.entity.Zones;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
        List<Zones> listZones = this.zoneControler.findAllZones();
        return listZones;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String createZone(Zones zone) {
        
        try {
            this.zoneControler.createZone(zone);
            return "Ok";
        } catch (JsonSyntaxException e) {
            return e.toString();
        }
    }

}
