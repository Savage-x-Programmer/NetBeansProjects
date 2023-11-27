/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

/**
 *
 * @author angelfigeralperezestevez
 */
import java.util.Comparator;

public class GenericSelectionSort
{

    public static <E extends Comparable<E>> void selectionSort(E[] list)
    {
        for (int i = 0; i < list.length - 1; i++)
          {

            for (int j = i + 1; j < list.length; j++)
              {
                if (list[i].compareTo(list[j]) > 0)
                  {
                    E temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                  }
              }
          }
    }

    public static <E> void selectionSort(E[] list,
            Comparator<? super E> comparator)
    {

        for (int i = 0; i < list.length - 1; i++)
          {

            for (int j = i + 1; j < list.length; j++)
              {
                if (comparator.compare(list[i], list[j]) > 0)
                  {
                    E temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                  }
              }
          }
    }

    public static void main(String[] a)
    {
        Integer[] list =
          {
            2, 3, 2, 5, 6, 1, -2, 3, 14, 12
          };
        selectionSort(list);

        for (int i = 0; i < list.length; i++)
          {
            System.out.print(list[i] + " ");
          }
        
 
        System.out.println();
        Circle[] list1 =
          {
            new Circle(6), new Circle(3), new Circle(2),
            new Circle(5), new Circle(6), new Circle(1), new Circle(2),
            new Circle(3), new Circle(1), new Circle(12)
          };

        selectionSort(list1, new GeometricObjectComparator());
        for (int i = 0; i < list1.length; i++)
          {
            System.out.println(list1[i] + " ");
          }
        
        
        Circle[] list2 =
          {
            new Circle(689), new Circle(3), new Circle(25),
   
          };        
        selectionSort( list2);
        System.out.println("------------");
        for ( GeometricObject o: list2)
            System.out.println(o);
        
    }
}

class GeometricObjectComparator
        implements Comparator<GeometricObject>
{

    public int compare(GeometricObject o1, GeometricObject o2)
    {
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        if (area1 < area2)
          {
            return -1;
          }
        else if (area1 == area2)
          {
            return 0;
          }
        else
          {
            return 1;
          }
    }
}

abstract class GeometricObject implements Comparable<GeometricObject>
{

    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    protected GeometricObject()
    {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with color and filled value
     */
    protected GeometricObject(String color, boolean filled)
    {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean isFilled()
    {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated()
    {
        return dateCreated;
    }

    @Override
    public String toString()
    {
        return "created on " + dateCreated + "\ncolor: " + color
                + " and filled: " + filled;
    }

    /**
     * Abstract method getArea
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter
     */
    public abstract double getPerimeter();
}

class Circle extends GeometricObject
{

    private double radius;

    public Circle()
    {
    }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    /**
     * Return radius
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * Set a new radius
     */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    @Override
    /**
     * Return area
     */
    public double getArea()
    {
        return radius * radius * Math.PI;
    }

    /**
     * Return diameter
     */
    public double getDiameter()
    {
        return 2 * radius;
    }

    @Override
    /**
     * Return perimeter
     */
    public double getPerimeter()
    {
        return 2 * radius * Math.PI;
    }

    /* Print the circle info */
    public String toString()
    {
        return "The circle is created " + getDateCreated()
                + " and the radius is " + radius;
    

  }

    @Override
    public int compareTo(GeometricObject o)
    {
      if ( this.getArea() - o.getArea() == 0) 
          return 0;
      else   if ( this.getArea() - o.getArea() > 0) 
          return 1;
      else
          return -1;
          
    }
}
