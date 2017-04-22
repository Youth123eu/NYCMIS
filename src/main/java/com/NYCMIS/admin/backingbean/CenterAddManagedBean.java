/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.backingbean;

import com.NYCMIS.admin.service.CenterService;
import com.NYCMIS.model.Center;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;
import static org.eclipse.persistence.internal.jpa.metadata.xml.XMLEntityMappingsReader.clear;

/**
 *
 * @author surangi
 */

@Named(value = "CenterAddManagedBean")
@ViewScoped
public class CenterAddManagedBean {

    @EJB
    CenterService centerService;

    @Named
    @Produces
    @RequestScoped

    Center center = new Center();

    public CenterService getCenterService() {
        return centerService;
    }

    public void setCenterService(CenterService centerService) {
        this.centerService = centerService;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public String createCenter() {
        center = centerService.addNewCenter(center);
//FaceletContext.getCurrentInstance().addMessage(null, new FacesMessage(center.getClass()+ "Saved succesfully"));
        //clear();
        return null;
    }
}
