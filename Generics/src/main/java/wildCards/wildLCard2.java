/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildCards;

/**
 *
 * @author angelfigeralperezestevez
 */
public class wildLCard2 {
    public static void print(rawTypes.GenericStack<?> stack)
    {
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop() + " ");
        }
    }
    
    public static void main(String[] args) {
        rawTypes.GenericStack<Integer> intStack = new rawTypes.GenericStack<Integer>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);
        
        print(intStack);
        
    }
}
