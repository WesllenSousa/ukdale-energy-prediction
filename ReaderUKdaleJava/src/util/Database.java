/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidades.activities.ActivityBean;
import entidades.activities.ActivityDao;
import entidades.activities.ActivityDaoImpl;
import entidades.appliance.ApplianceBean;
import entidades.appliance.ApplianceDao;
import entidades.appliance.ApplianceDaoImpl;
import entidades.building1.Building1Bean;
import entidades.building1.Building1Dao;
import entidades.building1.Building1DaoImpl;
import entidades.building2.Building2Bean;
import entidades.building2.Building2Dao;
import entidades.building2.Building2DaoImpl;
import entidades.building3.Building3Bean;
import entidades.building3.Building3Dao;
import entidades.building3.Building3DaoImpl;
import entidades.building4.Building4Bean;
import entidades.building4.Building4Dao;
import entidades.building4.Building4DaoImpl;
import entidades.building5.Building5Bean;
import entidades.building5.Building5Dao;
import entidades.building5.Building5DaoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Wesllen Sousa
 *
 * SELECT date_trunc('day',b.datetime) as group_date, sum(b.power) as power FROM
 * building3 b WHERE b.datetime BETWEEN '2013-02-27 20:35:20' AND '2013-04-08
 * 06:15:05' GROUP BY group_date ORDER BY group_date *
 *
 * SELECT date_trunc('day',b.datetime) as group_date, sum(b.power) as power,
 * b.meter, b.building FROM building3 b WHERE b.datetime BETWEEN '2013-02-27
 * 20:35:20' AND '2013-03-02 06:15:05' AND b.meter = 2 GROUP BY group_date,
 * b.meter, b.building ORDER BY group_date *
 *
 */
public class Database {

