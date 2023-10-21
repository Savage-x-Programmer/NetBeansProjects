/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package angel.mp5datstruc;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author angelfigeralperezestevez
 */
public class Exercise2 {

    public static void main(String[] args) {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("Exercise2.txt", true));) {

            for (int i = 0; i < 100; i++) {
                dos.writeInt((int) (Math.random() * 10000));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
