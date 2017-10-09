/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.appliance;

import util.BaseDao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa
 */
public interface ApplianceDao extends BaseDao<ApplianceBean> {

    public ApplianceBean selectApplianceByName(String name) throws DaoException;

}
