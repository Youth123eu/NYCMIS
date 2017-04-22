/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.backingbean;

import com.NYCMIS.admin.service.EmployeeService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author surangi
 */
@Named(value = "employeeAddManagedBean")
@ViewScoped
public class EmployeeAddManagedBean {

   @EJB
  EmployeeService EmployeeService;
   
   
   
 public void updateSalary()
 {

  EmployeeService.getUpdatedSalary();
 }
    
}
