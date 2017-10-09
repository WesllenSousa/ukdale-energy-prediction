
import entidades.building3.Building3Bean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import ukdale.metadata.building.Appliance;
import ukdale.metadata.building.Room;
import ukdale.UKDale;
import util.Database;
import util.DateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wesllen Sousa
 */
public class Teste3 {

    public static void main(String[] args) {
        Building3Bean m = Database.selectLastMeteringBuilding3(3);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+m);
        
        Date dataInit = DateUtil.parseDateUTC("Feb 27 16:05:20 VET 2013");
        Date dataEnd = DateUtil.parseDateUTC("Mon Apr 08 01:45:05 VET 2013");

        System.out.println(dataInit);

        System.out.println(Database.listMeteringByIntervalBuilding3("day", dataInit, dataEnd, 3, 2));

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date date = isoFormat.parse("2012-11-09T22:28:23+00:00");
            System.out.println(date.toGMTString());
            System.out.println(DateUtil.adicionaSegundos(date, 0).toGMTString());
        } catch (ParseException ex) {
            Logger.getLogger(Teste3.class.getName()).log(Level.SEVERE, null, ex);
        }

        UKDale uKDale = new UKDale();

        for (Appliance a : uKDale.listAppliances(1)) {
            System.out.println(a.getOriginalName());
            System.out.println(a.getRoom());
            System.out.println(a.getMeters());
            uKDale.readAllDataset(a.getMeter().getDataLocation(), a.getMeter().getTimeframe().getStart());
        }

        Integer build = 1;
        String room = "utility";

        for (Room r : uKDale.listRooms(build)) {
            System.out.println(r.getName());
            System.out.println(r.getAppliances());
        }

        System.out.println("=================================================");

        for (Appliance appliance : uKDale.listAppliancesByRoom(build, room)) {

            if (appliance.getMeters() != null) {
                System.out.println("Meter: " + appliance.getMeters().get(0));
            }

            if (appliance.getOriginalName() != null) {
                System.out.println("Name: " + appliance.getOriginalName());
            }

            if (appliance.getNominalConsumption() != null) {
                System.out.println("Consumption: " + appliance.getNominalConsumption().getOnPower());
            }

            if (appliance.getRoom() != null) {
                System.out.println("Room: " + appliance.getRoom());
            }

            if (appliance.getMeter() != null) {
                System.out.println("Data location: " + appliance.getMeter().getDataLocation());
                System.out.println("Submeter Of: " + appliance.getMeter().getSubmeterOf());
                System.out.println("Start: " + appliance.getMeter().getTimeframe().getStart());
                System.out.println("End: " + appliance.getMeter().getTimeframe().getEnd());

                uKDale.readAllDataset(
                        appliance.getMeter().getDataLocation(),
                        appliance.getMeter().getTimeframe().getStart());

//                for (Measurement m : measurements) {
//                    System.out.println("Date: " + m.getDateTime().toGMTString() + ",  power: " + m.getPower());
//                }
            }

            System.out.println("----------------------------------");
            //break;//------------------------------------------------------------
        }
    }

}
