/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rules;

import java.util.ArrayList;

/**
 *
 * @author angelfigeralperezestevez
 */
public class Rule4 {
    //fixes the inheritance insid=e the diamonds. however we cannot modify the ArrayList<?> 
    //because the compiler does not know the exact type of the wildcard
    public static void f1(ArrayList<?> list){
        System.out.println(list.size());
        //list.add(new Integer(5));
    }
    public static void main(String[] args) {
        f1(new ArrayList<Integer>());
        f1(new ArrayList<Double>());
        
    }
}
