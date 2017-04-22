/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.service;

import com.NYCMIS.model.Center;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author surangi
 */
@Stateless
public class CenterService {

    @PersistenceContext(unitName = "NYCMISPU")
    EntityManager em;
    
     public Center addNewCenter(Center center) {
   em.persist(center);
        return center;
}
}