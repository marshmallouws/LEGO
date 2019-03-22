/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

import java.util.HashMap;

/**
 *
 * @author Annika
 */
public class Calculator {
    
    public HashMap<String, Integer> calculate(int height, int length, int width) {
        HashMap<String, Integer> pieces = new HashMap<>();
        
        int big = 4;
        int med = 2;
        int small = 1;
        
        int nob = 0;
        int nom = 0;
        int nos = 0;
        
        while(true) {
            if(length-big >= 0) {
                length -= big;
                nob++;
            } else if (length-med >= 0) {
                length -= med;
                nom++;
            } else if (length-small >= 0) {
                length -= small;
                nos++;
            } else {
                break;
            }
        }
        
        width -=4;
        
        while (true) {
            if(width-big >= 0) {
                width -= big;
                nob++;
            } else if (width-med >= 0) {
                width -= med;
                nom++;
            }  else if (width-small >= 0) {
                width -= small;
                nos++;
            } else {
                break;
            }
        }
        
        nob *= 2*height;
        nom *= 2*height;
        nos *= 2*height;
        
        pieces.put("2x4", nob);
        pieces.put("2x2", nom);
        pieces.put("2x1", nos);

        return pieces;
        
    }
}
