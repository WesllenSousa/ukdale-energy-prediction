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
public class Appliance {

    @Expose
    private String description;
    @Expose
    private Distributions distributions;
    @SerializedName("efficiency_rating")
    @Expose
    private EfficiencyRating efficiencyRating;
    @Expose
    private String fuel;
    @Expose
    private Integer instance;
    @Expose
    private String manufacturer;
    @Expose
    private String model;
    @SerializedName("nominal_consumption")
    @Expose
    private NominalConsumption nominalConsumption;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("part_number")
    @Expose
    private String partNumber;
    @Expose
    private String room;
    @Expose
    private String subtype;
    @Expose
    private String type;
    @SerializedName("year_of_purchase")
    @Expose
    private Integer yearOfPurchase;
    @Expose
    private List<Component> components = new ArrayList<>();
    @Expose
    private String cpu;
    @SerializedName("dates_active")
    @Expose
    private List<DatesActive> datesActive = new ArrayList<>();
    @Expose
    private String brand;
    @SerializedName("integrated_av_sources")
    @Expose
    private List<String> integratedAvSources = new ArrayList<>();
    @SerializedName("on_power_threshold")
    @Expose
    private Integer onPowerThreshold;
    @SerializedName("year_of_manufacture")
    @Expose
    private Integer yearOfManufacture;
    @SerializedName("main_room_light")
    @Expose
    private Boolean mainRoomLight;
    @SerializedName("dominant_appliance")
    @Expose
    private Boolean dominantAppliance;
    @Expose
    private List<String> control = new ArrayList<>();
    @SerializedName("do_not_inherit")
    @Expose
    private List<String> doNotInherit = new ArrayList<>();
    @Expose
    private Categories categories;
    @Expose
    private Integer count;

    @Expose
    private List<Integer> meters = new ArrayList<>();
    private Meter meter;

