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
public class Model {

    @SerializedName("distribution_name")
    @Expose
    private String distributionName;
    @Expose
    private Integer mu;
    @Expose
    private Integer sigma;

    /**
     *
     * @return The distributionName
     */
    public String getDistributionName() {
        return distributionName;
    }

    /**
     *
     * @param distributionName The distribution_name
     */
    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    /**
     *
     * @return The mu
     */
    public Integer getMu() {
        return mu;
    }

    /**
     *
     * @param mu The mu
     */
    public void setMu(Integer mu) {
        this.mu = mu;
    }

    /**
     *
     * @return The sigma
     */
    public Integer getSigma() {
        return sigma;
    }

    /**
     *
     * @param sigma The sigma
     */
    public void setSigma(Integer sigma) {
        this.sigma = sigma;
    }

}
