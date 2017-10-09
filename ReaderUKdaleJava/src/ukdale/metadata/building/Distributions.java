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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Distributions {

    @SerializedName("on_power")
    @Expose
    private List<OnPower> onPower = new ArrayList<OnPower>();

    /**
     *
     * @return The onPower
     */
    public List<OnPower> getOnPower() {
        return onPower;
    }

    /**
     *
     * @param onPower The on_power
     */
    public void setOnPower(List<OnPower> onPower) {
        this.onPower = onPower;
    }

}
