/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asvd.angel.recursion2;

/**
 *
 * @author angelfigeralperezestevez
 */
public class UpperCaseArray {
    public static int countUpper( char[] chars, int index){
        if(index == chars.length)
            return 0;
        
        //System.out.println(index);
        if(Character.isUpperCase(chars[index])){
            return 1 + countUpper(chars, index + 1);
        }
        else{
             return 0+ countUpper(chars, index + 1);
        }
       

        
        
    }
    public static void main(String[] args) {
        System.out.println(countUpper("AbcDEdfuhfudhA".toCharArray(), 0));
    }
    
    
}
