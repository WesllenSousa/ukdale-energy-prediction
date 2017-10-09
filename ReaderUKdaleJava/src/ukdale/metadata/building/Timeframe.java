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
public class Timeframe {

    @Expose
    private String end;
    @Expose
    private String start;

    /**
     *
     * @return The end
     */
    public String getEnd() {
        return end;
    }

    /**
     *
     * @param end The end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     *
     * @return The start
     */
    public String getStart() {
        return start;
    }

    /**
     *
     * @param start The start
     */
    public void setStart(String start) {
        this.start = start;
    }

}
