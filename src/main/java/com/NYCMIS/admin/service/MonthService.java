/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.service;

import com.NYCMIS.model.Profit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class MonthService {

   @PersistenceContext(unitName = "NYCMISPU")
    EntityManager em;
  
   
   
   public void getProfitMonth(){
       
       String q = "select p from Profit p";//get all records from profit table
       Query query = em.createQuery(q);
      
       List <Profit> profitList = query.getResultList();//list ekak widihata gannawa  
        for (Profit p : profitList){
            
      System.out.println(p.getMonth());
       }
         
}
}