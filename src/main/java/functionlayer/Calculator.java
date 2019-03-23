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

    public HashMap<String, HashMap<String, Integer>> calculate(int height, int length, int width) {
        HashMap<String, HashMap<String, Integer>> pieces = new HashMap<>();

        int doorlength = 4;
        int doorheight = 6;
        int windowlength = 4;
        int windowheight = 4;

        int longest = 0;
        int shortest = 0;
        
        if(length > width) {
            longest = length;
            shortest = width;
        } else {
            longest = width;
            shortest = length;
        }
        
        if(height > doorheight && longest >= doorlength + 4) {
            pieces.put("side1", calcWindow(height, longest, windowheight, windowlength));
            pieces.put("side2", calcWindow(height, shortest, 0, 0));
            pieces.put("side3", calcWindow(height, longest, doorheight, doorlength));
            pieces.put("side4", calcWindow(height, shortest, 0, 0));
        } else {
            pieces.put("side1", calcWindow(height, longest, 0, 0));
            pieces.put("side2", calcWindow(height, shortest, 0, 0));
            pieces.put("side3", calcWindow(height, longest, 0, 0));
            pieces.put("side4", calcWindow(height, shortest, 0, 0));
        }
        return pieces;
    }

    private HashMap<String, Integer> calcWindow(int height, int length, int windowheight, int windowlength) {
        HashMap<String, Integer> h = new HashMap<>();
        int big = 4;
        int med = 2;
        int small = 1;
        
        int nob = 0;
        int nom = 0;
        int nos = 0;

        for (int i = 0; i < height; i++) {
            int tmp = length;

            while(true) {
                if(windowheight > 0) {
                    tmp -= windowlength;
                    windowheight--;
                    h.put("door", 1);
                    h.put("window", 1);
                    
                    if(tmp == 4) {
                        nom +=2;
                        break;
                    }
                }
                
                while (true) {
                    if (tmp - big >= 0) {
                        tmp -= big;
                        nob++;
                    } else if (tmp - med >= 0) {
                        tmp -= med;
                        nom++;
                    } else if (tmp - small >= 0) {
                        tmp -= small;
                        nos++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        
        h.put("2x4", nob);
        h.put("2x2", nom);
        h.put("2x1", nos);
        
        return h;
    }
}
