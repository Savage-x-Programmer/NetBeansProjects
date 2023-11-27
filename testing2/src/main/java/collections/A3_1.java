/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author angelfigeralperezestevez
 */
public class A3_1 {

    int x;

    public A3_1() {
    }

    ;

    public A3_1(int x) {
        this.x = x;
    }

    public static Comparator<A3_1> comparator() {
        Comparator<A3_1> c = new Comparator<A3_1>() {
            @Override
            public int compare(A3_1 o1, A3_1 o2) {
                return o1.x - o2.x;
            }}; 
                return c;
    }
    
     


    @Override
    public String toString() {
        return "A1{" + "x=" + x + '}';
    }

    public static void main(String[] args) {
        System.out.println("Sorting in accending order");
        List<A3_1> list1 = Arrays.asList(new A3_1(3), new A3_1(), new A3_1(2));

    Collections.sort(list1 ,A3_1.comparator());

    System.out.println (list1);
    
    };
        
        
        
    

}


