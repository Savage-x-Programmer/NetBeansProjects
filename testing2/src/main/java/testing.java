
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author angelfigeralperezestevez
 */
public class testing {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the number of students");
        final int NUMOFSTUDENTS = scan.nextInt();
        System.out.println();
        
        String [] studentName;
        int[] studentScore;
        
        studentName = new String[NUMOFSTUDENTS];
        studentScore = new int[NUMOFSTUDENTS];
        
        
        
        System.out.println("please enter a students name");
        String student1 = scan.next();

        System.out.println("please enter the students score");
        int score1 = scan.nextInt();

        String student2 = "";
        int score2 = 0;

        for (int i = 0; i < NUMOFSTUDENTS - 1 ; ++i) {

            System.out.println("please enter a students name");
            String student = scan.next();

            System.out.println("please enter the students score");
            int score = scan.nextInt();
            
            if(score > score1){
                score1 = score;
                student1 = student;
                
            }
            else if(score > score2){
                score2 = score;
                student2 = student;
            }

            System.out.println(i);
        }
        System.out.println("the student with the highest score is: " + student1);
        System.out.println("the student with the second  highest score is " + student2);

    }

}
