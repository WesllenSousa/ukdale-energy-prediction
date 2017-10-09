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

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Dataset {

    @Expose
    private String contact;
    @Expose
    private List<String> creators = new ArrayList<String>();
    @Expose
    private String date;
    @Expose
    private String description;
    @SerializedName("description_of_subjects")
    @Expose
    private String descriptionOfSubjects;
    @Expose
    private List<String> funding = new ArrayList<String>();
    @SerializedName("geo_location")
    @Expose
    private GeoLocation geoLocation;
    @SerializedName("geospatial_coverage")
    @Expose
    private String geospatialCoverage;
    @Expose
    private String institution;
    @SerializedName("long_name")
    @Expose
    private String longName;
    @Expose
    private String name;
    @SerializedName("number_of_buildings")
    @Expose
    private Integer numberOfBuildings;
    @Expose
    private String publisher;
    @SerializedName("related_documents")
    @Expose
    private List<String> relatedDocuments = new ArrayList<String>();
    @SerializedName("rights_list")
    @Expose
    private List<RightsList> rightsList = new ArrayList<RightsList>();
    @Expose
    private String schema;
    @Expose
    private String subject;
    @Expose
    private Timeframe timeframe;
    @Expose
    private String timezone;

    /**
     *
     * @return The contact
     */
    public String getContact() {
        return contact;
    }

    /**
     *
     * @param contact The contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

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
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return The descriptionOfSubjects
     */
    public String getDescriptionOfSubjects() {
        return descriptionOfSubjects;
    }

    /**
     *
     * @param descriptionOfSubjects The description_of_subjects
     */
    public void setDescriptionOfSubjects(String descriptionOfSubjects) {
        this.descriptionOfSubjects = descriptionOfSubjects;
    }

    /**
     *
     * @return The funding
     */
    public List<String> getFunding() {
        return funding;
    }

    /**
     *
     * @param funding The funding
     */
    public void setFunding(List<String> funding) {
        this.funding = funding;
    }

    /**
     *
     * @return The geoLocation
     */
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    /**
     *
     * @param geoLocation The geo_location
     */
    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    /**
     *
     * @return The geospatialCoverage
     */
    public String getGeospatialCoverage() {
        return geospatialCoverage;
    }

    /**
     *
     * @param geospatialCoverage The geospatial_coverage
     */
    public void setGeospatialCoverage(String geospatialCoverage) {
        this.geospatialCoverage = geospatialCoverage;
    }

    /**
     *
     * @return The institution
     */
    public String getInstitution() {
        return institution;
    }

    /**
     *
     * @param institution The institution
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     *
     * @return The longName
     */
    public String getLongName() {
        return longName;
    }

    /**
     *
     * @param longName The long_name
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The numberOfBuildings
     */
    public Integer getNumberOfBuildings() {
        return numberOfBuildings;
    }

    /**
     *
     * @param numberOfBuildings The number_of_buildings
     */
    public void setNumberOfBuildings(Integer numberOfBuildings) {
        this.numberOfBuildings = numberOfBuildings;
    }

    /**
     *
     * @return The publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher The publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return The relatedDocuments
     */
    public List<String> getRelatedDocuments() {
        return relatedDocuments;
    }

    /**
     *
     * @param relatedDocuments The related_documents
     */
    public void setRelatedDocuments(List<String> relatedDocuments) {
        this.relatedDocuments = relatedDocuments;
    }

    /**
     *
     * @return The rightsList
     */
    public List<RightsList> getRightsList() {
        return rightsList;
    }

    /**
     *
     * @param rightsList The rights_list
     */
    public void setRightsList(List<RightsList> rightsList) {
        this.rightsList = rightsList;
    }

    /**
     *
     * @return The schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     *
     * @param schema The schema
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     *
     * @return The subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject The subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
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

    /**
     *
     * @return The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     *
     * @param timezone The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
