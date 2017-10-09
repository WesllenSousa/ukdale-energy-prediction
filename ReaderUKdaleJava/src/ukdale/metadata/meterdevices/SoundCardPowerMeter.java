/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukdale.metadata.meterdevices;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Wesllen Sousa
 */

@Generated("org.jsonschema2pojo")
public class SoundCardPowerMeter {

    @Expose
    private String manufacturer;
    @SerializedName("max_sample_period")
    @Expose
    private Integer maxSamplePeriod;
    @Expose
    private List<Measurement> measurements = new ArrayList<Measurement>();
    @Expose
    private String model;
    @SerializedName("model_url")
    @Expose
    private String modelUrl;
    @SerializedName("sample_period")
    @Expose
    private Integer samplePeriod;
    @Expose
    private Boolean wireless;

    /**
     *
     * @return The manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     *
     * @param manufacturer The manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     *
     * @return The maxSamplePeriod
     */
    public Integer getMaxSamplePeriod() {
        return maxSamplePeriod;
    }

    /**
     *
     * @param maxSamplePeriod The max_sample_period
     */
    public void setMaxSamplePeriod(Integer maxSamplePeriod) {
        this.maxSamplePeriod = maxSamplePeriod;
    }

    /**
     *
     * @return The measurements
     */
    public List<Measurement> getMeasurements() {
        return measurements;
    }

    /**
     *
     * @param measurements The measurements
     */
    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    /**
     *
     * @return The model
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @param model The model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return The modelUrl
     */
    public String getModelUrl() {
        return modelUrl;
    }

    /**
     *
     * @param modelUrl The model_url
     */
    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
    }

    /**
     *
     * @return The samplePeriod
     */
    public Integer getSamplePeriod() {
        return samplePeriod;
    }

    /**
     *
     * @param samplePeriod The sample_period
     */
    public void setSamplePeriod(Integer samplePeriod) {
        this.samplePeriod = samplePeriod;
    }

    /**
     *
     * @return The wireless
     */
    public Boolean getWireless() {
        return wireless;
    }

    /**
     *
     * @param wireless The wireless
     */
    public void setWireless(Boolean wireless) {
        this.wireless = wireless;
    }

}
