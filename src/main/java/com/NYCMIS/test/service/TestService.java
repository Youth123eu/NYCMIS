/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NYCMIS.test.service;

import javax.ejb.Stateless;

/**
 *
 * @author surangi
 */
@Stateless
public class TestService {

    public int calTo(int[] marks) {

        int cal = 0;
        for (int x : marks) {
            cal = cal + x;
        }
        return cal;

    }
}
