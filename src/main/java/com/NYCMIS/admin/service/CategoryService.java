/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.service;

import com.NYCMIS.model.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import static org.eclipse.persistence.expressions.ExpressionOperator.Add;

/**
 *
 * @author surangi
 */
@Stateless
public class CategoryService {

    @PersistenceContext(unitName = "NYCMISPU")
    EntityManager em;

    // "Insert Code > Add Business Method")
    public List<Category> getAllCategory() // return viyauthu wanne category type eke object vitharai (genarics)
    {
        Query query = em.createQuery("select c from Category c");
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }
}