    /**
     *
     * @return The description
     */
    public String getDescription() {
        if (description != null) {
            return description;
        } else {
            return "";
        }
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
     * @return The distributions
     */
    public Distributions getDistributions() {
        return distributions;
    }

    /**
     *
     * @param distributions The distributions
     */
    public void setDistributions(Distributions distributions) {
        this.distributions = distributions;
    }

    /**
     *
     * @return The efficiencyRating
     */
    public EfficiencyRating getEfficiencyRating() {
        return efficiencyRating;
    }

    /**
     *
     * @param efficiencyRating The efficiency_rating
     */
    public void setEfficiencyRating(EfficiencyRating efficiencyRating) {
        this.efficiencyRating = efficiencyRating;
    }

    /**
     *
     * @return The fuel
     */
    public String getFuel() {
        if (fuel != null) {
            return fuel;
        } else {
            return "";
        }
    }

    /**
     *
     * @param fuel The fuel
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
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
     * @return The manufacturer
     */
    public String getManufacturer() {
        if (manufacturer != null) {
            return manufacturer;
        } else {
            return "";
        }
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
     * @return The meters
     */
    public List<Integer> getMeters() {
        return meters;
    }

    /**
     *
     * @param meters The meters
     */
    public void setMeters(List<Integer> meters) {
        this.meters = meters;
    }

    /**
     *
     * @return The model
     */
    public String getModel() {
        if (model != null) {
            return model;
        } else {
            return "";
        }
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
     * @return The nominalConsumption
     */
    public NominalConsumption getNominalConsumption() {
        return nominalConsumption;
    }

    /**
     *
     * @param nominalConsumption The nominal_consumption
     */
    public void setNominalConsumption(NominalConsumption nominalConsumption) {
        this.nominalConsumption = nominalConsumption;
    }

    /**
     *
     * @return The originalName
     */
    public String getOriginalName() {
        if (originalName != null) {
            return originalName;
        } else {
            return "";
        }
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
     * @return The partNumber
     */
    public String getPartNumber() {
        if (partNumber != null) {
            return partNumber;
        } else {
            return "";
        }
    }

    /**
     *
     * @param partNumber The part_number
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    /**
     *
     * @return The room
     */
    public String getRoom() {
        if (room != null) {
            return room;
        } else {
            return "";
        }
    }

    /**
     *
     * @param room The room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     *
     * @return The subtype
     */
    public String getSubtype() {
        if (subtype != null) {
            return subtype;
        } else {
            return "";
        }
    }

    /**
     *
     * @param subtype The subtype
     */
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    /**
     *
     * @return The type
     */
    public String getType() {
        if (type != null) {
            return type;
        } else {
            return "";
        }
    }

    /**
     *
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return The yearOfPurchase
     */
    public Integer getYearOfPurchase() {
        if (yearOfPurchase != null) {
            return yearOfPurchase;
        } else {
            return 0;
        }
    }

    /**
     *
     * @param yearOfPurchase The year_of_purchase
     */
    public void setYearOfPurchase(Integer yearOfPurchase) {
        this.yearOfPurchase = yearOfPurchase;
    }

    /**
     *
     * @return The components
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     *
     * @param components The components
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }

    /**
     *
     * @return The cpu
     */
    public String getCpu() {
        if (cpu != null) {
            return cpu;
        } else {
            return "";
        }
    }

    /**
     *
     * @param cpu The cpu
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     *
     * @return The datesActive
     */
    public List<DatesActive> getDatesActive() {
        return datesActive;
    }

    /**
     *
     * @param datesActive The dates_active
     */
    public void setDatesActive(List<DatesActive> datesActive) {
        this.datesActive = datesActive;
    }

    /**
     *
     * @return The brand
     */
    public String getBrand() {
        if (brand != null) {
            return brand;
        } else {
            return "";
        }
    }

    /**
     *
     * @param brand The brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return The integratedAvSources
     */
    public List<String> getIntegratedAvSources() {
        return integratedAvSources;
    }

    /**
     *
     * @param integratedAvSources The integrated_av_sources
     */
    public void setIntegratedAvSources(List<String> integratedAvSources) {
        this.integratedAvSources = integratedAvSources;
    }

    /**
     *
     * @return The onPowerThreshold
     */
    public Integer getOnPowerThreshold() {
        if (onPowerThreshold != null) {
            return onPowerThreshold;
        } else {
            return 0;
        }
    }

    /**
     *
     * @param onPowerThreshold The on_power_threshold
     */
    public void setOnPowerThreshold(Integer onPowerThreshold) {
        this.onPowerThreshold = onPowerThreshold;
    }

    /**
     *
     * @return The yearOfManufacture
     */
    public Integer getYearOfManufacture() {
        if (yearOfManufacture != null) {
            return yearOfManufacture;
        } else {
            return 0;
        }
    }

    /**
     *
     * @param yearOfManufacture The year_of_manufacture
     */
    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    /**
     *
     * @return The mainRoomLight
     */
    public Boolean getMainRoomLight() {
        if (mainRoomLight != null) {
            return mainRoomLight;
        } else {
            return false;
        }
    }

    /**
     *
     * @param mainRoomLight The main_room_light
     */
    public void setMainRoomLight(Boolean mainRoomLight) {
        this.mainRoomLight = mainRoomLight;
    }

    /**
     *
     * @return The dominantAppliance
     */
    public Boolean getDominantAppliance() {
        if (dominantAppliance != null) {
            return dominantAppliance;
        } else {
            return false;
        }
    }

    /**
     *
     * @param dominantAppliance The dominant_appliance
     */
    public void setDominantAppliance(Boolean dominantAppliance) {
        this.dominantAppliance = dominantAppliance;
    }

    /**
     *
     * @return The control
     */
    public List<String> getControl() {
        return control;
    }

    /**
     *
     * @param control The control
     */
    public void setControl(List<String> control) {
        this.control = control;
    }

    /**
     *
     * @return The doNotInherit
     */
    public List<String> getDoNotInherit() {
        return doNotInherit;
    }

    /**
     *
     * @param doNotInherit The do_not_inherit
     */
    public void setDoNotInherit(List<String> doNotInherit) {
        this.doNotInherit = doNotInherit;
    }

    /**
     *
     * @return The categories
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     *
     * @param categories The categories
     */
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    /**
     *
     * @return The count
     */
    public Integer getCount() {
        if (count != null) {
            return count;
        } else {
            return 0;
        }
    }

    /**
     *
     * @param count The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    @Override
    public String toString() {
        return originalName;
    }

}
