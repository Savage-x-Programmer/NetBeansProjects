package org.example;

public class selectionSortRModified {


    public static void selectionSortR(int[] ar, int low, int high) {
        if (low < high) {
            int indexOfMin = low;
            int min = ar[low];
            for (int i = low + 1; i <= high; i++) {
                if (ar[i] < min) {
                    min = ar[i];
                    indexOfMin = i;
                }
            }
            ar[indexOfMin] = ar[low];
            ar[low] = min;
            selectionSortR(ar, low + 1, high);
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
