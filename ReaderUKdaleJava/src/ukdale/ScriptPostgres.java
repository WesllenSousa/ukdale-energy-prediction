package ukdale;

import entidades.Building;
import entidades.building1.Building1Bean;
import entidades.building2.Building2Bean;
import entidades.building3.Building3Bean;
import entidades.building4.Building4Bean;
import entidades.building5.Building5Bean;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import ukdale.metadata.building.Appliance;
import util.Database;
import util.DateUtil;
import util.FileUtil;
import view.UkDaleForm;

/**
 *
 * @author Wesllen Sousa
 */
public class ScriptPostgres {

    public static int logInterval = 10000;
    public static Date beginDate;
    public static boolean STOP = false;

    public static void checkBuilding(Appliance appliance, Integer buildingID, Integer meter) {
        log("Building: " + buildingID + ", Meter: " + meter);
        Date lastDate = null;
        Date start = DateUtil.parseDateUTC(appliance.getMeter().getTimeframe().getStart());
        Date endDate = DateUtil.parseDateUTC(appliance.getMeter().getTimeframe().getEnd());
        if (buildingID == 1) {
            Building1Bean m = Database.selectLastMeteringBuilding1(meter);
            if (m != null) {
                lastDate = m.getDateTime();
                log("Last update: " + m.getId() + " - " + DateUtil.formataDataHora(lastDate));
            } else {
                log("No data inserted...");
            }
        } else if (buildingID == 2) {
            Building2Bean m = Database.selectLastMeteringBuilding2(meter);
            if (m != null) {
                lastDate = m.getDateTime();
                log("Last update: " + m.getId() + " - " + DateUtil.formataDataHora(lastDate));
            } else {
                log("No data inserted...");
            }
        } else if (buildingID == 3) {
            Building3Bean m = Database.selectLastMeteringBuilding3(meter);
            if (m != null) {
                lastDate = m.getDateTime();
                log("Last update: " + m.getId() + " - " + DateUtil.formataDataHora(lastDate));
            } else {
                log("No data inserted...");
            }
        } else if (buildingID == 4) {
            Building4Bean m = Database.selectLastMeteringBuilding4(meter);
            if (m != null) {
                lastDate = m.getDateTime();
                log("Last update: " + m.getId() + " - " + DateUtil.formataDataHora(lastDate));
            } else {
                log("No data inserted...");
            }
        } else if (buildingID == 5) {
            Building5Bean m = Database.selectLastMeteringBuilding5(meter);
            if (m != null) {
                lastDate = m.getDateTime();
                log("Last update: " + m.getId() + " - " + DateUtil.formataDataHora(lastDate));
            } else {
                log("No data inserted...");
            }
        }

        if (lastDate != null && DateUtil.formataData(lastDate).equals(DateUtil.formataData(endDate))) {
            log("Last: " + DateUtil.formataDataHora(lastDate) + ", End: " + DateUtil.formataDataHora(endDate));
            log("All data are already inserted in postgres.");
        } else {
            log("Init: " + DateUtil.formataDataHora(start) + ", End: " + DateUtil.formataDataHora(endDate));
            log("Reading file...");
            beginDate = DateUtil.parseDateUTC(appliance.getMeter().getTimeframe().getStart());
            ScriptPostgres.mountListFile(appliance.getMeter().getDataLocation(), appliance, buildingID, start, lastDate);
        }
    }

