/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rules;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angelfigeralperezestevez
 */
public class Rule5 {
   //what is outside the diamond must be sub (or the same class) 
    //of the LHS and what is inside the diamond can be any type. we still cannot modify the variables
    
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<Integer>();
        ArrayList<?>list2 = new ArrayList<Double>();
        ArrayList<?>list3 = new ArrayList<String>();
        //list3.add("abc");
        
    }
    
}
