package entidades.building3;

import java.util.ArrayList;
import java.util.Date;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface Building3Dao extends BaseDao<Building3Bean> {
    
    public ArrayList<Object[]> listMeteringAllInterval(String group, Date dataInit, Date dataEnd) throws DaoException;

    public ArrayList<Object[]> listMeteringByInterval(String group, Date dataInit, Date dataEnd, Integer meter) throws DaoException;

    public Building3Bean selectLastMetering(Integer meter) throws DaoException;
    
    public Building3Bean selectBuildingByMeter(Integer meter) throws DaoException;

}
