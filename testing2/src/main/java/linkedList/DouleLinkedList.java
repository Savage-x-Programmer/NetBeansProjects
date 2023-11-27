/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

/**
 *
 * @author angelfigeralperezestevez
 */
public class DouleLinkedList<T>
{
    Node<T> head;
    Node<T> tail;

    class Node<T>
    {
        T t;
        Node<T> l;
        Node<T> r;
    }

    public T removeAt(int pos) throws Exception
    {
        if (pos < 0 || pos > size()-1)
        {
            throw new IndexOutOfBoundsException();
        }
        
        //list is empty
        if ( size() == 0 )
            throw new Exception( "The list empty.");
        T returnT;
        
        if ( pos == 0)//remove at 0
        {
            returnT = head.t;
            if ( size() == 1)
              head = tail = null;  
            else
              head = head.r;         
        }        
        else if ( pos == size() -1 )//remove at end
        {
            returnT = tail.t;
           tail = tail.l; 
           tail.r = null;
        }       
        else//remove in the middle
        {
            Node<T> p = head;           
            for ( int i=0; i < pos ; ++i)
                p = p.r;         
            returnT = p.t;      
            p.l.r = p.r;
            p.r.l = p.l;
        }
        
        return returnT;
    }
    public void clear()
    {
        head = tail = null;
    }
    public void addAt(T t, int pos)
    {
        if (pos < 0 || pos > size())
            throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<T>();
        newNode.t = t;
        if (head == null)//list is empty
            head = tail = newNode;
        else if (pos == 0)//add at the front
        {
            newNode.r = head;
            head.l = newNode;
            head = newNode;
        }
        else if (pos == size())//add at the end
        {
            newNode.l = tail;
            tail.r = newNode;
            tail = newNode;
        }
        else//middle
        {
            Node<T> p = head;
            for (int i = 0; i < pos - 1; ++i)
                p = p.r;
            newNode.l = p;
            newNode.r = p.r;
            p.r.l = newNode;
            p.r = newNode;
        }
    }

    public int size()
    {
        Node<T> p = head;
        int count = 0;
        while (p != null)
        {
            count++;
            p = p.r;
        }
        return count;
    }

    @Override
    public String toString()
    {
        String s = "";
        Node<T> p = head;
        while (p != null)
        {
            s += p.t.toString() + " ";
            p = p.r;
        }
        return s;
    }

    public static void main(String[] args) throws Exception
    {
        DouleLinkedList<Integer> list = new DouleLinkedList<Integer>();
        list.addAt(10, 0);
        list.removeAt(0);
        System.out.println(list);
        list.addAt(100, 0);
        System.out.println(list);
        
        list.addAt(20, 0);
        list.addAt(30, 0);
        list.addAt(40, 3);
        list.addAt(25, 2);
        System.out.println(list);
        System.out.println( list.removeAt(0));
        System.out.println(list);
        System.out.println( list.removeAt(3));
        System.out.println(list);
        
        System.out.println(  list.removeAt(1));
        System.out.println(list);
    }
    
}
