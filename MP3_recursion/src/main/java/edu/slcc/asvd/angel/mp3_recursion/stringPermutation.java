package edu.slcc.asvd.angel.mp3_recursion;

import java.util.Scanner;

public class stringPermutation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String s;
        s = scan.nextLine();

        System.out.println("the permutation for String " + s + " are: ");
        displayPermutation(s);
    }

    private static void displayPermutation(String s) {
        displayPermutation("", s);
    }
    private static void displayPermutation(String s1, String s2) {
        if (s2.isEmpty()) {
            System.out.println(s1);
        } else {
            for (int i = 0; i < s2.length(); i++) {
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
            }
        }
    }

}