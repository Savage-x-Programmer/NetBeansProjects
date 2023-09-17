/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asvd.angel.generics;

import java.util.EmptyStackException;

/**
 *
 * @author angelfigeralperezestevez
 */
public class GenericStack<T> {
    
    private T[] elements;
    private int top;
    static int SIZE = 4;
    T t;
    
    public GenericStack() {
        elements = (T[]) new Object[SIZE];
    }
    
    public  boolean push(T element){
        if(top == SIZE){
            throw new StackOverflowError();
        }
        elements[top++] =element;
        return true;
    }
    
    public T pop(){
        
        if(top == 0)
            throw new EmptyStackException();
        return elements[--top];
        


    }
    public T peek(){
        
        if(top == 0)
            throw new EmptyStackException();
        return elements[top-1];
        


    }

    @Override
    public String toString() {
        String s = "[";
        for(int i = top-1; i >= 0; --i)
            s+= this.elements[i].toString() + " ";
        s+= " ]";
        return s;
    }
    public static void main(String[] args) {
         GenericStack<Integer> gsi = new GenericStack<Integer>();
         GenericStack<Integer> gss = new GenericStack<Integer>();
         
         gsi.push(10);
         gsi.push(20);
         gsi.push(30);
         gsi.push(40);
         //gsi.push(50);
         
         System.out.println(gsi.peek());
         Integer popped = gsi.pop();
         System.out.println(popped);
         
         System.out.println(gsi);
    }
    
}
