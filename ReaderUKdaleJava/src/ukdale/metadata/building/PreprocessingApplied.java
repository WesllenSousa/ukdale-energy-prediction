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
public class PreprocessingApplied {

    @Expose
    private Clip clip;

    /**
     *
     * @return The clip
     */
    public Clip getClip() {
        return clip;
    }

    /**
     *
     * @param clip The clip
     */
    public void setClip(Clip clip) {
        this.clip = clip;
    }

}
