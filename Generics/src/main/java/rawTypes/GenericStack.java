/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rawTypes;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 *
 * @author angelfigeralperezestevez
 */
public class GenericStack<T> {
    
    private T[] elements;
    private ArrayList<T> elementsList;
    private ArrayList<Object> elementsList1;
    private ArrayList elementsList2;
    
    private int top = 0;
    static int SIZE = 4;
    T t;
    
    public GenericStack()
    {
        elements = (T[]) new Object[SIZE];
        T t = (T) new Object();
        elementsList = new ArrayList<>();
        elementsList1 = new ArrayList<Object>();
        elementsList2 = new ArrayList<>();
    }
    
    public boolean push(T element)
    {
        if (top == SIZE)
            throw new StackOverflowError();
        elements[top++] = element;
        
        elementsList.add(element);
        elementsList1.add(element);
        elementsList2.add(element);
        return true;
    }
    
    public T pop()
    {
        if (top == 0)
            throw new EmptyStackException();
        elementsList.remove(top-1);
        elementsList1.remove(top-1);
        elementsList2.remove(top-1);
        return elements[--top];
    }
    
    public T peek()
    {
        if (top == 0)
            throw new EmptyStackException();
        return elements[top-1];
    }
    
    

    @Override
    public String toString() 
    {
        String s = "[ ";
        for (int i = top-1; i >= 0; --i)
            s += this.elements[i] + " ";
        s += "]";
        s += "\n T ";
        for (int i = top-1; i >= 0; --i)
            s += this.elementsList.get(i) + " ";
        s += "\n Object ";
        for (int i = top-1; i >= 0; --i)
            s += this.elementsList1.get(i) + " ";
        s += "\n List ";
        for (int i = top-1; i >= 0; --i)
            s += this.elementsList2.get(i) + " ";
        return s;
    }
    
    public static void main(String[] args) {
         GenericStack<Integer> gsi = new GenericStack<Integer>();
        GenericStack<String> gss = new GenericStack<String>();
//        gsi.pop();
        gsi.push(10);
        gsi.push(20);
        gsi.push(30);
        gsi.push(40);
        System.out.println(gsi.peek());
//        gsi.push(50);
        System.out.println(gsi.pop());
        System.out.println(gsi);
        
        gss.push("john");
        gss.push("mary");
        System.out.println(gss);
        GenericStack<TestGenericStack> gst = new GenericStack<TestGenericStack>();
        gst.push(new TestGenericStack(10));
        gst.push(new TestGenericStack(20));
        gst.push(new TestGenericStack(30));
        System.out.println(gst);
         
       
       
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    }
    
     class TestGenericStack{
        int x;
        
        public TestGenericStack(int x){
            this.x = x;
        }

        @Override
        public String toString() {
            return "TestGenericStack{" + "x=" + x + '}';
        }
        
    }
    

