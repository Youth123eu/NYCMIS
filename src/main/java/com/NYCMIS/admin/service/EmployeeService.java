/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.service;

import com.NYCMIS.model.Employee;
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
public class EmployeeService {

    @PersistenceContext(unitName = "NYCMISPU")
    EntityManager em;

    public void getUpdatedSalary() {

        String q = "select e from Employee e";//get all records from profit table
        Query query = em.createQuery(q);

        List<Employee> employeeList = query.getResultList();//list ekak widihata gannawa  

        for (Employee e : employeeList) {

            if (e.getSalary() > 10000)
            {
                e.setTotSalary(e.getSalary() + 2000);
            }
            else
            {
                e.setTotSalary(e.getSalary());
                    }

        }

    }
}
