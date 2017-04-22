/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.admin.backingbean;

import com.NYCMIS.admin.service.BookService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author surangi
 */
@Named(value = "bookDisplayBackingBean")
@ViewScoped
public class BookDisplayBackingBean {

    @EJB
    BookService bookService;

    public void readAllBooksNames() {
        bookService.getAllBooks();
    }
    
    
     public void displayAllQuantity() {
        bookService.getQuantity();
    }
     
          public void displayReorderLevel() {
        bookService.getQuantity();
    }
          
    public void displaySinhalaNovel() {
        bookService.getSinhalaNovel("Sinhala Novel");
    }
    
    public void displayprice400Novel() {
        bookService.get400PriceNovel();
    }
    
      public void displayTotalPriceStockInHand() {
        bookService.getStockInHandPrice();
    }

}
