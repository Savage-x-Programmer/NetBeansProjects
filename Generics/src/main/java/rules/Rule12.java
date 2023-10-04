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
public class Rule12 {
    public static void main(String[] args) {
        //no inheritance inside dimond
        // 
        
        List<List<Integer>> table = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<2; ++i){
            List<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j<3; ++j)
                row.add(i+j);
            table.add(row);
        }
        for(List<Integer>row: table){
            System.out.println(row);
        }
                
    }
}
