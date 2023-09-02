/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asvd.angel.recursion2;

import java.util.Scanner;

/**
 *
 * @author angelfigeralperezestevez
 */
public class ReverseInt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an interger: ");
        int i = input.nextInt();
//        System.out.println("the reversal of " + i + " is ");
//        reverseDisplay(i);
//        System.out.print(" ");
        
        
        System.out.println(reverseNumber(i));
    }

    public static void reverseDisplay(int value) {
        if (value != 0) {
            System.out.print(value % 10);
            value = value / 10;
            reverseDisplay(value);
        }

    }

    public static String reverseNumber(int x) {

        if (x == 0) {
            return "";
        }

        return Integer.toString(x % 10
        ) + reverseNumber(x / 10);

    }
}
