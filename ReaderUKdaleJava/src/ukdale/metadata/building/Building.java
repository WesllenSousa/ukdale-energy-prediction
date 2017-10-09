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
public class Building {

    @Expose
    private List<Appliance> appliances = new ArrayList<Appliance>();
    @SerializedName("building_type")
    @Expose
    private String buildingType;
    @SerializedName("construction_year")
    @Expose
    private Integer constructionYear;
    @Expose
    private String description;
    @SerializedName("description_of_occupants")
    @Expose
    private String descriptionOfOccupants;
    @SerializedName("elec_meters")
    @Expose
    private ElecMeters elecMeters;
    @SerializedName("energy_improvements")
    @Expose
    private List<String> energyImprovements = new ArrayList<String>();
    @Expose
    private List<String> heating = new ArrayList<String>();
    @Expose
    private Integer instance;
    @SerializedName("n_occupants")
    @Expose
    private Integer nOccupants;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @Expose
    private String ownership;
    @Expose
    private List<Room> rooms = new ArrayList<Room>();
    @Expose
    private Timeframe timeframe;

    /**
     *
     * @return The appliances
     */
    public List<Appliance> getAppliances() {
        return appliances;
    }

    /**
     *
     * @param appliances The appliances
     */
    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    /**
     *
     * @return The buildingType
     */
    public String getBuildingType() {
        return buildingType;
    }

    /**
     *
     * @param buildingType The building_type
     */
    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    /**
     *
     * @return The constructionYear
     */
    public Integer getConstructionYear() {
        return constructionYear;
    }

    /**
     *
     * @param constructionYear The construction_year
     */
    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
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
     * @return The descriptionOfOccupants
     */
    public String getDescriptionOfOccupants() {
        return descriptionOfOccupants;
    }

    /**
     *
     * @param descriptionOfOccupants The description_of_occupants
     */
    public void setDescriptionOfOccupants(String descriptionOfOccupants) {
        this.descriptionOfOccupants = descriptionOfOccupants;
    }

    /**
     *
     * @return The elecMeters
     */
    public ElecMeters getElecMeters() {
        return elecMeters;
    }

    /**
     *
     * @param elecMeters The elec_meters
     */
    public void setElecMeters(ElecMeters elecMeters) {
        this.elecMeters = elecMeters;
    }

    /**
     *
     * @return The energyImprovements
     */
    public List<String> getEnergyImprovements() {
        return energyImprovements;
    }

    /**
     *
     * @param energyImprovements The energy_improvements
     */
    public void setEnergyImprovements(List<String> energyImprovements) {
        this.energyImprovements = energyImprovements;
    }

    /**
     *
     * @return The heating
     */
    public List<String> getHeating() {
        return heating;
    }

    /**
     *
     * @param heating The heating
     */
    public void setHeating(List<String> heating) {
        this.heating = heating;
    }

    /**
     *
     * @return The instance
     */
    public Integer getInstance() {
        return instance;
    }

    /**
     *
     * @param instance The instance
     */
    public void setInstance(Integer instance) {
        this.instance = instance;
    }

    /**
     *
     * @return The nOccupants
     */
    public Integer getNOccupants() {
        return nOccupants;
    }

    /**
     *
     * @param nOccupants The n_occupants
     */
    public void setNOccupants(Integer nOccupants) {
        this.nOccupants = nOccupants;
    }

    /**
     *
     * @return The originalName
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     *
     * @param originalName The original_name
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     *
     * @return The ownership
     */
    public String getOwnership() {
        return ownership;
    }

    /**
     *
     * @param ownership The ownership
     */
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    /**
     *
     * @return The rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     *
     * @param rooms The rooms
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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

}
