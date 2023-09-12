/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asvd.angel.mp3_recursion;

/**
 *
 * @author angelfigeralperezestevez
 */
public class A implements Comparable{
    int x;
    
    @Override
    public int compareTo(Object o) {
        return this.x - ((A)o).x;

    }
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        
        System.out.println(a1.compareTo(a2));
        System.out.println(a1.compareTo("gdefg"));
    }
    
}
