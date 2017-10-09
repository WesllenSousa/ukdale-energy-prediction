/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.appliance;

import entidades.activities.ActivityBean;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Wesllen Sousa
 */
@Entity
@Table(name = "appliances")
public class ApplianceBean implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id", sequenceName = "appliances_id_seq")
    @GeneratedValue(generator = "seq_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "meter")
    private Integer meter;

    @Column(name = "building")
    private Integer building;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "activity_appliance",
            joinColumns = {
                @JoinColumn(name = "appliance")},
            inverseJoinColumns = {
                @JoinColumn(name = "activity")})
    private Collection<ActivityBean> appliances;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMeter() {
        return meter;
    }

    public void setMeter(Integer meter) {
        this.meter = meter;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Collection<ActivityBean> getAppliances() {
        return appliances;
    }

    public void setAppliances(Collection<ActivityBean> appliances) {
        this.appliances = appliances;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ApplianceBean other = (ApplianceBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
