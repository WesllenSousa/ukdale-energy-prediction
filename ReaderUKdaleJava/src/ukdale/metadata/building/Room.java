/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukdale.metadata.building;

/**
 *
 * @author Wesllen Sousa
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Room {

    @Expose
    private Integer floor;
    @Expose
    private String name;
    @Expose
    private Integer instance;
    @Expose
    private String description;
    
    private List<Appliance> appliances = new ArrayList<Appliance>();

    /**
     *
     * @return The floor
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     *
     * @param floor The floor
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The instance
     */
    public Integer getInstance() {
        return instance;
    }

    /**
     *
     * @param instance The instance
     */
    public void setInstance(Integer instance) {
        this.instance = instance;
    }

    /**
     *
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
