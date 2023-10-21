package angel.mp5datstruc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Exercise1 {

    public static void main(String[] args) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Exercise1.txt"), true));) {
            for (int i = 0; i < 100; i++) {
                pw.print((int) (Math.random() * 100) + " ");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Cant create file");
            ex.printStackTrace();
        }
    }

}
