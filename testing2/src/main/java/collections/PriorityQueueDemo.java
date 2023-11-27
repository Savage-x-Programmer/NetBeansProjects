/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections;

 
import java.util.*;

public class PriorityQueueDemo {
  public static void main(String[] args) {
    PriorityQueue<x> queuex = new PriorityQueue<>(3, (x o1, x o2) -> o1.x - o2.x);
    queuex.offer(new x(10));
    queuex.offer(new x(20));
    queuex.offer(new x(15));
    
System.out.println("Priority queue using Comparable:");
    while (!queuex.isEmpty()) {
      System.out.print(queuex.remove() + " ");
    }    
    
      System.out.println("\n");
      
      
    PriorityQueue<String> queue1 = new PriorityQueue<>();
    queue1.offer("Oklahoma");
    queue1.offer("Indiana");
    queue1.offer("Georgia");
    queue1.offer("Texas");

    System.out.println("Priority queue using Comparable:");
    while (!queue1.isEmpty()) {
      System.out.print(queue1.remove() + " ");
    }
    

    PriorityQueue<String> queue2 = new PriorityQueue<>(
      4, Collections.reverseOrder());
    queue2.offer("Oklahoma");
    queue2.offer("Indiana");
    queue2.offer("Georgia");
    queue2.offer("Texas");

    System.out.println("\nPriority queue using Comparator:");
    while (queue2.size() > 0) {
      System.out.print(queue2.remove() + " ");
    }
  }
}

class x{
    int x;

    public x(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "x{" + "x=" + x + '}';
    }
    
    
}