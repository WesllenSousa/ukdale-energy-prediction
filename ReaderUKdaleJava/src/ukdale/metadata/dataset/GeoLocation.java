/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukdale.metadata.dataset;

/**
 *
 * @author Wesllen Sousa
 */

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class GeoLocation {

    @Expose
    private String country;
    @Expose
    private Float latitude;
    @Expose
    private String locality;
    @Expose
    private Float longitude;

    /**
     *
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return The latitude
     */
    public Float getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude The latitude
     */
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return The locality
     */
    public String getLocality() {
        return locality;
    }

    /**
     *
     * @param locality The locality
     */
    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     *
     * @return The longitude
     */
    public Float getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude The longitude
     */
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

}
