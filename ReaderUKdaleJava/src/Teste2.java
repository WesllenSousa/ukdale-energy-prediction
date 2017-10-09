
import entidades.appliance.ApplianceBean;
import ukdale.UKDale;
import ukdale.metadata.building.Appliance;
import ukdale.metadata.building.Building;
import util.Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wesllen Sousa
 */
public class Teste2 {

    public static void main(String[] args) {

        UKDale uKDale = new UKDale();

        Integer b = 5;

        Building building = uKDale.getBuilding(b);

        for (Appliance appliance : building.getAppliances()) {
            if (appliance.getOriginalName() != null && appliance.getMeters() != null) {
                System.out.println(appliance.getOriginalName());
                System.out.println(appliance.getMeters());

                ApplianceBean a = new ApplianceBean();
                a.setName(appliance.getOriginalName());
                a.setMeter(appliance.getMeters().get(0));
                a.setBuilding(b);
                
                Database.insertOrUpdateAppliance(a); 
            }
        }
    }

}
