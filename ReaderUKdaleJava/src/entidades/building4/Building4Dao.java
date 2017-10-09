package entidades.building4;

import java.util.ArrayList;
import java.util.Date;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface Building4Dao extends BaseDao<Building4Bean> {
    
    public ArrayList<Object[]> listMeteringAllInterval(String group, Date dataInit, Date dataEnd) throws DaoException;

    public ArrayList<Object[]> listMeteringByInterval(String group, Date dataInit, Date dataEnd, Integer meter) throws DaoException;

    public Building4Bean selectLastMetering(Integer meter) throws DaoException;
    
    public Building4Bean selectBuildingByMeter(Integer meter) throws DaoException;

}
