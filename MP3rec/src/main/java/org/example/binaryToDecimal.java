package org.example;

import java.util.Scanner;

public class binaryToDecimal {
    public static void main(String[] args) {
       while(true) {
           Scanner scan = new Scanner(System.in);

           System.out.println("Enter a binary number: ");
           String binaryString = scan.next();
           System.out.println("The decimal value for binary number " + binaryString + " is " + binaryToDecimal(binaryString));
       }
       }
    public static int binaryToDecimal(String binaryString) {

        return binaryToDecimal(binaryString, 0, binaryString.length() - 1);
    }
    public static int binaryToDecimal(String binaryString, int low, int high) {
        if (high < low) {
            return 0;
        } else if (high == low) {
            return binaryString.charAt(low) == '0' ? 0 : 1;
        } else {
            int mid = (low + high) / 2;
            return binaryToDecimal(binaryString, low, mid) * 2 + binaryToDecimal(binaryString, mid + 1, high);
        }
    }


}
