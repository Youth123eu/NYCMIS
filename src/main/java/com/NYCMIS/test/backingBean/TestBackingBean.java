/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.test.backingBean;

import com.NYCMIS.test.service.TestService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author surangi
 */
@Named(value = "testBackingBean")
@ViewScoped
public class TestBackingBean {

   @EJB
   TestService testService;
   public void marks(){
   int marks []={90,60,70,50};
       System.out.println(testService.calTo(marks));
   
   }
   
   
   
   
    
}
