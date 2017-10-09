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

@Generated("org.jsonschema2pojo")
public class OnPower {

    @Expose
    private Model model;

    /**
     *
     * @return The model
     */
    public Model getModel() {
        return model;
    }

    /**
     *
     * @param model The model
     */
    public void setModel(Model model) {
        this.model = model;
    }

}
