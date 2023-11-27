/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package circularList;

/**
 *
 * @author angelfigeralperezestevez
 */
public class CircularList<T extends Comparable<T>>
{
    Node<T> head;

    public class Node< T extends Comparable<T>>
            implements Comparable<Node<T>>
    {
        private T t;

        public void set(T t)
        {
            this.t = t;
        }

        public T get()
        {
            return t;
        }
        Node<T> next;

        @Override
        public int compareTo(Node<T> o)
        {
            return this.t.compareTo(o.get());
        }
    }

    /**
     *
     * @param t
     */

    public void add(T t)
    {
        Node<T> temp = new Node();
        temp.set((T) t);
        if (head == null)
        {
            head = temp;
            head.next = head;
        }
        else
        {
            Node<T> temp2 = head;
            do
            {
                temp2 = temp2.next;
            }
            while (temp2.next != head);

            temp.next = head;
            temp2.next = temp;
        }
    }

    /**
     *
     * @return
     */
    private int getSize()
    {
        if (head == null)
        {
            return 0;
        }
        Node<T> temp = head;
        int count = 0;
        do
        {
            temp = temp.next;
            count++;
        }
        while (temp != head);
        return count;
    }
    ////////////////////////////////////////////////////////

    public void addAt(T t, int pos)
    {
        if (pos < 0 || pos > getSize())
        {
            return;
        }
        Node<T> temp = new Node();
        temp.set((T) t);
        if (head == null)
        {
            add(t);
        }
        else if (pos == 0)
        {
            temp.next = head;
            Node<T> temp2 = head;
            do
            {
                temp2 = temp2.next;
            }
            while (temp2.next != head);
            temp2.next = temp;
            head = temp;
        }
        else//middle or end of the list
        {
            Node<T> temp2 = head;
            for (int i = 0; i < pos - 1; i++)
            {
                temp2 = temp2.next;
            }
            temp.next = temp2.next;
            temp2.next = temp;
        }
    }
    //////////////////////////////////////////////////////////////
    // removes the last node
    public void remove()
    {
        if (head == null)
        {
            return;
        }
        Node<T> temp = head;
        do
        {
            temp = temp.next;
        }
        while (temp.next.next != head);
        temp.next = head;

    }
    //////////////////////////////////////////////////////////////
// removes the object t if it exists and returns true
    //false otherwise
    public boolean remove(Object t)
    {
        if (head == null)
        {
            return false;
        }
        Node<T> temp = head;
        do
        {
            if (temp.next.get().equals(t))
            {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        while (temp != head);
        return false;
    }
    //////////////////////////////////////////////////////////////
// remove at position
    public void removeAt(int pos)
    {
        if (pos < 0 || pos > getSize())
        {
            return;
        }
        if (head == null)
        {
            return;
        }
        if (pos == 0)
        {
            remove();
        }
        else
        {
            Node<T> temp = head;
            for (int i = 0; i < pos - 1; i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        
    }

    public void print()
    {
        if (head == null)
        {
            return;
        }
        Node<T> temp = head;
        do
        {
            System.out.println(temp.get().toString());
            temp = temp.next;
        }
        while (temp != head);
    }

    public static void main(String... ar)
    {
        CircularList<Integer> list = new CircularList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.print();
        System.out.println();
        System.out.println(list.getSize());
        System.out.println();
        list.addAt(50, 2);
        list.print();
        System.out.println();
        list.remove();
        list.print();
        System.out.println();
        list.removeAt(2);
        list.print();
        list.remove(20);
        list.print();
    }
}

