/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.backingbean;

import com.NYCMIS.admin.service.CategoryService;
import com.NYCMIS.model.Category;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author surangi
 */
@Named(value = "customerCategoryDisplayBacking")
@ViewScoped
public class customerCategoryDisplayBacking {

@EJB

CategoryService categoryService;
List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void readCategoryList()
    {
    categoryList= categoryService.getAllCategory();
    }

    
}
