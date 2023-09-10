/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asvd.angel.recursion2;

/**
 *
 * @author angelfigeralperezestevez
 */
public class nestedLoopIndexes {
    final static int ROWS = 2;
    final static int COLUMNS = 3;
    
    public static void nestedLoopIndexR(int i, int j){
        if(j == COLUMNS)
        {
            
            return;
        }
        if(i == ROWS)
            return;
        
        System.out.print("\ti, j " + i + ", " + j);
        nestedLoopIndexR(i, j++);
        if(j == COLUMNS -1){
            System.out.println("");
            nestedLoopIndexR(++i, 0);}
    
    
    }
    public static void main(String[] args) {
        nestedLoopIndexR(0,0);
    }
    
}
