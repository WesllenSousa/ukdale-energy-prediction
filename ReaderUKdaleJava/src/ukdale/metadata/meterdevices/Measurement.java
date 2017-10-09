/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukdale.metadata.meterdevices;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Wesllen Sousa
 */

@Generated("org.jsonschema2pojo")
public class Measurement {

    @SerializedName("lower_limit")
    @Expose
    private Integer lowerLimit;
    @SerializedName("physical_quantity")
    @Expose
    private String physicalQuantity;
    @Expose
    private String type;
    @SerializedName("upper_limit")
    @Expose
    private Integer upperLimit;
    @Expose
    private String description;

    /**
     *
     * @return The lowerLimit
     */
    public Integer getLowerLimit() {
        return lowerLimit;
    }

    /**
     *
     * @param lowerLimit The lower_limit
     */
    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    /**
     *
     * @return The physicalQuantity
     */
    public String getPhysicalQuantity() {
        return physicalQuantity;
    }

    /**
     *
     * @param physicalQuantity The physical_quantity
     */
    public void setPhysicalQuantity(String physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    /**
     *
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return The upperLimit
     */
    public Integer getUpperLimit() {
        return upperLimit;
    }

    /**
     *
     * @param upperLimit The upper_limit
     */
    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