    /*
     * Appliance
     */
    public static ApplianceBean insertOrUpdateAppliance(ApplianceBean activity) {
        ApplianceDao dao = new ApplianceDaoImpl();
        try {
            return dao.insereOuAltera(activity);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static List<ApplianceBean> listAppliances() {
        ApplianceDao dao = new ApplianceDaoImpl();
        try {
            return dao.listar();
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ApplianceBean selectApplianceByName(String name) {
        ApplianceDao dao = new ApplianceDaoImpl();
        try {
            return dao.selectApplianceByName(name); 
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    
    /*
     * Activity
     */
    public static ActivityBean insertOrUpdateActivity(ActivityBean activity) {
        ActivityDao dao = new ActivityDaoImpl();
        try {
            return dao.insereOuAltera(activity);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static List<ActivityBean> listActivities() {
        ActivityDao dao = new ActivityDaoImpl();
        try {
            return dao.listar();
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ActivityBean selectActivityByName(String name) {
        ActivityDao dao = new ActivityDaoImpl();
        try {
            return dao.selectActivityByName(name);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    /*
     * Building1
     */
    public static Building1Bean insertOrUpdateMeteringBuilding1(Building1Bean building) {
        Building1Dao dao = new Building1DaoImpl();
        try {
            return dao.insereOuAltera(building);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static List<Building1Bean> listMeteringBuilding1() {
        Building1Dao dao = new Building1DaoImpl();
        try {
            return dao.listar();
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringAllIntervalBuilding1(String group, Date dataInit, Date dataEnd) {
        Building1Dao dao = new Building1DaoImpl();
        try {
            return dao.listMeteringAllInterval(group, dataInit, dataEnd);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringByIntervalBuilding1(String group, Date dataInit, Date dataEnd, Integer building, Integer meter) {
        Building1Dao dao = new Building1DaoImpl();
        try {
            return dao.listMeteringByInterval(group, dataInit, dataEnd, meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building1Bean selectLastMeteringBuilding1(Integer meter) {
        Building1Dao dao = new Building1DaoImpl();
        try {
            return dao.selectLastMetering(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building1Bean selectBuilding1ByMeter(Integer meter) {
        Building1Dao dao = new Building1DaoImpl();
        try {
            return dao.selectBuildingByMeter(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    /*
     * Building2
     */
    public static Building2Bean insertOrUpdateMeteringBuilding2(Building2Bean building) {
        Building2Dao dao = new Building2DaoImpl();
        try {
            return dao.insereOuAltera(building);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static List<Building2Bean> listMeteringBuilding2() {
        Building2Dao dao = new Building2DaoImpl();
        try {
            return dao.listar();
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringAllIntervalBuilding2(String group, Date dataInit, Date dataEnd) {
        Building2Dao dao = new Building2DaoImpl();
        try {
            return dao.listMeteringAllInterval(group, dataInit, dataEnd);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringByIntervalBuilding2(String group, Date dataInit, Date dataEnd, Integer building, Integer meter) {
        Building2Dao dao = new Building2DaoImpl();
        try {
            return dao.listMeteringByInterval(group, dataInit, dataEnd, meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building2Bean selectLastMeteringBuilding2(Integer meter) {
        Building2Dao dao = new Building2DaoImpl();
        try {
            return dao.selectLastMetering(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building2Bean selectBuilding2ByMeter(Integer meter) {
        Building2Dao dao = new Building2DaoImpl();
        try {
            return dao.selectBuildingByMeter(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    /*
     * Building3
     */
    public static Building3Bean insertOrUpdateMeteringBuilding3(Building3Bean building) {
        Building3Dao dao = new Building3DaoImpl();
        try {
            return dao.insereOuAltera(building);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static List<Building3Bean> listMeteringBuilding3() {
        Building3Dao dao = new Building3DaoImpl();
        try {
            return dao.listar();
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringAllIntervalBuilding3(String group, Date dataInit, Date dataEnd) {
        Building3Dao dao = new Building3DaoImpl();
        try {
            return dao.listMeteringAllInterval(group, dataInit, dataEnd);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringByIntervalBuilding3(String group, Date dataInit, Date dataEnd, Integer building, Integer meter) {
        Building3Dao dao = new Building3DaoImpl();
        try {
            return dao.listMeteringByInterval(group, dataInit, dataEnd, meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building3Bean selectLastMeteringBuilding3(Integer meter) {
        Building3Dao dao = new Building3DaoImpl();
        try {
            return dao.selectLastMetering(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building3Bean selectBuilding3ByMeter(Integer meter) {
        Building3Dao dao = new Building3DaoImpl();
        try {
            return dao.selectBuildingByMeter(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    /*
     * Building4
     */
    public static Building4Bean insertOrUpdateMeteringBuilding4(Building4Bean building) {
        Building4Dao dao = new Building4DaoImpl();
        try {
            return dao.insereOuAltera(building);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static List<Building4Bean> listMeteringBuilding4() {
        Building4Dao dao = new Building4DaoImpl();
        try {
            return dao.listar();
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringAllIntervalBuilding4(String group, Date dataInit, Date dataEnd) {
        Building4Dao dao = new Building4DaoImpl();
        try {
            return dao.listMeteringAllInterval(group, dataInit, dataEnd);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringByIntervalBuilding4(String group, Date dataInit, Date dataEnd, Integer building, Integer meter) {
        Building4Dao dao = new Building4DaoImpl();
        try {
            return dao.listMeteringByInterval(group, dataInit, dataEnd, meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building4Bean selectLastMeteringBuilding4(Integer meter) {
        Building4Dao dao = new Building4DaoImpl();
        try {
            return dao.selectLastMetering(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building4Bean selectBuilding4ByMeter(Integer meter) {
        Building4Dao dao = new Building4DaoImpl();
        try {
            return dao.selectBuildingByMeter(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    /*
     * Building5
     */
    public static Building5Bean insertOrUpdateMeteringBuilding5(Building5Bean building) {
        Building5Dao dao = new Building5DaoImpl();
        try {
            return dao.insereOuAltera(building);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static List<Building5Bean> listMeteringBuilding5() {
        Building5Dao dao = new Building5DaoImpl();
        try {
            return dao.listar();
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringAllIntervalBuilding5(String group, Date dataInit, Date dataEnd) {
        Building5Dao dao = new Building5DaoImpl();
        try {
            return dao.listMeteringAllInterval(group, dataInit, dataEnd);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ArrayList<Object[]> listMeteringByIntervalBuilding5(String group, Date dataInit, Date dataEnd, Integer building, Integer meter) {
        Building5Dao dao = new Building5DaoImpl();
        try {
            return dao.listMeteringByInterval(group, dataInit, dataEnd, meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building5Bean selectLastMeteringBuilding5(Integer meter) {
        Building5Dao dao = new Building5DaoImpl();
        try {
            return dao.selectLastMetering(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Building5Bean selectBuilding5ByMeter(Integer meter) {
        Building5Dao dao = new Building5DaoImpl();
        try {
            return dao.selectBuildingByMeter(meter);
        } catch (DaoException ex) {
            System.out.println(ex);
        }
        return null;
    }

}
