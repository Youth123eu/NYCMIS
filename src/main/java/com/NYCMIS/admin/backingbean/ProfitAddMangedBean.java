/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.backingbean;

import com.NYCMIS.admin.service.ProfitService;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author surangi
 */
@Named(value = "profitAddMangedBean")
@ViewScoped
public class ProfitAddMangedBean {

 @EJB
  ProfitService ProfitService;
 public void callingToDisplayNetProfit()
 {

  ProfitService.getProfitByNetProfit();
 }
 
 
 
  public void callingMoreProfit()
 {

  ProfitService.getMoreProfit();
 }
  
  
    public void callingNumOfMoreProfit()
 {

  ProfitService.getNumOfMonthsMoreProfit();
 }
    
 
 
 }
          