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
public class A4<E extends Comparable> {

    E x;

    public A4() {
    }

    ;

    public A4(E x) {
        this.x = x;
    }

    public static Comparator<A4> comparator() {
        Comparator<A4> c = new Comparator<A4>() {
            @Override
            public int compare(A4 o1, A4 o2) {
                return o1.x.compareTo(o2.x);
            }}; 
                return c;
    }
    public static Comparator<A4> comparatorReverse() {
        Comparator<A4> c = new Comparator<A4>() {
            @Override
            public int compare(A4 o1, A4 o2) {
                return o2.x.compareTo(o1.x);
            }}; 
                return c;
    }
     


    @Override
    public String toString() {
        return "A1{" + "x=" + x + '}';
    }

    public static void main(String[] args) {
        System.out.println("Sorting in accending order");
        List<A4> list1 = Arrays.asList(new A4(new Integer(4)), new A4(new Integer(1)), new A4(new Integer(2)));

        Collections.sort(list1 ,A4.comparator());
        
        List<A4> list2 = Arrays.asList(new A4(new String("once")), new A4(new String("upon")),
                new A4(new String("a")), new A4( new String("time")), new A4(new String("in")), new A4(new String("america")));
        
        
        Collections.sort(list2 ,A4.comparator());

    System.out.println (list2);
    
    };
        
        
        
    

}


