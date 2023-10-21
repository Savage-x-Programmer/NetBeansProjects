/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package angel.mp5datstruc;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author angelfigeralperezestevez
 */
public class Exercise3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int sum = 0;

        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("Exercise3.txt"));) {
            while (true) {
                sum += dis.readInt();
            }
        } catch (EOFException eof) {
            System.out.println("reading is  complete.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("The sum of the values in the file is: " + sum);
    }
}
