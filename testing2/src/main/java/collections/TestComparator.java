/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
  public static void main(String[] args) {
    GeometricObject g1 = new Rectangle(5, 5);
    GeometricObject g2 = new Circle(5);

    List<GeometricObject> list = new ArrayList<GeometricObject>();
    list.add(g2);
    list.add(g1);

      System.out.println("the mininmun is "  + Collections.min(list, new GeometricObjectComparator()));
      
    GeometricObject g = 
      max(g1, g2, new GeometricObjectComparator());
    
    GeometricObject g3 = 
      max(g1, g2, (GeometricObject o1, GeometricObject o2) -> {
          if( o1.equals(o2))
              return 0;
          return o1.getArea() > o2.getArea() ? 1 : -1;
    });
    
    System.out.println("The area of the larger object is " + 
      g.getArea());
      System.out.println("The largest object is " + g3.getArea());
  }
  
  public static GeometricObject max(GeometricObject g1, 
      GeometricObject g2, Comparator<GeometricObject> c) {
  	return c.compare(g1, g2) > 0 ? g1 : g2;
  }
}
