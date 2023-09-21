/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildCards;

/**
 *
 * @author angelfigeralperezestevez
 */
public class wildCardWithSuper {
    public static <T> void add(rawTypes.GenericStack<T> stack1, rawTypes.GenericStack<? super T> stack2){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
    
    public static void main(String[] args) {
        rawTypes.GenericStack<String> stack = new rawTypes.GenericStack<String>();
        rawTypes.GenericStack<Object> stack2 = new rawTypes.GenericStack<Object>();
        
        stack2.push("one");
        stack2.push(2);
        stack.push("one");
        
        add(stack, stack2 );
        wildLCard2.print(stack2);
        
    }
}
