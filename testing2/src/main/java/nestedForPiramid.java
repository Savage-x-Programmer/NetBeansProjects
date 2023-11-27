/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author angelfigeralperezestevez
 */
public class nestedForPiramid {
    public static void main(String[] args) {
        String string = " ";

        int number = 0;
        for (int row = 0; row <= 7; row++)
        {
            // prints beginning blank strings
            for (int column = 1; column <= 7 - row; column++)
            {
                System.out.printf("%4s", string);
            }

            // first half of row
            for (int column = 0; column <= row; column++)
            {
                number = (int) Math.pow(2, column);

                System.out.printf("%4d", number);
            }

            // second half of row
            for (int column = row - 1; column >= 0; column--)
            {
                number = (int) Math.pow(2, column);

                System.out.printf("%4d", number);
            }
            // new line
            System.out.println();
        }

    }
}
