/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asvd.angel.recursion2;

/**
 *
 * @author angelfigeralperezestevez
 */
public class SumOfDigits {

    public static int sumOfDigits(int x) {
        if (x == 0) {
            return 0;
        }
        int r = x % 10;
        int q = x / 10;

        int sum =  r + sumOfDigits(q);
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(sumOfDigits(123));
    }

}
