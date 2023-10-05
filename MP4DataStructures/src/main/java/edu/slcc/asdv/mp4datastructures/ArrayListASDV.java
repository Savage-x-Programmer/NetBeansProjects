/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.mp4datastructures;

/**
 *
 * @author angel
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 *
 * @author ASDV2
 */
public class ArrayListASDV<E>
        implements Serializable, Cloneable, List<E>
{

    private E[] list;
    private int index;//the index to add at ( length of array)

    //private Class<E> type;
    /**
     * Constructs an empty list with an initial capacity of three.
     *
     */
    public ArrayListASDV()
    {
        list = (E[]) new Object[3];
        index = 0;
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity - the initial capacity of the list
     * @throws IllegalArgumentException - if the specified initial capacity is
     * negative
     */
    public ArrayListASDV(int initialCapacity)
    {
        if (initialCapacity < 0)
          {
            throw new IllegalArgumentException("initialCapacity id negative: " + initialCapacity);
          }
        list = (E[]) new Object[initialCapacity];
        index = 0;

    }
    /**Double the size of the current list and copies to it the old list
     * 
     * @return the new array.
     */
  private E[]  doubleSizeOfList()
  {
     list = this.toArray( (E[] ) new Object[list.length+list.length]);
     return this.list;

  }
          
    /**
     * Constructs a list containing the elements of the specified collection, in
     * the order they are returned by the collection's iterator.
     *
     * @param c - the collection whose elements are to be placed into this
     * @throws NullPointerException - if the specified collection is null
     *
     *
     */
    public ArrayListASDV(Collection<? extends E> c)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        list.equals(c);
        index = 0;
    
    }

    /**
     * Returns true if this collection changed as a result of the call. false if
     * this collection does not permit duplicates and already contains the
     * specified element.
     *
     * @param e - element whose presence in this collection is to be ensured
     *
     * @return true if this collection changed as a result of the call
     * @throws ClassCastException - if the class of the specified element
     * prevents it from being added to this collection
     * @throws NullPointerException - if the specified element is null and this
     * collection does not permit null elements
     * @throws IllegalArgumentException - if some property of the element
     * prevents it from being added to this collection
     */
    @Override
    public boolean add(E e)
    {
        if ( e == null)
            throw new NullPointerException();
        
     list[index++] = e;
     if (index >= list.length  * 0.75)
         doubleSizeOfList();
     return true;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    @Override
    public int size()
    {
        return index;
    }

    @Override
    public String toString()
    {
        String s = "ArrayListASDV[";

        for (int i = 0; i < index; ++i)
          {
            s += list[i] + " ";
          }
        s += "]";

        return s;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     *
     */
    @Override
    public boolean isEmpty()
    {
        return this.index == 0;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o - element whose presence in this list is to be tested
     *
     * @return true if this list contains the specified element
     *
     */
    @Override
    public boolean contains(Object o)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i = 0; i < list.length; ++i){
            if(list[i] == o){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element). The returned array will be "safe"
     * in that no references to it are maintained by this list. (In other words,
     * this method must allocate a new array). The caller is thus free to modify
     * the returned array. This method acts as bridge between array-based and
     * collection-based APIs. Returns: an array containing all of the elements
     * in this list in proper sequence
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    @Override
    public Object[] toArray()
    {
        return Arrays.copyOf(list, index);
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present. If the list does not contain the element, it is unchanged.
     * More formally, removes the element with the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     * Returns true if this list contained the specified element (or
     * equivalently, if this list changed as a result of the call).
     *
     * @param o - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o
    )
    {
        for(int i = 0; i < list.length; ++i){
            if(list[i] == o){
                list[i] = null;
                return true;
            }
        }
        return false;

    }

    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns. Note: Traverse the array and set all of its elements
     * to null. Set its index to zero.
     */
    @Override
    public void clear()
    {
        for(int i = 0; i < list.length; ++i){
            list[i] = null;
        }
        index = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public E get(int index
    )
    {
       return list[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index - index of the element to replace
     * @param element - element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public E set(int index, E element
    )
    {
        return list[index] = element;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index - index at which the specified element is to be inserted
     * element
     * @param - element to be inserted
     * @throws NullPointerException - if the specified element is null and this
     * collection does not permit null elements
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public void add(int index, E element
    )
    {
       if (element == null)
          {
            throw new NullPointerException("element is null");
          }

        if (index < 0 || index > this.index)
          {
            throw new IndexOutOfBoundsException("index: " + index);
          }

        if (index == this.index)
          {
            this.add(element);
          }
        else
          {
            for (int i = this.index; i > index; --i)
              {
                list[i] = list[i - 1];
              }
            list[index] = element;
            ++this.index;
          }
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     *
     * @param index - the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public E remove(int index
    )
    {

        E temp = list[index];
        list[index] = null;
        return temp;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such
     * index. Parameters:
     *
     * @param o - element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o
    )
    {

        for(int i = 0; i < list.length; ++i){
            if(list[i] == o){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element. More formally,
     * returns the highest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such
     * index. Parameters:
     *
     * @param o - element to search for
     * @return the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o
    )
    {

        for(int i = list.length - 1; i >= 0; --i){
            if(list[i] == o){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex
     * are equal, the returned list is empty.) The returned list is backed by
     * this list, so non-structural changes in the returned list are reflected
     * in this list, and vice-versa. The returned list supports all of the
     * optional list operations. This method eliminates the need for explicit
     * range operations (of the sort that commonly exist for arrays). Any
     * operation that expects a list can be used as a range operation by passing
     * a subList view instead of a whole list. For example, the following idiom
     * removes a range of elements from a list: list.subList(from, to).clear();
     *
     * Similar idioms may be constructed for ArrayList.indexOf(Object) and
     * ArrayList.lastIndexOf(Object), and all of the algorithms in the
     * Collections class can be applied to a subList. The semantics of the list
     * returned by this method become undefined if the backing list (i.e., this
     * list) is structurally modified in any way other than via the returned
     * list. (Structural modifications are those that change the size of this
     * list, or otherwise perturb it in such a fashion that iterations in
     * progress may yield incorrect results.)
     *
     * @param fromIndex - low endpoint (inclusive) of the subList
     * @param toIndex - high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException - for an illegal endpoint index value
     * (fromIndex LE 0 || toIndex > size || fromIndex > toIndex)
     * @throws IllegalArgumentException - if the endpoint indices are out of
     * order (fromIndex > toIndex)
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex
    )
    {

        if (fromIndex < 0 || toIndex > index || fromIndex > toIndex)
          {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + " toIndex: " + toIndex);
          }

        ArrayListASDV<E> subList = new ArrayListASDV<>(toIndex - fromIndex);

        for (int i = fromIndex; i < toIndex; ++i)
          {
            subList.add(list[i]);
          }

        return subList;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array. If the list fits in the specified
     * array, it is returned therein. Otherwise, a new array is allocated with
     * the runtime type of the specified array and the size of this list. If the
     * list fits in the specified array with room to spare (i.e., the array has
     * more elements than the list), the element in the array immediately
     * following the end of the collection is set to null. (This is useful in
     * determining the length of the list only if the caller knows that the list
     * does not contain any null elements.)
     *
     * @param a - the array into which the elements of the list are to be
     * stored, if it is big enough; otherwise, a new array of the same runtime
     * type is allocated for this purpose.
     * @return an array containing the elements of the list
     * @throws ArrayStoreException - if the runtime type of the specified array
     * is not a supertype of the runtime type of every element in this list
     * @throws NullPointerException - if the specified array is null
     */
    @Override
    public <T> T[] toArray(T[] a)
    {
        Class<?> clazz = a.getClass();
        //>length of a is too small
        if (a.length < index)
          // Make a new array of a's runtime type
          {
            return (T[]) Arrays.copyOf(this.list,
                    index,
                    a.getClass());
          }

        //>length of a is good
        System.arraycopy(this.list, 0, a, 0, index);

        //>length of a is greater than this list set nulls
        if (a.length > index)
          {
            for (int i = index; i < a.length; ++i)
              {
                a[i] = null;
              }
          }
        return a;

    }

    @Override
    public Iterator<E> iterator()
    {

        Iterator<E> it = new Iterator<E>()
        {
            int current = 0;

            /**
             * Returns true if the iteration has more elements. (In other words,
             * returns true if next() would return an element rather than
             * throwing an exception.)
             *
             * @return true if the iteration has more elements
             */
            @Override
            public boolean hasNext()
            {
                return current < index;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException - if the iteration has no more
             * elements
             */
            @Override
            public E next()
            {
                if (current >= index)
                  {
                    throw new NoSuchElementException("No more elements");
                  }
                return list[current++];
            }
        };

        return it;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence). The returned list iterator is fail-fast.
     *
     *
     * @return a list iterator over the elements in this list (in proper
     * sequence
     */
    @Override
    public ListIterator<E> listIterator()
    {
        return listIterator(0);

    }

    @Override
    public ListIterator<E> listIterator(int index)
    {

        ListIterator<E> it = new ListIterator<E>()
        {

            int current = index;

            /**
             * Returns true if this list iterator has more elements when
             * traversing the list in the forward direction. (In other words,
             * returns true if ListIterator.next would return an element rather
             * than throwing an exception.)
             *
             * @return true if the list iterator has more elements when
             * traversing the list in the forward direction
             */
            @Override
            public boolean hasNext() {

                return current < index;
            }

            /**
             * Returns the next element in the list and advances the cursor
             * position. This method may be called repeatedly to iterate through
             * the list, or intermixed with calls to ListIterator.previous to go
             * back and forth. (Note that alternating calls to next and previous
             * will return the same element repeatedly.)
             *
             * @return the next element in the list
             * @throws NoSuchElementException - if the iteration has no next
             * element
             */
            @Override
            public E next()
            {

                if (current >= index)
                  {
                    throw new NoSuchElementException("No more elements");
                  }
                return list[current++];
            }

            @Override
            public boolean hasPrevious()
            {

                return current > 0;
            }

            @Override
            public E previous()
            {

                if (current <= 0)
                  {
                    throw new NoSuchElementException("No more elements");
                  }
                return list[current--];
            }

            /**
             * Returns the index of the element that would be returned by a
             * subsequent call to next(). (Returns list size if the list
             * iterator is at the end of the list.)
             *
             * @return the index of the element that would be returned by a
             * subsequent call to next, or list size if the list iterator is at
             * the end of the list
             */
            @Override
            public int nextIndex()
            {


                return current + 1;
            }

            /**
             * Returns the index of the element that would be returned by a
             * subsequent call to previous(). (Returns -1 if the list iterator
             * is at the beginning of the list.)
             *
             * @return the index of the element that would be returned by a
             * subsequent call to previous, or -1 if the list iterator is at the
             * beginning of the list
             */
            @Override
            public int previousIndex()
            {

                return current - 1;
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action)
            {


                ListIterator.super.forEachRemaining(action);

            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e)
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e)
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        return it;

    }

    /**
     *
     * Returns true if this collection contains all of the elements in the
     * specified collection.
     *
     * Parameters: c - collection to be checked for containment in this
     * collection Returns: true if this collection contains all of the elements
     * in the specified collection Throws: ClassCastException - if the types of
     * one or more elements in the specified collection are incompatible with
     * this collection (optional) NullPointerException - if the specified
     * collection contains one or more null elements and this collection does
     * not permit null elements (optional), or if the specified collection is
     * null.
     *
     * @param c - collection to be checked for containment in this collection
     * @return true if this collection contains all of the elements in the
     * specified collection.
     * @throws ClassCastException - if the types of one or more elements in the
     * specified collection are incompatible with this collection
     */
    @Override
    public boolean containsAll(Collection<?> c)
    {

        for (Object o : c)
          {
            if (!this.contains(o))
              {
                return false;
              }
          }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {

        for (E e : c)
          {
            this.add(e);
          }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c
    )
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.



    }

    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection (optional operation). After this call returns, this
     * collection will contain no elements in common with the specified
     * collection.
     *
     * Parameters: c - collection containing elements to be removed from this
     * collection Returns: true if this collection changed as a result of the
     * call Throws: UnsupportedOperationException - if the removeAll method is
     * not supported by this collection ClassCastException - if the types of one
     * or more elements in this collection are incompatible with the specified
     * collection (optional) NullPointerException - if this collection contains
     * one or more null elements and the specified collection does not support
     * null elements (optional), or if the specified collection is null
     *
     * @param c - collection containing elements to be removed from this
     * collection
     * @return true if this collection changed as a result of the call
     * @throws ClassCastException - if the types of one or more elements in this
     * collection are incompatible with the specified collection
     */
    @Override
    public boolean removeAll(Collection<?> c)
    {

        for (Object o : c)
          {
            this.remove(o);
          }
        return true;
    }

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation). In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     *
     *
     * @param c - collection containing elements to be retained in this
     * collection
     * @return true if this collection changed as a result of the call
     * @throws ClassCastException - if the types of one or more elements in this
     * collection are incompatible with the specified collection (optional)
     */
    @Override
    public boolean retainAll(Collection<?> c
    )
    {

        for (Object o : c)
          {
            if (!this.contains(o))
              {
                this.remove(o);
              }
          }
        return true;
    }

    public static void main(String[] args)
            throws ClassNotFoundException, InterruptedException
    {
        ArrayListASDV<Integer> aaa = new ArrayListASDV();
        aaa.add(1);
        aaa.add(2);
        aaa.add(3);
        aaa.add(4);


        ArrayListASDV<Integer> list1 = new ArrayListASDV();
        ArrayListASDV<String> list2 = new ArrayListASDV(4);
        ArrayListASDV<A1> list3 = new ArrayListASDV(4);

        System.out.println("------------------------------ ");
        System.out.println("test add");
        list1.add(10);
        list1.add(20);
        list3.add(new A1(-1));
        list3.add(new A1(-2));
        Integer[] b =
          {
            2, 3
          };

        list1.toArray(b);

        list2.add("a");
        try
          {
            list2.add(null);
          }
        catch (NullPointerException e)
          {
            System.err.println(e);
          };

        list2.add("b");
        list2.add("c");
        list2.add("d");
        System.out.println("------------------------------ ");
        System.out.println("test toString");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        System.out.println("------------------------------ ");
        System.out.println("test contains");
        System.out.println("contains E");
        System.out.println("contains c: " + list2.contains("c"));
        System.out.println("contains null: " + list2.contains(null));
        System.out.println("contains k: " + list2.contains('k'));
        System.out.println(list2);
        System.out.println("contains A(-1): " + list3.contains(new A1(-1)));
        System.out.println("contains A(-3): " + list3.contains(new A1(-3)));

        System.out.println("------------------------------ ");
        System.out.print("test toArray(): ");
        Object[] ar = list2.toArray();
        System.out.print("[ ");
        for (int i = 0; i < ar.length; ++i)
          {
            System.out.print(ar[i] + " ");
          }
        System.out.println(" ] ");

        System.out.println("\n---------------------------------------");
        System.out.println("test clear()");
        list2.clear();
        System.out.println(list2);

        System.out.println("\n---------------------------------------");
        System.out.println("test size");
        System.out.println(list2.size());

        System.out.println("\n---------------------------------------");
        System.out.println("test add(index, element)");
        for (char a = 'Z'; a >= 'A'; --a)
          {
            list2.add(0, "" + a);
          }
        System.out.println(list2);

        list2.add(26, "z");
        System.out.println(list2);

        list2.add(list2.size() - 2, "y");
        System.out.println(list2);

        System.out.println("\n---------------------------------------");
        System.out.println("test remove(index)");
        Object o = list2.remove(27);
        System.out.println(o);
        System.out.println(list2);

        try
          {
            list2.remove(30);
          }
        catch (IndexOutOfBoundsException e)
          {
            System.err.println(e);
          }

        System.out.println("\n---------------------------------------");
        System.out.println("test remove(Object)");
        list2.remove("y");
        System.out.println(list2);
        System.out.println(list2.remove("not in there"));

        System.out.println("\n---------------------------------------");
        System.out.println("test set(index, Object)");
        list2.set(0, "0");
        list2.set(25, "25");
        System.out.println(list2);

        System.out.println("\n---------------------------------------");
        System.out.println("test indexOf()");
        System.out.println(list2.indexOf("0"));
        System.out.println(list2.indexOf("B"));
        System.out.println(list2.indexOf("25"));
        System.out.println(list2.indexOf("Y"));
        System.out.println(list2.indexOf("not there"));

        System.out.println("\n---------------------------------------");
        System.out.println("test lastndexOf()");
        list2.add(10, "0");
        System.out.println(list2.indexOf("0"));
        System.out.println(list2.lastIndexOf("0"));
        System.out.println(list2.indexOf("not there"));
        System.out.println(list2);

        System.out.println("\n---------------------------------------");
        System.out.println("test sublist(from, to)");
        List<String> l1 = list2.subList(1, 10);
        ArrayListASDV<String> l2 = (ArrayListASDV<String>) list2.subList(11, 26);

        System.out.println(l1);
        System.out.println(l2);
        List<String> l3 = l2.subList(11, 11);
        System.out.println(l3);
        try
          {
            l2.subList(12, 11);
          }
        catch (Exception e)
          {
            System.err.println(e);
          }

        System.out.println("\n---------------------------------------");
        System.out.println("test toArray()");
        Object[] ar1 = l2.toArray();
        for (Object obj : ar1)
          {
            System.out.print(obj + " ");
          }

        System.out.println("\n---------------------------------------");
        System.out.println("test toArray(T[] a) small size a");
        ArrayListASDV<Integer> listX = new ArrayListASDV();
        listX.add(10);
        listX.add(20);
        Integer[] a1 =
          {
            1
          };
        ar = listX.toArray(ar);
        for (int i = 0; i < ar.length; ++i)
          {
            System.out.println(ar[i]);
          }
        System.out.println("\n---------------------------------------");
        System.out.println("test toArray(T[] a) Big size a");
        ArrayListASDV<A1> listA1 = new ArrayListASDV();
        listA1.add(new A1(100));

        A1[] a11 =
          {
            new A1(-1), new A1(-2), new A1(3)
          };
        listA1.toArray(a11);
        for (int i = 0; i < a11.length; ++i)
          {
            System.out.println(a11[i]);
          }

        System.out.println("");
        System.out.println("\n---------------------------------------");
        System.out.println("test Iterator()");

        System.out.println(list2);

        Iterator<String> it = list2.iterator();

        while (it.hasNext())
          {
            System.out.print(it.next() + " ");
          }
        System.out.println("");

        System.out.println("\n---------------------------------------");
        System.out.println("test ListIterator1()");
        ArrayListASDV<Integer> li3 = new ArrayListASDV();
        li3.add(10);
        li3.add(20);
        li3.add(30);
        li3.add(40);
        System.out.println(li3);
        ListIterator<Integer> li = li3.listIterator(2);
        while (li.hasNext())
          {
            System.out.print("\tnext index: " + li.nextIndex());
            System.out.print("\tprevious index: " + li.previousIndex());
            System.out.print("\t" + li.next());
          }
        System.out.println("");
        while (li.hasPrevious())
          {
            System.out.print("\tnext index: " + li.nextIndex());
            System.out.print("\tprevious index: " + li.previousIndex());
            System.out.print("\t" + li.previous());
          }
        System.out.println("");
        System.out.println("next index: " + li.nextIndex());
        System.out.println("previous index: " + li.previousIndex());

        System.out.println("\n---------------------------------------");
        System.out.println("test forEachRemaining()");
        System.out.println(li.next());
        li.forEachRemaining(new Consumer<Integer>()
        {
            @Override
            public void accept(Integer t)
            {
                System.out.print(t + 1 + " ");
            }
        });

        System.out.println("\n---------------------------------------");
        System.out.println("test containsAll(Collection)");

        List<Integer> ar33 = Arrays.asList(new Integer[]
          {
            10, 20
          });
        System.out.println(li3.containsAll(ar33));
        ar33 = Arrays.asList(new Integer[]
          {
            10, -1
          });
        System.out.println(li3.containsAll(ar33));

        System.out.println("\n---------------------------------------");
        System.out.println("test removeAll(Collection)");

        li3.add(10);
        li3.add(11);
        li3.add(10);
        System.out.println(li3);
        ar33 = Arrays.asList(new Integer[]
          {
            10
          });
        System.out.println(li3.removeAll(ar33));
        System.out.println(li3);
        List<Object> oar = Arrays.asList(new Object[]
          {
            3.3, 40, "abc"
          });
        try
          {
            li3.removeAll(oar);
          }
        catch (ClassCastException e)
          {
            Thread.sleep(100);
            System.err.println(e);
          }
        System.out.println(li3);
        List<A1> sar = Arrays.asList(new A1[]
          {
            new A1(999)
          });
        try
          {
            li3.removeAll(sar);
          }
        catch (ClassCastException e)
          {
            Thread.sleep(100);
            System.err.println(e);
          }
        System.out.println(li3);

        System.out.println("\n---------------------------------------");
        System.out.println("test retainAll(Collection)");
        ar33 = Arrays.asList(new Integer[]
          {
            30
          });
        li3.retainAll(ar33);
        System.out.println(li3);
        System.out.println("\n---------------------------------------");
        System.out.println("test addAll(Collection)");
        ar33 = Arrays.asList(new Integer[]
          {
            1, 2, 3, 4
          });
        li3.addAll(ar33);
        System.out.println(li3);
        System.out.println("\n---------------------------------------");
        System.out.println("test addAll(index, Collection)");
        ar33 = Arrays.asList(new Integer[]
          {
            100, 200, 300
          });
        li3.addAll(2, ar33);
        System.out.println(li3);

    }

}

class A1 implements Consumer<A1>
{

    int x;

    public A1(int x)
    {
        this.x = x;
    }

    @Override
    public String toString()
    {
        return "A1{" + "x=" + x + '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
          {
            return true;
          }
        if (obj == null)
          {
            return false;
          }
        if (getClass() != obj.getClass())
          {
            return false;
          }
        final A1 other = (A1) obj;
        if (this.x != other.x)
          {
            return false;
          }
        return true;
    }

    @Override
    public void accept(A1 t)
    {
        System.out.println(t.x * t.x);

    }

}
