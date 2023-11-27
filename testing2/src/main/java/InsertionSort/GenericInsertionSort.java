/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InsertionSort;

public class GenericInsertionSort
{
     public static <E extends Comparable<E>> 
              void insertionSort(E[] list)
    {
        int i =  1;
        while (i < list.length)// executed  n-1 times
          {          
            E current = list[i]; //c1
            int j = i - 1;       //c2
            
              System.out.print( current + ",  ");
            //opens the hole by shifting elements to the right
            while (j >= 0 && current.compareTo( list[j] )  < 0) //n * n-1
              {  
                System.out.print(   i + " " + j + "    " ); //c *( n-1  * ( 1 + 2 + .... n-1)
                list[j + 1] = list[j];
                --j;           
              }
              System.out.println("\n-------------------");
            //Insert the current at the opened hole list[j+1]          
            list[j + 1] = current;//c3
            i++;//c5
          }
    }
           
    public static void main(String[] args)
    {
        Integer[] list =
          {
            9,8,7,6,5,4,3,2,1
          };
        insertionSort(list);
        //for ( Integer s : list)
         //   System.out.println( s);
    }
}
