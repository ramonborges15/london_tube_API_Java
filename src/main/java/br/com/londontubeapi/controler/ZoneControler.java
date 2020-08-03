package br.com.londontubeapi.controler;

import br.com.londontubeapi.entity.Zones;
import br.com.londontubeapi.model.ZoneDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.transaction.Transactional;

@Stateless
public class ZoneControler {
    
    @Inject
    private ZoneDao zoneDAO;
    
    public List<Zones> findAllZones() {
        return this.zoneDAO.findAllZones();
    }
    
    public String toJson(List<Zones> zones) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        
        for (Zones zone : zones) {
            builder.add(Json.createObjectBuilder()
                    .add("zone", zone.getNumber()));
        }
        
        return builder.build().toString();
        
    }
    
    @Transactional
    public Zones createZone(Zones zone) {
        return this.zoneDAO.saveZone(zone);
    }
}
