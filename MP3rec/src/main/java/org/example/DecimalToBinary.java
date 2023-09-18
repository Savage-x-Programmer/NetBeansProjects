package org.example;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println("Please enter a decimal number you wish to convert to binary: ");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int decimal = scan.nextInt();

        System.out.println(decimal +" in binary is " + decimalToBinary(decimal));
    }

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "";
        } else {
            return decimalToBinary(decimal / 2) + decimal % 2;
        }
    }








}
