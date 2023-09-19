package org.example;

public class selectionSortRModified {


    public static void selectionSortR(int[] ar, int l, int j) {
        if (l < j) {
            int indexOfMin = l;
            int min = ar[l];
            for (int i = l + 1; i <= j; i++) {
                if (ar[i] < min) {
                    min = ar[i];
                    indexOfMin = i;
                }
            }
            ar[indexOfMin] = ar[l];
            ar[l] = min;
            selectionSortR(ar, l + 1, j);
        }
    }

    public static void main(String[] args) {
        int[] ar = {8, 2, 1, 1, 7, 4, -1, 50, 49};

        selectionSortR(ar, 0, ar.length - 1);

        for (int i = 0; i < ar.length; ++i) {
            System.out.print(ar[i] + " ");
        }
        System.out.println("");
    }
}
