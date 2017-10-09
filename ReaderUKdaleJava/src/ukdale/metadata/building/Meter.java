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
public class Meter {

    @SerializedName("data_location")
    @Expose
    private String dataLocation;
    @SerializedName("device_model")
    @Expose
    private String deviceModel;
    @Expose
    private Boolean disabled;
    @SerializedName("preprocessing_applied")
    @Expose
    private PreprocessingApplied preprocessingApplied;
    @SerializedName("site_meter")
    @Expose
    private Boolean siteMeter;
    @SerializedName("submeter_of")
    @Expose
    private Integer submeterOf;
    @Expose
    private Timeframe timeframe;
    @Expose
    private String warning;

    /**
     *
     * @return The dataLocation
     */
    public String getDataLocation() {
        if (dataLocation != null) {
            return dataLocation;
        } else {
            return "";
        }
    }

    /**
     *
     * @param dataLocation The data_location
     */
    public void setDataLocation(String dataLocation) {
        this.dataLocation = dataLocation;
    }

    /**
     *
     * @return The deviceModel
     */
    public String getDeviceModel() {
        if (deviceModel != null) {
            return deviceModel;
        } else {
            return "";
        }
    }

    /**
     *
     * @param deviceModel The device_model
     */
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    /**
     *
     * @return The disabled
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     *
     * @param disabled The disabled
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     *
     * @return The preprocessingApplied
     */
    public PreprocessingApplied getPreprocessingApplied() {
        return preprocessingApplied;
    }

    /**
     *
     * @param preprocessingApplied The preprocessing_applied
     */
    public void setPreprocessingApplied(PreprocessingApplied preprocessingApplied) {
        this.preprocessingApplied = preprocessingApplied;
    }

    /**
     *
     * @return The siteMeter
     */
    public Boolean getSiteMeter() {
        if (siteMeter != null) {
            return siteMeter;
        } else {
            return false;
        }
    }

    /**
     *
     * @param siteMeter The site_meter
     */
    public void setSiteMeter(Boolean siteMeter) {
        this.siteMeter = siteMeter;
    }

    /**
     *
     * @return The submeterOf
     */
    public Integer getSubmeterOf() {
        if (submeterOf != null) {
            return submeterOf;
        } else {
            return -1;
        }
    }

    /**
     *
     * @param submeterOf The submeter_of
     */
    public void setSubmeterOf(Integer submeterOf) {
        this.submeterOf = submeterOf;
    }

    /**
     *
     * @return The timeframe
     */
    public Timeframe getTimeframe() {
        return timeframe;
    }

    /**
     *
     * @param timeframe The timeframe
     */
    public void setTimeframe(Timeframe timeframe) {
        this.timeframe = timeframe;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

}
