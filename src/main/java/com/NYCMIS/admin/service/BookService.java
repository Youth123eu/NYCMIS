/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.service;

import com.NYCMIS.model.Book;
import static com.NYCMIS.model.Book_.sellingPrice;
import com.NYCMIS.model.Type;
import static com.NYCMIS.model.Type_.typeName;
import java.awt.BorderLayout;
import static java.lang.System.out;
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
public class BookService {

    @PersistenceContext(unitName = "NYCMISPU")
    EntityManager em;

    public void getAllBooks() {

        String q = "select b from Book b";//get all records from profit table
        Query query = em.createQuery(q);
        List<Book> bookList = query.getResultList();
        for (Book b : bookList) {

            System.out.println(b.getTitle());
        }

    }

    public void getQuantity() {

        String q = "select b from Book b where b.stockInHand<b.reOrderLevel";//get all records from profit table
        Query query = em.createQuery(q);
        List<Book> bookList = query.getResultList();

        for (Book b : bookList) {
            System.out.println(b.getTitle());
        }

    }

    /* public void getSinhalaNovel() {

     String q = "select b from Book b where b.typeId = 1";//get all records from profit table
     Query query = em.createQuery(q);
     List<Book> bookList = query.getResultList();
        
     for (Book b : bookList){
     System.out.println(b.getTitle());   
     }
 
     } */
    public void getSinhalaNovel(String typeName) {

        String q = "select b from Book b where b.type.typeName = :typeName";
        Query query = em.createQuery(q);
        query.setParameter("typeName", typeName);

        List<Book> bookList = query.getResultList();
        for (Book b : bookList) {
            System.out.println(b.getTitle());
        }

    }

    public void get400PriceNovel() {

        String q = "select b from Book b where b.sellingPrice=400";
        Query query = em.createQuery(q);
        List<Book> bookList = query.getResultList();
        for (Book b : bookList) {

            System.out.println(b.getTitle());
        }
    }
    
      public void getStockInHandPrice() {

        String q = "select b from Book b ";
        Query query = em.createQuery(q);
        List<Book> bookList = query.getResultList();
        int total = 0;
        for (Book b : bookList) {

          
            System.out.println(b.getTitle());
        }
    }

}

//public void test(){
     
    // Book book = new Book();
     
    // Type type = book.getType();
     
    // }
    

