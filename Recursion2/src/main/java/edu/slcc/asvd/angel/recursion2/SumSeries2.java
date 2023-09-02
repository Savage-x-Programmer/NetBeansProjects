/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.slcc.asvd.angel.recursion2;

/**
 *
 * @author angelfigeralperezestevez
 */
public class SumSeries2 {

    public static double m(int n){
        if(n == 1)
            return 1.0 /3;
        else
            return m(n - 1) + (double)n / (2 * n + 1);
                    
    }
    
    
    public static void main(String[] args) {
        System.out.printf("%-10s%-15s\n", "i", "m(i)");
            for(int i = 1; i<11; i++){
                System.out.printf("%-10d%-15.6f\n", i, m(i));
            }

    }
}
