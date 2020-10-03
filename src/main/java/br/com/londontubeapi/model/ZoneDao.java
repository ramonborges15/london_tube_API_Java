package br.com.londontubeapi.model;

import br.com.londontubeapi.entity.Zones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ZoneDao {
    
    @PersistenceContext(unitName = "LondonTubePU")
    private EntityManager em;
    
    public List<Zones> findAllZones() {
        String hql = "SELECT z FROM Zones z";
        return this.em.createQuery(hql).getResultList();
    }

    public Zones saveZone(Zones zone) {
        return this.em.merge(zone);
    }

    public void deleteZoneById(long id) {
        this.em.remove(this.em.find(Zones.class, Integer.valueOf(String.valueOf(id))));
    }

    public void updateZone(Zones zone) {
        this.em.merge(zone);
    }
    
}
