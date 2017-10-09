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
public class NominalConsumption {

    @SerializedName("on_power")
    @Expose
    private Integer onPower;

    /**
     *
     * @return The onPower
     */
    public Integer getOnPower() {
        return onPower;
    }

    /**
     *
     * @param onPower The on_power
     */
    public void setOnPower(Integer onPower) {
        this.onPower = onPower;
    }

}
