/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.service;

import com.NYCMIS.model.Movie;
import static com.NYCMIS.model.Movie_.movieName;
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
public class MovieService {

    @PersistenceContext(unitName = "NYCMISPU")
    EntityManager em;

   // public Movie addNewMovie(Movie movie) {
        //em.persist(movie);
        //return movie;
   // }
    public List<Movie> getMovieByCategory(int id) // return viyauthu wanne category type eke object vitharai (genarics)
    {
        Query query = em.createQuery("SELECT m FROM Movie m WHERE m.categoryId.id=:id");
        query.setParameter("id", id);
        List<Movie> movieList = query.getResultList();
        return movieList;
    }
}

       
        
        
        
        
        
   
    


