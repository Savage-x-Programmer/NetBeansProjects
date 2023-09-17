package org.example;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println("Please enter a decimal number you wish to convert to binary: ");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int decimal = scan.nextInt();
        decimalToBinary(decimal);
        // System.out.println("The binary equivalent of " + decimal + " is: ");
    }
    public static void decimalToBinary(int decimal){
        if (decimal == 0) {
            System.out.println("0");
        } else {
            System.out.print(decimal % 2);
            decimalToBinary(decimal / 2);
        }


    }
}
