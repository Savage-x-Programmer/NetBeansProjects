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
public class A4_1<E extends Comparable> {

    E x;

    public A4_1() {
    }

    ;

    public A4_1(E x) {
        this.x = x;
    }

    public static Comparator<A4_1> comparator() {
        Comparator<A4_1> c = new Comparator<A4_1>() {
            @Override
            public int compare(A4_1 o1, A4_1 o2) {
                return o1.x.compareTo(o2.x);
            }}; 
                return c;
    }
    public static Comparator<A4_1> comparatorReverse() {
        Comparator<A4_1> c = new Comparator<A4_1>() {
            @Override
            public int compare(A4_1 o1, A4_1 o2) {
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
        List<A4_1> list1 = Arrays.asList(new A4_1(new Integer(4)), new A4_1(new Integer(1)), new A4_1(new Integer(2)));

        Collections.sort(list1 ,A4_1.comparatorReverse());
        
        List<A4_1> list2 = Arrays.asList(new A4_1(new String("once")), new A4_1(new String("upon")),
                new A4_1(new String("a")), new A4_1( new String("time")), new A4_1(new String("in")), new A4_1(new String("america")));
        
        
        Collections.sort(list2 ,A4_1.comparatorReverse());

    System.out.println (list2);
        System.out.println("\n" + list1);
    };
        
        
        
    

}


