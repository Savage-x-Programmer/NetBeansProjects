/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rawTypes;


/**
 *
 * @author angelfigeralperezestevez
 */
public class Max {
    public static Comparable max(Comparable o1, Comparable o2){
        if(o1.compareTo(o2) > 0)
            return o1;
        else
            return o2;
        }
        public static <E extends Comparable<E>> E maxSafe(E e1, E e2){
            if(e1.compareTo(e2) > 0)
            return e1;
        else
            return e2;
        }
    
    public static void main(String[] args) {
        System.out.println(max(1,2));
        try{
            System.out.println(maxSafe(1, 2));
            System.out.println(maxSafe("abc", "abc"));
            System.out.println("");
            //System.out.println(maxSafe(1, "two"));
            
            rawTypes.GenericStack stackUnsafe = new rawTypes.GenericStack();
            rawTypes.GenericStack<Integer> stackSafe = new rawTypes.GenericStack();
            stackSafe.push( 1 ); stackSafe.push( 2 );
            System.out.println( stackSafe);
            stackUnsafe.push( 1 ); stackUnsafe.push("two");
            
            System.out.print("this line compiles but craschesthe rpogram " + max(1, "two"));
        
        }
        catch(ClassCastException e){
            System.err.println("Raw types are Unsafe" + e.getMessage());
        }
    }
    


}
    

