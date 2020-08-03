package br.com.londontubeapi.rest;

import br.com.londontubeapi.controler.ZoneControler;
import br.com.londontubeapi.entity.Zones;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
    public String findAllZones() {
        List<Zones> listZones = this.zoneControler.findAllZones();
        return this.zoneControler.toJson(listZones);
    }
    
    
    
}
