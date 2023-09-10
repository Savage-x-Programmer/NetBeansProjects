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
public class OccurrencesOfSpecifiedCharacterInArray {
    
    public static int count1(char[] chars, char ch){
        return count1(chars, ch, chars.length -1);
    }
    
    
    public static int count( char[] chars, char ch, int high){
        //base
        if(high == 0){
            return 0;
        }
        //general solution that reaches the base and stops recurtion
        if(chars[high] == ch){
            return 1 + count(chars, ch, high-1);
        }
        else
            return count(chars, ch, high-1);
    }
    
    public static int count1( char[] chars, char ch, int high){
        //base
        if(high == 0){
            return 0;
        }
        //general solution that reaches the base and stops recurtion
        
        int counter;
        if(chars[high] == ch){
            System.out.print(high + "*");
            counter =  1 + count(chars, ch, high-1);
            
        }
        else
            System.out.print(high + "$");
            counter =  count(chars, ch, high-1);
        
        return counter;
    }
    
    public static void main(String[] args) {
        System.out.println("Enter a String: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] items = s.toCharArray();
        
        System.out.println("Enter a character: ");
        char ch = input.nextLine().trim().charAt(0);
        
        System.out.println(ch + " appears " + count1(items, ch) + " times");
        
    }
    
}
