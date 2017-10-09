/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.arff;

import entidades.Building;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;

/**
 *
 * @author Wesllen Sousa
 */
public class GroupData {

    final public static String MINUTE = "Minute";
    final public static String HOUR = "Hour";
    final public static String DAY = "Day";
    final public static String MONTH = "Month";

    public ArrayList<Data> tableGenerator(String groupType, Calendar startCalendar,
            Date startDate, Date endDate, ArrayList<Building> buildings) {

        ArrayList<Data> dataLista = new ArrayList<>();
        Data data;

        int difference = 0;

        switch (groupType) {
            case MINUTE:
                difference = Minutes.minutesBetween(new DateTime(startDate), new DateTime(endDate)).getMinutes();

                System.out.println("Minutes Difference: " + difference);

                while (difference > 0) {
                    data = fillTable(groupType, selectMeasurementByGroup(groupType, buildings, startCalendar));
                    if (data != null) {
                        dataLista.add(data);
                    }
                    startCalendar.add(Calendar.MINUTE, 1);
                    difference--;
                }
                break;
            case HOUR:
                difference = Hours.hoursBetween(new DateTime(startDate), new DateTime(endDate)).getHours();

                System.out.println("Hour Difference: " + difference);

                while (difference > 0) {
                    data = fillTable(groupType, selectMeasurementByGroup(groupType, buildings, startCalendar));
                    if (data != null) {
                        dataLista.add(data);
                    }
                    startCalendar.add(Calendar.HOUR_OF_DAY, 1);
                    difference--;
                }
                break;
            case DAY:
                difference = Days.daysBetween(new DateTime(startDate), new DateTime(endDate)).getDays();

                System.out.println("Days Difference: " + difference);

                while (difference > 0) {
                    data = fillTable(groupType, selectMeasurementByGroup(groupType, buildings, startCalendar));
                    if (data != null) {
                        dataLista.add(data);
                    }
                    startCalendar.add(Calendar.DAY_OF_MONTH, 1);
                    difference--;
                }

                break;
            case MONTH:
                difference = Months.monthsBetween(new DateTime(startDate), new DateTime(endDate)).getMonths();

                System.out.println("Months Difference: " + difference);

                while (difference > 0) {
                    data = fillTable(groupType, selectMeasurementByGroup(groupType, buildings, startCalendar));
                    if (data != null) {
                        dataLista.add(data);
                    }
                    startCalendar.add(Calendar.MONTH, 1);
                    difference--;
                }

                break;
            default:
                System.out.println("ERRO: TableGenerator Method");
                break;
        }
        return dataLista;
    }

    private Data fillTable(String groupType, ArrayList<Building> groupBuildings) { 

        if (groupBuildings == null) {
            return null;
        }
        Data data = new Data();
        try {
            Building d = groupBuildings.get(0);
            data.setYear((d.getDateTime().getYear() + 1900));
            switch (groupType) {
                case MINUTE:
                    data.setMonth(d.getDateTime().getMonth() + 1); //The Date Pattern start with 0
                    data.setDay(d.getDateTime().getDate());
                    data.setHour(d.getDateTime().getHours());
                    data.setMinute(d.getDateTime().getMinutes());
                    break;
                case HOUR:
                    data.setMonth(d.getDateTime().getMonth() + 1);//The Date Pattern start with 0
                    data.setDay(d.getDateTime().getDate());
                    data.setHour(d.getDateTime().getHours());
                    data.setMinute(0);
                    break;
                case DAY:
                    data.setMonth(d.getDateTime().getMonth() + 1);//The Date Pattern start with 0
                    data.setDay(d.getDateTime().getDate());
                    data.setHour(0);
                    data.setMinute(0);
                    break;
                case MONTH:
                    data.setMonth(d.getDateTime().getMonth() + 1);//The Date Pattern start with 0
                    data.setDay(1);
                    data.setHour(0);
                    data.setMinute(0);
                    break;
                default:
                    System.out.println("ERRO: FillTable Method");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        data.setPower(sumValue(groupBuildings)); 

        return data;
    }

    private ArrayList<Building> selectMeasurementByGroup(String groupType, ArrayList<Building> buildings, Calendar d) {
        if (buildings == null) {
            return null;
        }
        ArrayList<Building> measurementGroup = new ArrayList<>();
        for (Building elem : buildings) {
            switch (groupType) {
                case MINUTE:
                    if (elem.getDateTime().getMinutes() == d.get(Calendar.MINUTE)
                            && elem.getDateTime().getHours() == d.get(Calendar.HOUR_OF_DAY)
                            && elem.getDateTime().getDate() == d.get(Calendar.DAY_OF_MONTH)
                            && elem.getDateTime().getMonth() == d.get(Calendar.MONTH)
                            && (elem.getDateTime().getYear() + 1900) == d.get(Calendar.YEAR)) {
                        measurementGroup.add(elem);
                    }
                    break;
                case HOUR:
                    if (elem.getDateTime().getHours() == d.get(Calendar.HOUR_OF_DAY)
                            && elem.getDateTime().getDate() == d.get(Calendar.DAY_OF_MONTH)
                            && elem.getDateTime().getMonth() == d.get(Calendar.MONTH)
                            && (elem.getDateTime().getYear() + 1900) == d.get(Calendar.YEAR)) {
                        measurementGroup.add(elem);
                    }
                    break;
                case DAY:
                    if (elem.getDateTime().getDate() == d.get(Calendar.DAY_OF_MONTH)
                            && elem.getDateTime().getMonth() == d.get(Calendar.MONTH)
                            && (elem.getDateTime().getYear() + 1900) == d.get(Calendar.YEAR)) {
                        measurementGroup.add(elem);
                    }
                    break;
                case MONTH:
                    if (elem.getDateTime().getMonth() == d.get(Calendar.MONTH)
                            && (elem.getDateTime().getYear() + 1900) == d.get(Calendar.YEAR)) {
                        measurementGroup.add(elem);
                    }
                    break;
                default:
                    System.out.println("ERRO: selectMeasurementByGroup Method");
                    break;
            }
        }

        if (measurementGroup.isEmpty()) {
            return null;
        } else {
            return measurementGroup;
        }
    }

    private int sumValue(ArrayList<Building> m) {
        if (m.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Building elem : m) {
            sum += elem.getPower(); 
        }
        return sum;
    }

}
