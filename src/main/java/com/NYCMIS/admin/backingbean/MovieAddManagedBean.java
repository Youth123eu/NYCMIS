/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.backingbean;

import com.NYCMIS.admin.service.CategoryService;
import com.NYCMIS.model.Category;
import com.NYCMIS.model.Movie;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author surangi
 */
@Named(value = "movieAddManagedBean")
@ViewScoped
public class MovieAddManagedBean {

@EJB
CategoryService categoryService;
 
//public void test()
//{
// List<Category> categorList = categoryService.getAllCategory();
// 
// for(Category c:categorList)
// {
//     System.out.println(c.getCtegoryName());
// }
//}

List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

@PostConstruct
public void init()
{
categoryList = categoryService.getAllCategory();
}

@Named
@Produces
@RequestScoped
Movie movie = new Movie();

}
 
