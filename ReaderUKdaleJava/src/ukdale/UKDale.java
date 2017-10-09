package ukdale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ukdale.metadata.building.Appliance;
import ukdale.metadata.building.Building;
import ukdale.metadata.building.Room;
import ukdale.metadata.dataset.Dataset;
import ukdale.metadata.meterdevices.MeterDevices;
import util.DateUtil;
import util.FileUtil;

/**
 *
 * @author Wesllen Sousa
 */
public class UKDale {

    //public static String DIR_DATASET = "E:\\ukdale\\uk-power-data-zip-download\\";
    public static String DIR_DATASET = "E:\\Documentos\\Cursos Superiores\\Doctor2\\uk-dale dataset\\uk-dale-dataset\\";
    public static String DIR_METADATA = "metadata json\\";

    /*
     *   Queries
     */
    public Appliance selectAppliance(Integer building, String originalName) {
        Building b = getBuilding(building);
        for (Appliance appliance : b.getAppliances()) {
            if (appliance.getMeters() != null) {
                for (Integer meter : appliance.getMeters()) {
                    appliance.setMeter(b.getElecMeters().getMeter(meter));
                }
            }
            if (appliance.getOriginalName() != null) {
                if (appliance.getOriginalName().equals(originalName)) {
                    return appliance;
                }
            }
        }
        return null;
    }

    public List<Appliance> listAppliances(Integer building) {
        ArrayList<Appliance> appliances = new ArrayList();
        Building b = getBuilding(building);
        for (Appliance appliance : b.getAppliances()) {
            if (appliance.getMeters() != null) {
                for (Integer meter : appliance.getMeters()) {
                    appliance.setMeter(b.getElecMeters().getMeter(meter));
                }
            }
            appliances.add(appliance);
        }
        return appliances;
    }

    public List<Appliance> listAppliancesByRoom(Integer building, String room) {
        ArrayList<Appliance> appliances = new ArrayList<>();
        Building b = getBuilding(building);
        for (Appliance appliance : b.getAppliances()) {
            if (appliance.getMeters() != null) {
                for (Integer meter : appliance.getMeters()) {
                    appliance.setMeter(b.getElecMeters().getMeter(meter));
                }
            }
            if (appliance.getRoom() != null) {
                if (appliance.getRoom().equals(room) && appliance.getMeter() != null) {
                    appliances.add(appliance);
                }
            }
        }
        return appliances;
    }

    public List<Room> listRooms(Integer building) {
        ArrayList<Room> rooms = new ArrayList<>();
        Building b = getBuilding(building);
        for (Room room : b.getRooms()) {
            room.setAppliances(listAppliancesByRoom(building, room.getName()));
            rooms.add(room);
        }
        return rooms;
    }

    /*
     *   Connection
     */
    public Dataset getDataSet() {
        BufferedReader jsonBuilding = null;
        try {
            String file = "dataset.json";
            jsonBuilding = new BufferedReader(new FileReader(UKDale.DIR_DATASET + UKDale.DIR_METADATA + file));
            Gson gson = new Gson();
            return gson.fromJson(jsonBuilding, Dataset.class);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (jsonBuilding != null) {
                    jsonBuilding.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public Building getBuilding(Integer building) {
        BufferedReader jsonBuilding = null;
        try {
            String file = "building" + building + ".json";
            jsonBuilding = new BufferedReader(new FileReader(UKDale.DIR_DATASET + UKDale.DIR_METADATA + file));
            Gson gson = new Gson();
            return gson.fromJson(jsonBuilding, Building.class);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (jsonBuilding != null) {
                    jsonBuilding.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public MeterDevices getMeterDevices() {
        BufferedReader jsonBuilding = null;
        try {
            String file = "meter_devices.json";
            jsonBuilding = new BufferedReader(new FileReader(UKDale.DIR_DATASET + UKDale.DIR_METADATA + file));
            Gson gson = new Gson();
            return gson.fromJson(jsonBuilding, MeterDevices.class);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (jsonBuilding != null) {
                    jsonBuilding.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    /*
     *   Read Data
     */
    public void readAllDataset(String dataLocation, String init) {
        try (BufferedReader buffer = FileUtil.readFile(UKDale.DIR_DATASET + dataLocation)) {
            String linha;
            Boolean first = true;
            Integer secondInit = 0;
            while ((linha = buffer.readLine()) != null) {
                //columns[0]: timestamp columns[1]: watts
                String[] columns = linha.split(" ");
                Integer timestamp = Integer.parseInt(columns[0]);
                Integer power = Integer.parseInt(columns[1]);
                if (first) {
                    secondInit = timestamp;
                    first = false;
                }
                Integer second = timestamp - secondInit;
                Date currentDate = DateUtil.adicionaSegundos(DateUtil.parseDateUTC(init), second);

                printData(second + ")\t" + currentDate.toGMTString() + "\t" + power + " watts");

                break;
            }
            buffer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void printData(String msg) {
        System.out.println(msg);
//        UkDaleForm.ta_data.append(msg);
    }

}
