/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asvd.angel.recursion2;

/**
 *
 * @author angelfigeralperezestevez
 */
public class SelectionSortR {

    public static void selectionSortR(int[] ar, int i, int j) {
        if (i == ar.length) {
            return;
        }
        if (j == ar.length) {
            ++i;
            j = 0;
        }
       
        
        if (ar[i] <= ar[j]) {
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
            

        } 
        if (i == ar.length -1 && j == ar.length -1) {
            return;
        }
        
        selectionSortR(ar, i, ++j);
    }

    public static void main(String[] args) {
        int[] ar = {8, 2, 1, 1, 7, 4, -1, 50, 49};

        selectionSortR(ar, 0, 0);

        for (int i = 0; i < ar.length; ++i) {
            System.out.print(ar[i] + " ");
        }
        System.out.println("");
    }

}
