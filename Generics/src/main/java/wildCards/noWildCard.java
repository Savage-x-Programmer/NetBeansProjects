/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildCards;

/**
 *
 * @author angelfigeralperezestevez
 */
public class noWildCard {
    public static double max(rawTypes.GenericStack<Number> stack ){
        double max = -888;
        
        while(!stack.isEmpty()){
            double value = stack.pop().doubleValue();
            if(value > max){
                max = value;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        rawTypes.GenericStack<Integer> intStack = new rawTypes.GenericStack<Integer>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);
        //System.out.println("The max number is " + max(intStack));
    }

}
    


    

