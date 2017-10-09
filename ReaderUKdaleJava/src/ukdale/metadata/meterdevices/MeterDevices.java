/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukdale.metadata.meterdevices;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

/**
 *
 * @author Wesllen Sousa
 */

@Generated("org.jsonschema2pojo")
public class MeterDevices {

    @Expose
    private CurrentCostTx CurrentCostTx;
    @Expose
    private EcoManagerTxPlug EcoManagerTxPlug;
    @Expose
    private EcoManagerWholeHouseTx EcoManagerWholeHouseTx;
    @Expose
    private SoundCardPowerMeter SoundCardPowerMeter;

    /**
     *
     * @return The CurrentCostTx
     */
    public CurrentCostTx getCurrentCostTx() {
        return CurrentCostTx;
    }

    /**
     *
     * @param CurrentCostTx The CurrentCostTx
     */
    public void setCurrentCostTx(CurrentCostTx CurrentCostTx) {
        this.CurrentCostTx = CurrentCostTx;
    }

    /**
     *
     * @return The EcoManagerTxPlug
     */
    public EcoManagerTxPlug getEcoManagerTxPlug() {
        return EcoManagerTxPlug;
    }

    /**
     *
     * @param EcoManagerTxPlug The EcoManagerTxPlug
     */
    public void setEcoManagerTxPlug(EcoManagerTxPlug EcoManagerTxPlug) {
        this.EcoManagerTxPlug = EcoManagerTxPlug;
    }

    /**
     *
     * @return The EcoManagerWholeHouseTx
     */
    public EcoManagerWholeHouseTx getEcoManagerWholeHouseTx() {
        return EcoManagerWholeHouseTx;
    }

    /**
     *
     * @param EcoManagerWholeHouseTx The EcoManagerWholeHouseTx
     */
    public void setEcoManagerWholeHouseTx(EcoManagerWholeHouseTx EcoManagerWholeHouseTx) {
        this.EcoManagerWholeHouseTx = EcoManagerWholeHouseTx;
    }

    /**
     *
     * @return The SoundCardPowerMeter
     */
    public SoundCardPowerMeter getSoundCardPowerMeter() {
        return SoundCardPowerMeter;
    }

    /**
     *
     * @param SoundCardPowerMeter The SoundCardPowerMeter
     */
    public void setSoundCardPowerMeter(SoundCardPowerMeter SoundCardPowerMeter) {
        this.SoundCardPowerMeter = SoundCardPowerMeter;
    }

}
