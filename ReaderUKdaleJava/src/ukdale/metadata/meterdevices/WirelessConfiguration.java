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
public class WirelessConfiguration {

    @Expose
    private String base;
    @SerializedName("carrier_frequency")
    @Expose
    private Integer carrierFrequency;
    @Expose
    private String protocol;

    /**
     *
     * @return The base
     */
    public String getBase() {
        return base;
    }

    /**
     *
     * @param base The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     *
     * @return The carrierFrequency
     */
    public Integer getCarrierFrequency() {
        return carrierFrequency;
    }

    /**
     *
     * @param carrierFrequency The carrier_frequency
     */
    public void setCarrierFrequency(Integer carrierFrequency) {
        this.carrierFrequency = carrierFrequency;
    }

    /**
     *
     * @return The protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     *
     * @param protocol The protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

}
