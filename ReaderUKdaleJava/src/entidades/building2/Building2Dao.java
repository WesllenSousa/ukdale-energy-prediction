package entidades.building2;

import java.util.ArrayList;
import java.util.Date;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface Building2Dao extends BaseDao<Building2Bean> {
    
    public ArrayList<Object[]> listMeteringAllInterval(String group, Date dataInit, Date dataEnd) throws DaoException;

    public ArrayList<Object[]> listMeteringByInterval(String group, Date dataInit, Date dataEnd, Integer meter) throws DaoException;

    public Building2Bean selectLastMetering(Integer meter) throws DaoException;
    
    public Building2Bean selectBuildingByMeter(Integer meter) throws DaoException;

}
