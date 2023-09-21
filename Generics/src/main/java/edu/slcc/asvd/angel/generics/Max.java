/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asvd.angel.generics;

import java.util.ArrayList;

/**
 *
 * @author angelfigeralperezestevez
 */
public class Max {
    public  static <E extends Comparable<E>> // generic type declaration 
        E // return tipe 
        max(E e1, E e2){ 
        return  e1.compareTo(e2) > 0 ? e1 : e2;
    }
     public static <U> void useUmethod(U u )
     {
         System.out.println(u);
     }
     
     public static <U, V> int useUmethod(ArrayList<U> u, ArrayList<V> v){
         return u.size() + v.size();
     }
        
    public static void main(String[] args) {
            
            System.out.println(Max.max(3, 4));
            System.out.println(Max.max("hrt", "tht"));
    
            Object o1 = new Object();
            Object o2 = new Object();
            System.out.println(Max.max(new A(10), new A(10)));
        
            
            ArrayList<Integer> ar1 = new ArrayList();
            ar1.add(10);
            
            ArrayList<String> ar2 = new ArrayList();
            ar2.add("john");
            
            
    
    }
    
}

 class A implements Comparable<A>{
    int x;
    A(int x ){this.x = x;}

    @Override
    public int compareTo(A o) {return this.x - o.x;}

    @Override
    public String toString() {return "A{" + "x=" + x + '}';}
    
    
}
