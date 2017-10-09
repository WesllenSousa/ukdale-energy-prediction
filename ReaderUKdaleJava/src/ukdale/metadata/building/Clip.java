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
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Clip {

    @SerializedName("upper_limit")
    @Expose
    private Integer upperLimit;

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

}
