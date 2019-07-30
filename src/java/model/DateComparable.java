/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
/**
 *
 * @author pc
 */
public class DateComparable implements Comparator<Articoli> {

    public int compare(Articoli p1, Articoli p2) {
        if ((p1.getData().getTime()) > (p2.getData().getTime())) {
            return -1;
        } 
        else if ((p1.getData().getTime()) < (p2.getData().getTime())) {
            return 1;
        }
        return 0;
    }

}
   


