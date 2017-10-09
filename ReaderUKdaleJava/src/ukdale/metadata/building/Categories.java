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

@Generated("org.jsonschema2pojo")
public class Categories {

    @Expose
    private List<String> electrical = new ArrayList<>();

    /**
     *
     * @return The electrical
     */
    public List<String> getElectrical() {
        return electrical;
    }

    /**
     *
     * @param electrical The electrical
     */
    public void setElectrical(List<String> electrical) {
        this.electrical = electrical;
    }

}
