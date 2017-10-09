/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.appliance;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.BaseDaoImpl;
import util.Conexao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa
 */
public class ApplianceDaoImpl extends BaseDaoImpl<ApplianceBean> implements ApplianceDao {

    public ApplianceDaoImpl() {
        super(ApplianceBean.class);
    }

    @Override
    public ApplianceBean selectApplianceByName(String name) throws DaoException {
        try {
            this.session = Conexao.getSession();
            Query q = session.createQuery("SELECT a FROM ApplianceBean a WHERE a.name = :name");
            q.setParameter("name", name);
            return (ApplianceBean) q.uniqueResult();
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
