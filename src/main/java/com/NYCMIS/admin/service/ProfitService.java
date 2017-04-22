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

/**
 *
 * @author surangi
 */
@Stateless
public class ProfitService {

   @PersistenceContext(unitName = "NYCMISPU")
    EntityManager em;
   
   
   public void getProfitByNetProfit(){
       
       String q = "select p from Profit p";//get all records from profit table
       Query query = em.createQuery(q);
      
       List <Profit> profitList =query.getResultList();//list ekak widihata gannawa
       int total = 0;
       for (Profit p : profitList){
       total = total + p.getNetProfit();
      
           
       }
       System.out.println(total);
       
   }
   
   public void getMoreProfit(){
   
   String q = "select p from Profit p where p.netProfit>13000";
   Query query = em.createQuery(q);
   
   List <Profit> profitList = query.getResultList();
   for(Profit p : profitList){
   
       System.out.println(p.getMonth());
   }
   
   }
   
   
   
   
    public void getNumOfMonthsMoreProfit(){
   
   String q = "select p from Profit p where p.netProfit>13000";
   Query query = em.createQuery(q);
   
   List <Profit> profitList = query.getResultList();
  
   
       System.out.println(profitList.size()+" Month(s)");
   
   
   }
  
}
