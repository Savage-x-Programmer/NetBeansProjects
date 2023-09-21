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
public class GenericTest {
    public static int f1(ArrayList<Number> list){
        return 1;
    }
    public static int f3(ArrayList<? extends Number> list){
        return 1;
    }
            
    public static int f2(Number r){
        return 1;
    }
    public static void f5(A s){
        
    }
    public static void f6(ArrayList<A> s){
        
    }
     public static void f7(ArrayList<? super A> s){// lower bound
        
    }
    
    
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        //f1(l1);
        f3(l1);
        Integer i = 20;
        f2(i);
        ArrayList<? extends Number> l2 = l1;// upper bound
        f3(new ArrayList<Double>());
        
        Object o = new A();
        f5((A) o);

         ArrayList<Object> l3 = new ArrayList<Object>();
        
        //f6(l3);
        f7(l3);
       ArrayList<?> l4;
       ArrayList<? extends Object> l5;
    }
     
    
}
    class A{
        
    }
    class B<T>{
        public void  f1(ArrayList<? extends T> list){
            
        }
          
        public static void main(String[] args) {
            B<Integer> b= new B();
            b.f1(new ArrayList<Integer>());
            
        }
        
    }