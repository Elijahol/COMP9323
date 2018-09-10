package com.vport.system.test;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Random;

public class Demo2 {
    public static void main(String[] args) {
        Random rand = new Random();
        NumberFormat nFormat= NumberFormat.getNumberInstance();
        
        nFormat.setMaximumFractionDigits(0);
        nFormat.setRoundingMode(RoundingMode.UP);
        for (int i = 0; i < 10; i++) {
            System.out.println(nFormat.format(rand.nextDouble()*5));
        }
        
    }
}
