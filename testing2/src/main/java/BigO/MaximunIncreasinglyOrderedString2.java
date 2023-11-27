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
public class MaximunIncreasinglyOrderedString2 {
    
    
    public static String  maximumIncreasingString(String s)
    {
        
        String subStringMax = "";
        String temp= "";
       
        for(int j = 0; j < s.length(); ++j){
            temp += s.charAt(j);
            for(int i = j; i < s.length(); ++i){
                //temp += s.charAt(i);
//                if(temp.length() == 0){
//                   temp += s.charAt(i);
//                }
                
                  if(temp.charAt(temp.length() - 1) < s.charAt(i)){
                    temp += s.charAt(i);
                    }
                }
                
            if(temp.length() > subStringMax.length()){
                    subStringMax = temp;
                    
                }
            temp = "";
        }
        return subStringMax;
    }
    
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter a String");
       
        //String s = scan.next();
        String s = "Welcome";
        System.out.println(maximumIncreasingString(s));
        
        
    }
}
