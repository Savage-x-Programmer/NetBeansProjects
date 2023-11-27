package BigO;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author angelfigeralperezestevez
 */
public class MaximunConsecutiveIncreasinglyOrderedString {
    
    
    public static String  maximumConsecutivelyIncreasingString(String s)
    {
        
        String subStringMax = "";
        String temp= "";
       
        for(int i = 0; i < s.length() - 1; ++i){
            temp += s.charAt(i);
            for(int j = i; j < s.length() - 1; ++j)
                if(s.charAt(j) < s.charAt(j + 1))
                    temp += s.charAt(j + 1);
                else
                    break;
            
            
            if(temp.length() > subStringMax.length())
                subStringMax = temp;
            temp = "";
        }
        return subStringMax;
    }
    
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter a String");
       
        String s = scan.next();
        
        System.out.println(maximumConsecutivelyIncreasingString(s));
        
        
    }
}
