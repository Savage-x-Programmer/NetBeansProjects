/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rules;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angelfigeralperezestevez
 */
public class GenericsRule8<T1> {
    List<? extends T1> lista = new ArrayList<String>();
    
    public static <T2> void f8(List<? extends T2> list){
        System.out.println(list.size());
        //list.add(new C());
    }
    public static void main(String[] args) {
        List<A> list1 = new ArrayList();
        list1.add(new C());
        list1.add(new B());
        f8(list1);
        
        ArrayList<String> list2 = new ArrayList();
        list1.add(new A());
        f8(list2);
        
        ArrayList<String> list3 - new ArrayList<String>();
        list3.add("abc");
        f8(list3);
                
    }
    
}
