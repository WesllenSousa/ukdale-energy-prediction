package entidades.building5;

import java.util.ArrayList;
import java.util.Date;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface Building5Dao extends BaseDao<Building5Bean> {
    
    public ArrayList<Object[]> listMeteringAllInterval(String group, Date dataInit, Date dataEnd) throws DaoException;

    public ArrayList<Object[]> listMeteringByInterval(String group, Date dataInit, Date dataEnd, Integer meter) throws DaoException;

    public Building5Bean selectLastMetering(Integer meter) throws DaoException;
    
    public Building5Bean selectBuildingByMeter(Integer meter) throws DaoException;

}
