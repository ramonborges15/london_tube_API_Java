package br.com.londontubeapi.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Estation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstation;
    private String nameEstation;
    @OneToMany
    private List<Zones> zones;
    @ManyToMany(mappedBy = "estations")
    private List<Lines> lines;
    @ManyToMany
    private List<Estation> estations;

    public Integer getIdEstation() {
        return idEstation;
    }

    public void setIdEstation(Integer idEstation) {
        this.idEstation = idEstation;
    }

    public String getNameEstation() {
        return nameEstation;
    }

    public void setNameEstation(String nameEstation) {
        this.nameEstation = nameEstation;
    }

    public List<Zones> getZones() {
        return zones;
    }

    public void setZones(List<Zones> zones) {
        this.zones = zones;
    }

    public List<Lines> getLines() {
        return lines;
    }

    public void setLines(List<Lines> lines) {
        this.lines = lines;
    }

    public List<Estation> getEstations() {
        return estations;
    }

    public void setEstations(List<Estation> estations) {
        this.estations = estations;
    }
    
}
