package org.example;

import java.util.Scanner;

public class selectionSortTwoRecursiveCalls {
    public static void selectionSort(int [] ar, int i, int j){


    if(i == ar.length - 1)
            return;

        if(j == ar.length)
            return;

        if(ar[i] > ar[j])
            {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
            }
        selectionSort(ar, i, ++j);

        selectionSort(ar, ++i, i + 1);

    }

    public static void main(String[] args) {

        int[]ar = {10,1,20,3};
        selectionSort(ar, 0, 0);
        for(int i = 0; i <= ar.length -1; ++i){
            System.out.println(ar[i]);
        }



    }
}
