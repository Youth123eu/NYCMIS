/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.backingbean;

import com.NYCMIS.admin.service.MovieService;
import com.NYCMIS.model.Movie;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author surangi
 */
@Named(value = "customerProductDiplayBacking")
@ViewScoped
public class customerProductDiplayBacking {

 @EJB
 
 MovieService movieService;
 
 private int categoryId;
 private List<Movie>movieList;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
  
 public void readMovieByCategory()
 {
 movieList = movieService.getMovieByCategory(categoryId);
 
 
 }
 
}
