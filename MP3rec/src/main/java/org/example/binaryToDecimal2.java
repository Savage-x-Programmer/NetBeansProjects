package org.example;

import java.util.Scanner;

import static java.lang.Character.*;

public class binaryToDecimal2 {

    public static void main(String[] args) {
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a binary number: ");
            String binaryString = scan.next();
            //int test =(getNumericValue((binaryString.charAt(0)))) * ((int)Math.pow(2,2));
            System.out.println(binaryString + " in decimal is " + binaryToDecimal(binaryString));

        }
    }
    public static int binaryToDecimal(String binaryString) {

        return binaryToDecimal(binaryString, 0, binaryString.length() - 1);
    }
    public static int binaryToDecimal(String binaryString, int low, int high) {
        if(low != binaryString.length()){
           return (binaryToDecimal(binaryString, ++low, --high) + ((getNumericValue((binaryString.charAt(--low)))) * ((int) Math.pow(2, ++high))));
       } return 0;}



}
