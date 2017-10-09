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
public class EfficiencyRating {

    @SerializedName("certification_name")
    @Expose
    private String certificationName;
    @Expose
    private String rating;

    /**
     *
     * @return The certificationName
     */
    public String getCertificationName() {
        return certificationName;
    }

    /**
     *
     * @param certificationName The certification_name
     */
    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }

    /**
     *
     * @return The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     *
     * @param rating The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

}
