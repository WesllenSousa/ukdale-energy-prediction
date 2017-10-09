/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.activities;

import entidades.appliance.ApplianceBean;
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
@Table(name = "activities")
public class ActivityBean implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id", sequenceName = "activities_id_seq")
    @GeneratedValue(generator = "seq_id")
    private Integer codigo;

    @Column(name = "category")
    private String category;

    @Column(name = "activity")
    private String activity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "activity_appliance",
            joinColumns = {
                @JoinColumn(name = "appliance")},
            inverseJoinColumns = {
                @JoinColumn(name = "activity")})
    private Collection<ApplianceBean> appliances;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Collection<ApplianceBean> getAppliances() {
        return appliances;
    }

    public void setAppliances(Collection<ApplianceBean> appliances) {
        this.appliances = appliances;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigo);
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
        final ActivityBean other = (ActivityBean) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return activity;
    }

}
