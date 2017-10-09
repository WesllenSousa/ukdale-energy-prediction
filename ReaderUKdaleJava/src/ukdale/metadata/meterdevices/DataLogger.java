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
public class DataLogger {

    @Expose
    private List<String> creators = new ArrayList<String>();
    @Expose
    private String model;
    @SerializedName("model_url")
    @Expose
    private String modelUrl;

    /**
     *
     * @return The creators
     */
    public List<String> getCreators() {
        return creators;
    }

    /**
     *
     * @param creators The creators
     */
    public void setCreators(List<String> creators) {
        this.creators = creators;
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

}
