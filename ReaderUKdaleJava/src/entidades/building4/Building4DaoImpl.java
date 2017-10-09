package entidades.building4;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author hendrio
 */
public class Building4DaoImpl extends BaseDaoImpl<Building4Bean> implements Building4Dao {

    public Building4DaoImpl() {
        super(Building4Bean.class);
    }

    @Override
    public ArrayList<Object[]> listMeteringAllInterval(String group, Date dataInit, Date dataEnd) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createSQLQuery("SELECT date_trunc(:group,b.datetime) as group_date, sum(b.power) as power FROM building4 b WHERE b.datetime \n"
                    + "BETWEEN :dataInit AND :dataEnd GROUP BY group_date ORDER BY group_date");
            q.setParameter("group", group);
            q.setParameter("dataInit", dataInit);
            q.setParameter("dataEnd", dataEnd);
            return (ArrayList<Object[]>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }

    @Override
    public ArrayList<Object[]> listMeteringByInterval(String group, Date dataInit, Date dataEnd, Integer meter) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createSQLQuery("SELECT date_trunc(:group,b.datetime) as group_date, sum(b.power) as power, b.meter, b.building FROM building4 b WHERE b.datetime \n"
                    + "BETWEEN :dataInit AND :dataEnd AND b.meter = :meter GROUP BY group_date, b.meter, b.building ORDER BY group_date");
            q.setParameter("group", group);
            q.setParameter("meter", meter);
            q.setParameter("dataInit", dataInit);
            q.setParameter("dataEnd", dataEnd);
            return (ArrayList<Object[]>) q.list();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }

    @Override
    public Building4Bean selectLastMetering(Integer meter) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM Building4Bean m WHERE m.meter = :meter AND m.id = (SELECT MAX(a.id) FROM Building4Bean a WHERE a.meter = :meter)");
            q.setParameter("meter", meter);
            return (Building4Bean) q.uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }
    
    @Override
    public Building4Bean selectBuildingByMeter(Integer meter) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT m FROM Building4Bean m WHERE m.meter = :meter");
            q.setParameter("meter", meter);
            return (Building4Bean) q.uniqueResult();
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (session != null) {
                try {
                    Conexao.closeSession();
                } catch (HibernateException h) {
                    System.out.println(h.getMessage());
                }
            }
        }
    }

}
