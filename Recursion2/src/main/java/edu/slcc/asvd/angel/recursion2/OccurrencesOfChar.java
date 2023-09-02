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
public class OccurrencesOfChar
{
    public static int count(String str, char a){
        int result = 0;
        if(str.length() > 0){
            result = count(str.substring(1), a) + ((str.charAt(0) == a) ? 1 : 0);
        }
        return result;
    }
    public static int count1(String str, char a){
      return 1;  
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String");
        String s = input.nextLine();
        System.out.println("Enter a character");
        char ch = input.nextLine().charAt(0);
        int times = count(s, ch);
        System.out.println(ch + " appears " + times + (times > 1 ? "times " : " time ") + "in " + s);
    }
}
