package entidades.building1;

import java.util.ArrayList;
import java.util.Date;
import util.BaseDao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public interface Building1Dao extends BaseDao<Building1Bean> {

    public ArrayList<Object[]> listMeteringAllInterval(String group, Date dataInit, Date dataEnd) throws DaoException;

    public ArrayList<Object[]> listMeteringByInterval(String group, Date dataInit, Date dataEnd, Integer meter) throws DaoException;

    public Building1Bean selectLastMetering(Integer meter) throws DaoException;

    public Building1Bean selectBuildingByMeter(Integer meter) throws DaoException;

}
