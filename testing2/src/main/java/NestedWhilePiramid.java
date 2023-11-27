/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author angelfigeralperezestevez
 */
public class NestedWhilePiramid {
    public static void main(String[] args) {
        String string = " ";
        int row = 0;
        int number = 0;
        
        while (row <= 7) {
            
             
            int column = 1;
            int column1 = 0;
            int column2 = row-1;
           
             
            // prints beginning blank strings
            while (column <= 7 - row) {
                
                System.out.printf("%4s", string);
                ++column;
            }

            // first half of row
            while (column1 <= row) {
                
                number = (int) Math.pow(2, column1);
                System.out.printf("%4d", number);
                ++column1;
            }

            // second half of row
            while (column2 >= 0) {
                
                number = (int) Math.pow(2, column2);
                System.out.printf("%4d", number);
                column2--;
            }
            // new line
            System.out.println();
            ++row;
        }

    }
}