    public static void mountListFile(String dataLocation, Appliance appliance, Integer buildingID, Date initDate, Date lastDate) {

        int contSec = 1;
        int cont = 1;
        ArrayList<Building> lista = new ArrayList<>();

        try (BufferedReader buffer = FileUtil.readFile(UKDale.DIR_DATASET + dataLocation)) {

            String linha = buffer.readLine();
            String[] columns = linha.split(" ");
            int timestamp = Integer.parseInt(columns[0]);
            int secondInit = timestamp;

            while ((linha = buffer.readLine()) != null) {
                //columns[0]: timestamp columns[1]: watts
                columns = linha.split(" ");
                timestamp = Integer.parseInt(columns[0]);
                int power = Integer.parseInt(columns[1]);
                int second = timestamp - secondInit;
                initDate = (Date) beginDate.clone();
                cont++;

                Date currentDate = DateUtil.adicionaSegundos(initDate, second);
                if (lastDate != null) {
                    if (currentDate.getTime() > lastDate.getTime()) {
                        Building building = new Building();
                        building.setBuilding(buildingID);
                        building.setMeter(appliance.getMeters().get(0));
                        building.setPower(power);
                        building.setDateTime(currentDate);
                        lista.add(building);
                        if (cont % logInterval == 0) {
                            log("  " + cont + ") " + second + " - " + DateUtil.formataDataHora(currentDate) + " buffered " + DateUtil.formataHoraMinuto(new Date()));
                        }
                    } else {
                        if (cont % logInterval == 0) {
                            log("  " + cont + ") " + second + " - " + DateUtil.formataDataHora(currentDate) + " skipping " + DateUtil.formataHoraMinuto(new Date()));
                        }
                        contSec++;
                    }
                } else {
                    Building building = new Building();
                    building.setBuilding(buildingID);
                    building.setMeter(appliance.getMeters().get(0));
                    building.setPower(power);
                    building.setDateTime(currentDate);
                    lista.add(building);
                    if (cont % logInterval == 0) {
                        log("  " + cont + ") " + second + " - " + DateUtil.formataDataHora(currentDate) + " buffered " + DateUtil.formataHoraMinuto(new Date()));
                    }
                }
                if (STOP) {
                    break;
                }
            }

            buffer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        insertPostgres(contSec, lista);

        log("It have finished Inserting data.");
    }

    public static void insertPostgres(int cont, ArrayList<Building> lista) {
        log("Inserting buffered data...");
        boolean first = true;
        for (Building building : lista) {
            if (building.getBuilding() == 1) {
                Building1Bean b = new Building1Bean();
                b.setBuilding(building.getBuilding());
                b.setDateTime(building.getDateTime());
                b.setMeter(building.getMeter());
                b.setPower(building.getPower());
                Database.insertOrUpdateMeteringBuilding1(b);
            } else if (building.getBuilding() == 2) {
                Building2Bean b = new Building2Bean();
                b.setBuilding(building.getBuilding());
                b.setDateTime(building.getDateTime());
                b.setMeter(building.getMeter());
                b.setPower(building.getPower());
                Database.insertOrUpdateMeteringBuilding2(b);
            } else if (building.getBuilding() == 3) {
                Building3Bean b = new Building3Bean();
                b.setBuilding(building.getBuilding());
                b.setDateTime(building.getDateTime());
                b.setMeter(building.getMeter());
                b.setPower(building.getPower());
                Database.insertOrUpdateMeteringBuilding3(b);
            } else if (building.getBuilding() == 4) {
                Building4Bean b = new Building4Bean();
                b.setBuilding(building.getBuilding());
                b.setDateTime(building.getDateTime());
                b.setMeter(building.getMeter());
                b.setPower(building.getPower());
                Database.insertOrUpdateMeteringBuilding4(b);
            } else if (building.getBuilding() == 5) {
                Building5Bean b = new Building5Bean();
                b.setBuilding(building.getBuilding());
                b.setDateTime(building.getDateTime());
                b.setMeter(building.getMeter());
                b.setPower(building.getPower());
                Database.insertOrUpdateMeteringBuilding5(b);
            }
            if (first) {
                log("  " + cont + ") " + DateUtil.formataDataHora(building.getDateTime())
                        + " inserted (" + building.getBuilding() + " - " + building.getMeter() + ") " + DateUtil.formataHoraMinuto(new Date()));
                first = false;
            } else if (cont % logInterval == 0) {
                log("  " + cont + ") " + DateUtil.formataDataHora(building.getDateTime())
                        + " inserted (" + building.getBuilding() + " - " + building.getMeter() + ") " + DateUtil.formataHoraMinuto(new Date()));
            }
            cont++;
            if (STOP) {
                break;
            }
        }
    }

    private static void log(String msg) {
        //System.out.println(msg);
        UkDaleForm.ta_log.setText(UkDaleForm.ta_log.getText() + "\n" + msg);
    }

}
