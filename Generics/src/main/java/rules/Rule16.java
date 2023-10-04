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
public class Rule16<T1> {
    List<?extends T1> list;
    
    public Rule16(ArrayList<? extends T1> list){
        this.list = list;
    }
    public Rule16(List<? extends T1> list){
        this.list = list;
    }
    
    public static void main(String[] args) {
       
    }
    
}
