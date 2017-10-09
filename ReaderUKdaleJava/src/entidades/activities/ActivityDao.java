/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.activities;

import util.BaseDao;
import util.DaoException;

/**
 *
 * @author Wesllen Sousa
 */
public interface ActivityDao extends BaseDao<ActivityBean> {

    public ActivityBean selectActivityByName(String name) throws DaoException;

}
