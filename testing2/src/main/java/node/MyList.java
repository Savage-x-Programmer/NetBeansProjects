/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package node;

/**
 *
 * @author angelfigeralperezestevez
 */
public class MyList<E> 
{
    private Node<E> head;
    class Node<E>
    {
        E e; // data that can be anything
        Node<E> link; // address of another node
    }

    @Override
    public String toString() 
    {
        String s = "";
        Node<E> p = head;
            while (p != null)
            {
                s += p.e.toString() + " ";
                p = p.link;
            }
        return "MyList{" + s + "\b}";
    }
    
    
    
    public boolean add(E e)
    {
        Node<E> newNode = new Node<E>(); // Create a new node
        newNode.e = e; // assign its e value to the e value coming in.
        
        if (head == null) // empty
        {
            head = newNode;
        }
        else
        {
            Node<E> p = head;
            Node<E> pTrail = head;
            while (p != null)
            {
                pTrail = p;
                p = p.link;
            }
            pTrail.link = newNode;
        }
        return true;
    }
    public boolean add(int index, E e)
    {
        Node<E> newNode = new Node<E>(); // Create a new node
        newNode.e = e; // assign its e value to the e value coming in.
        if (index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0 && size() == 0) // case 'the list is empty'
        {
            head = newNode;
        }
        // case 2 'insert in the front, that is index is 0'
        else if (index == 0 && size() > 0)
        {
            //1. connect the new node with the first node
            newNode.link = head;
            //2. make the head point to the newNode
            head = newNode;
        }
        // case 3 'insert in the middle'
        else if (index < size())
        {
            Node<E> p = head;
            for (int i = 0; i < index-1; ++i)
                p = p.link;
            // 1. connect the new node with the next node before p
            newNode.link = p.link;
            // 2. connect the node pointed by p with the newNode.
            p.link = newNode;
        }
        // final case, insert at the end
        else
        {
            add(e);
        }
        return true;
    }
    
    public int size()
    {
        Node<E> p = head;
        int count = 0;
            while (p != null)
            {
                ++count;
                p = p.link;
            }
        return count;
    }
    public E removeAt(int index){
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        
        if(size() == 0){
            throw new RuntimeException("Empty List");
        }
        
        E removedE = null;
        if(index == 0)//remove the front
        {
            removedE = head.e;
            Node<E> p = head;
            head = head.link;
            p.link = null;
        }
        else if(index > 0 && index < size())// remove  the middle
        {
            
            Node<E> p = head;
            for(int i = 0; i < index - 1; ++i)
                p = p.link;
            removedE = p.link.e;
            
            p.link = p.link.link;
            
        }
        else // remove at end
        {
            removedE = head.e;
            Node<E> p = head;
            for(int i = 0; i < index - 1; ++i)
                p = p.link;
            removedE = p.link.e;
            p.link = null;
        }
        return removedE;
    }
    
    public static void main(String[] args) 
    {
        MyList<Integer> ml = new MyList<Integer>();
        ml.add(10);
        ml.add(20);
        ml.add(30);
        ml.add(0, 5);
        ml.add(3, 25);
        ml.add(5, 40);
        System.out.println(ml);
        System.out.println(ml.size());
        
        ml.removeAt(0);
        System.out.println(ml);
        System.out.println(ml.size());
        
        ml.removeAt(4);
        System.out.println(ml);
        System.out.println(ml.size());
        
        

    }
}

