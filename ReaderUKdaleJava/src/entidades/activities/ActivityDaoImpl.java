/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.activities;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa
 */
public class ActivityDaoImpl extends BaseDaoImpl<ActivityBean> implements ActivityDao {

    public ActivityDaoImpl() {
        super(ActivityBean.class);
    }

    @Override
    public ActivityBean selectActivityByName(String name) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM ActivityBean a WHERE a.activity = :name");
            q.setParameter("name", name);
            return (ActivityBean) q.uniqueResult();
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
