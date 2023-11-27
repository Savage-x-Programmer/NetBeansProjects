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
public class A3 {
    
    int x;
    public A3(){};

    public A3(int x) {
        this.x = x;
    }
    
    

    @Override
    public String toString() {
        return "A1{" + "x=" + x + '}';
    }
    public static void main(String[] args) {
        System.out.println("Sorting in decending order");
        List<A3> list1 = Arrays.asList(new A3(3), new A3(), new A3(2));
        
        Comparator<A3> c = new Comparator<A3>(){
            @Override
            public int compare(A3 o1, A3 o2) {
                return o2.x - o1.x;
            }
        };
        
        
        
        Collections.sort(list1 , c);
        System.out.println(list1);
        
       
    }
    
    
}
