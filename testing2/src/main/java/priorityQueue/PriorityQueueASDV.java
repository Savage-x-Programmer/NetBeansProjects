/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priorityQueue;

/**
 *
 * @author angelfigeralperezestevez
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Consumer;

public class PriorityQueueASDV<E extends Comparable<E>>
        implements Queue<E>, Cloneable
{

    private Node<E> head;//head
    private Node<E> tail;//tail

    class Node<E>
    {

        E e;
        Node<E> l;
        Node<E> r;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning true upon
     * success and throwing an IllegalStateException if no space is currently
     * available.
     *
     * Specified by: add in interface Collection<E>
     * Parameters: e - the element to add Returns: true (as specified by
     * Collection.add(E)) Throws: IllegalStateException - if the element cannot
     * be added at this time due to capacity restrictions ClassCastException -
     * if the class of the specified element prevents it from being added to
     * this queue NullPointerException - if the specified element is null and
     * this queue does not permit null elements IllegalArgumentException - if
     * some property of this element prevents it from being added to this queue
     *
     * @param e - the element to add
     * @return true if this collection changed as a result of the call
     * @throws IllegalStateException - if the element cannot be added at this
     * time due to capacity restrictions
     * @throws ClassCastException - if the class of the specified element
     * @throws NullPointerException - if the specified element is null and this
     * queue does not permit null elements
     * @throws IllegalArgumentException - if some property of this element
     * prevents it from being added to this queue
     */
    @Override
    public boolean add(E e)
    {
        if (e == null)
        {
            throw new NullPointerException("NULL elements not allowed!");
        }

        Node<E> newNode = new Node<E>();
        newNode.e = e;

        //1. empty queue
        if (this.head == null && this.tail == null)
        {
            this.head = this.tail = newNode;
            return true;
        }

        int index = findCorrectPositionToInsertElement(e);
        //int index = findCorrectPositionToInsertElementHashCode(e);

        //2. we add at size ( last node)
        if (index == size())
        {
            tail.r = newNode;//1
            newNode.l = tail;//2
            tail = newNode;//3
        }
        //3. we add at 0 in the front
        else if (index == 0)
        {
            newNode.r = head;
            this.head.l = newNode;
            this.head = newNode;
            if (size() == 1)
            {
                tail = head;
            }
        }
        //4. we add in the middle
        else
        {
            Node<E> p = head;

            for (int i = 0; i < index - 1; ++i)
            {
                p = p.r;
            }

            //after for loop p point one position before insertion
            newNode.l = p;//we connect the left of the new node
            //to the node that is BEFORE
            //the node to be inserted

            newNode.r = p.r;//we connect the right of the new node
            // to the node thta is AFTER
            //the node to be inserted

            p.r = newNode; //we connect the right the  node BEFORE the node
            //to be inserted to the new node

            p.r.r.l = newNode;//we connect the left of the node AFTER the node
            //to be iserted to the new node
        }

        return true;
    }

    
    
    
    
     /**
     *returns the size of the collection
     * returns 0 if empty
     */
    @Override
    public int size()
    {
        Node<E> p = this.head;
        int count = 0;
        while (p != null)
        {
            p = p.r;
            count++;
        }
        return count;
    }
    /**
     *finds the correct position to insert the element 
     * positions everything alphabetically
     * @param e the element to be inserted
     */
    private int findCorrectPositionToInsertElement(E e)
    {
        Node<E> p = this.head;
        int pos = 0;
        while (p != null)
        {
            if (e.compareTo(p.e) > 0)
            {
                p = p.r;
                ++pos;
            }
            else
            {
                break;
            }
        }

        return pos;
    }
    /**
     *finds the correct position to insert the element HashCode 
     * @param e the element which HashCode is pulled
     */
    private int findCorrectPositionToInsertElementHashCode(E e)
    {
        Node<E> p = this.head;
        int pos = 0;
        while (p != null)
        {
            if (e.hashCode() > p.e.hashCode())
            {
                p = p.r;
                ++pos;
            }
            else
            {
                break;
            }
        }

        return pos;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions. When using a
     * capacity-restricted queue, this method is generally preferable to add(E),
     * which can fail to insert an element only by throwing an exception.
     *
     * @param e - the element to add
     * @throws IllegalStateException - if the element cannot be added at this
     * time due to capacity restrictions
     * @throws ClassCastException - if the class of the specified element
     * @throws NullPointerException - if the specified element is null and this
     * queue does not permit null elements
     * @throws IllegalArgumentException - if some property of this element
     * prevents it from being added to this queue
     * @return true if the element was added
     */
    @Override
    public boolean offer(E e)
    {
        return add(e);
    }
    
    /**
     *removes head from Queue
     * if size is one removes tail
     * @throws NoSuhcElementException if the queue is empty
     */
    @Override
    public E remove()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException("the queue is empty");
        }
        if (size() > 1)
        {
            head = head.r;

            E e = head.l.e;
            head.l = null;
            return e;
        }
        else //size 1
        {
            E e = head.e;
            head = tail = null;
            return e;
        }
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     *
     * Returns: the head of this queue, or null if this queue is empty
     *
     * @return
     */
    @Override
    public E poll()
    {
        if (size() == 0)
        {
            return null;
        }
        if (size() > 1)
        {
            head = head.r;

            E e = head.l.e;
            head.l = null;
            return e;
        }
        else //size 1
        {
            E e = head.e;
            head = tail = null;
            return e;
        }
    }

    /**
     *returns top element in the queue
     *@throws NoSuchElementException if queue is empty
     */
    @Override
    public E element()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException("the queue is empty");
        }
        return head.e;
    }

    /**
     *returns top element in queue
     */
    @Override
    public E peek()
    {
        if (size() == 0)
        {
            return null;
        }
        return head.e;
    }

    /**
     * 
     * @return returns true if queue is empty 
     * false if is not
     */
    @Override
    public boolean isEmpty()
    {
        return head == null && tail == null ? true : false;

    }
    
    /**
     * 
     * @param o object to check for
     * @return true if queue contains the specified object
     */
    @Override
    public boolean contains(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException("null vales not allowed");
        }
        if (size() == 0)
        {
            return false;
        }

        Node<E> p = this.head;
        while (p != this.tail)
        {
            if (p.e.equals(o))
            {
                return true;
            }
            p = p.r;
        }
        if (p == tail && p.e.equals(o))
        {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @return a creates and returns an iterator for the queue
     */
    @Override
    public Iterator<E> iterator()
    {
        Iterator<E> it = new Iterator<E>()
        {
            Node<E> p = head;

            @Override
            public boolean hasNext()
            {
                return p == null ? false : true;
            }

            @Override
            public E next()
            {
                if (hasNext() == false)
                {
                    throw new NoSuchElementException("the is no next element");
                }
                E e = p.e;
                p = p.r;
                return e;
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action)
            {
                while (hasNext())
                {
                    action.accept(p.e);
                    p = p.r;
                }
            }
        };

        return it;

    }

    /**
     * converts elements in the queue to an array
     * @return the array
     */
    @Override
    public Object[] toArray()
    {
        Object[] arr = new Object[size()];
        Node<E> p = head;
        int i = 0;
        while (p != null)
        {
            arr[i++] = p.e;
            p = p.r;
        }
        return arr;
    }

    /**
     * converts elements in the queue to an array
     * @return the array
     */
    @Override
    public <T> T[] toArray(T[] a)
    {
        if (a.length < size())
        {
            a = ( T[] ) new Object[size()];
        }
        Node<E> p = head;
        int i = 0;
        while (p != null)
        {
            a[i++] = ( T ) p.e;
            p = p.r;
        }
        return a;
    }

    /**
     * Removes a single instance of the specified element from this collection,
     * if it is present (optional operation). More formally, removes an element
     * e such that (o==null ? e==null : o.equals(e)), if this collection
     * contains one or more such elements. Returns true if this collection
     * contained the specified element (or equivalently, if this collection
     * changed as a result of the call).
     *
     * @param o - element to be removed from this collection, if present
     * @throws ClassCastException - if the type of the specified element is
     * incompatible with this collection
     * @throws NullPointerException - if the specified element is null and this
     * collection does not permit null elements
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException("null vales not allowed");
        }
        if (size() == 0)
        {
            return false;
        }

        Node<E> p = this.head;
        int pos = 0;
        while (p != this.tail)
        {
            if (p.e.equals(o))
            {
                if (size() == 1)
                {
                    this.head = this.tail = null;
                    return true;
                }
                this.removeAt(pos, (E) o);
                break;
            }
            ++pos;
            p = p.r;
        }
        if (p == tail && p.e.equals(o))
        {
            this.removeAt(size() - 1, (E) o);
        }
        return true;
    }

    /**
     *
     * @param pos
     * @param e
     * @throws IndexOutOfBoundsException - if pos less 0 OR pos greater-equal
     * size()
     * @return
     */
    private boolean removeAt(int pos, E e)
    {
        if (pos < 0 || pos >= size())
        {
            throw new IndexOutOfBoundsException(pos + " is out of bounds");
        }
        //1.list is empty
        if (isEmpty())
        {
            return false;
        }
        //2. one node exists
        else if (size() == 1)
        {
            this.head = this.tail = null;
        }
        //3. remove in the front( head)
        else if (pos == 0)
        {
            this.head = this.head.r;
            head.l = null;
        }
        //4. remove in the end ( tail)
        else if (pos == size() - 1)
        {
            this.tail = this.tail.l;
            this.tail.r = null;
        }

        //5. remove in the middle ( at least 3 nodes are in the queue)
        else
        {
            Node<E> p = head;
            for (int i = 0; i < pos - 1; ++i)
            {
                p = p.r;
            }
            p.r = p.r.r;
            p.r.l = p;
        }
        return true;
    }
    
    /**
     * checks to see if the queue contains all the elements in the specified collection
     * @param c the collection to be checked 
     * @return true if it contains all the elements / false if it does not
     */
    @Override
    public boolean containsAll(Collection<?> c)
    {
        if (c == null)
        {
            throw new NullPointerException("null vales not allowed");
        }
        if (size() == 0)
        {
            return false;
        }

        for (Object o : c)
        {
            if (!contains(o))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation). The behavior of this operation is undefined if the
     * specified collection is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified collection is this collection, and this collection is
     * nonempty.)
     *
     * @param c - collection containing elements to be added to this collection
     * @throws ClassCastException - if the class of an element of the specified
     * collection prevents it from being added to this collection.
     * @throws NullPointerException - if the specified collection contains a
     * null element and this collection does not permit null elements, or if the
     * specified collection is null
     * @throws IllegalArgumentException - if some property of an element of the
     * specified collection prevents it from being added to this collection
     * @throws IllegalArgumentException - if some property of an element of the
     * specified collection prevents it from being added to this collection
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        int sizeBefore = size();
        for (E e : c)
        {
            add(e);
        }
        int sizeAfter = size();
        return sizeAfter > sizeBefore;
    }

    /**
     * removes all elements from the specified collection 
     * @param c
     * @return true when done
     * @throws  NullPointerException
     */
    @Override
    public boolean removeAll(Collection<?> c)
    {
        if (c == null)
        {
            throw new NullPointerException("null vales not allowed");
        }
        if (size() == 0)
        {
            return false;
        }

        for (Object o : c)
        {
            if (contains(o))
            {
                remove(o);
            }
        }
        return true;
    }

    /**
     * retains all the elements that are in the specified collection
     * @param c the collection
     * @return 
     */
    @Override
    public boolean retainAll(Collection<?> c)
    {
        if (c == null)
        {
            throw new NullPointerException("null vales not allowed");
        }
        if (size() == 0)
        {
            return false;
        }

        for (Object o : c)
        {
            if (!contains(o))
            {
                remove(o);
            }
        }
        return true;
    }
    /**
     * clears all the elements of the queue
     */
    @Override
    public void clear()
    {
        // head = tail = null;

        //extra, no necessary to set the link of every node
        Node<E> p = head ;
        while ( p != tail )
        {
            p = p.r;
            p.l = null;
        }
        head = tail = null;
    }

    @Override
    public void forEach(Consumer<? super E> action)
    {
        //1. use a pointer that points to the head
        //2. while the pointer has not reached the end of the queue
        //consume it
        Node<E> p = head;
        while ( p != null)
        {
            action.accept(p.e);
            p = p.r;
        }

    }
    /**
     * 
     * @return a string with all the elements of the queue
     */
    @Override
    public String toString()
    {
        String s = "PriorityQueueASDV {";
        Node<E> p = head;
        while (p != null)
        {
            s += p.e.toString();
            if (p != tail)
            {
                s += ", ";
            }
            p = p.r;
        }

        s += "}";
        return s;
    }

    /**
     * makes a copy of the of the collection 
     * @return the copy of the collection
     * @throws CloneNotSupportedException 
     */
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        PriorityQueueASDV<E> c = ( PriorityQueueASDV<E> ) super.clone();
        return c;
    }

    public static void main(String[] args)
    {
        System.out.println("\n--> PriorityQueueASDV  testing add");
        PriorityQueueASDV<String> pq1 = new PriorityQueueASDV();
        pq1.add("Paris");
        pq1.add("Athens");
        pq1.add("London");
        pq1.add("Lafayette");
        pq1.add("Berlin");

        System.out.println(pq1);

        System.out.println("\n--> Colllections PriorityQueue testing add");

        PriorityQueue<String> pq2 = new PriorityQueue();
        pq2.add("Paris");
        pq2.add("Athens");
        pq2.add("London");
        pq2.add("Lafayette");
        pq2.add("Berlin");

        System.out.println(pq2);

        //TEST IT FULLY HERE. FOR ALL METHODS AND ALL CASES.
        //Have the Jzva PriorityQueue below
        System.out.println("\n--> PriorityQueueASDV  testing remove(object o)");
        System.out.println("\n\tremove from front Athens");
        pq1.remove("Athens");
        pq2.remove("Athens");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from end Paris");
        pq1.remove("Paris");
        pq2.remove("Paris");
        System.out.println(pq1);
        System.out.println(pq1);

        System.out.println("\n\tremove from the middle Lafayette");
        pq1.remove("Lafayette");
        pq2.remove("Lafayette");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tadd at the end Stocholm");
        pq1.add("Stockholm");
        pq2.add("Stockholm");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from the middle London");
        pq1.remove("London");
        pq2.remove("London");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from the front Berlin");
        pq1.remove("Berlin");
        pq2.remove("Berlin");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from the front/end Stocholm");
        pq1.remove("Stockholm");
        pq2.remove("Stockholm");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from empty queue");
        pq1.remove("Stockholm");
        pq2.remove("Stockholm");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n--> PriorityQueueASDV  recreate priority queues from empty");
        pq1.add("Paris");
        pq1.add("Athens");
        pq1.add("London");
        pq1.add("Lafayette");
        pq1.add("Berlin");
        pq1.add("Zurich");

        pq2.add("Paris");
        pq2.add("Athens");
        pq2.add("London");
        pq2.add("Lafayette");
        pq2.add("Berlin");
        pq2.add("Zurich");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\n+++HERE YOU TEST ALL YOUR METHODS FULLY, and the methods of Colleciion PriorityQueue");

        System.out.println("\n\t  offer New York");
        pq1.offer("New York");
        pq2.offer("New York");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  offer Miami");
        pq1.offer("Miami");
        pq2.offer("Miami");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  offer null");
        try
        {
            pq1.offer(null);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }

        try
        {
            pq2.offer(null);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  offer ClassCastException with Object");
        try
        {
            pq1.offer((String)  new Object());
        }
        catch (Exception e)
        {
            System.err.println(e);
        }

        try
        {
            pq2.offer((String) new Object());
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  poll suposed to be Athens");
        System.out.println(pq1.poll());
        System.out.println(pq2.poll());
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  Iterator");
        Iterator<String> it1 = pq1.iterator();
        Iterator<String> it2 = pq2.iterator();

        while (it1.hasNext())
        {
            System.out.print(it1.next() + " ");
        }

        System.out.println("");

        while (it2.hasNext())
        {
            System.out.print(it2.next() + " ");
        }
        System.out.println("");

        System.out.println("\n\t  Iterator NoSuchElementException ");

        try
        {
            System.out.println(it1.next());
        }
        catch (NoSuchElementException e)
        {
            System.err.println(e);
        }
        try
        {
            System.out.println(it2.next());
        }
        catch (NoSuchElementException e)
        {
            System.err.println(e);
        }

        System.out.println("\n\t  Iterator foreach ");
        it1 = pq1.iterator();
        it2 = pq2.iterator();
        it1.forEachRemaining(new Consumer()
        {
            @Override
            public void accept(Object t)
            {
                System.out.print(t + "***  ");
            }
        });
        System.out.println("");
        it2.forEachRemaining(new Consumer()
        {
            @Override
            public void accept(Object t)
            {
                System.out.print(t + "+++  ");
            }
        });
        System.out.println("");

        System.out.println("\n\t  addAll  Houston Chicago");
        List<String> ar1 = Arrays.asList("Houston", "Chicago");
        pq1.addAll(ar1);
        pq2.addAll(ar1);
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  clear" );
        pq1.clear();
        pq2.clear();
        System.out.println(pq1);
        System.out.println(pq2);
        System.out.println("");

        System.out.println("\n--> PriorityQueueASDV  recreate priority queues from empty");
        pq1.add("Paris");
        pq1.add("Athens");
        pq1.add("London");
        pq1.add("Lafayette");
        pq1.add("Berlin");
        pq1.add("Zurich");

        pq2.add("Paris");
        pq2.add("Athens");
        pq2.add("London");
        pq2.add("Lafayette");
        pq2.add("Berlin");
        pq2.add("Zurich");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  forEach");
        pq1.forEach(new Consumer(){
            @Override
            public void accept(Object t)
            {
                System.out.print( t + "*** ");
            }
        });
        System.out.println("");
        pq2.forEach(new Consumer(){
            @Override
            public void accept(Object t)
            {
                System.out.print( t + "+++ ");
            }
        });
        System.out.println("");

        System.out.println("\n\t  clone");
        try{PriorityQueueASDV<String> pq1Cloned =
                ( PriorityQueueASDV<String>) pq1.clone();
            System.out.println(pq1Cloned);
            pq1Cloned.add("Las Vegas");
            System.out.println(pq1Cloned);
            System.out.println(pq1);

        }
        catch(CloneNotSupportedException e ){System.err.println(e);}


    }
}
