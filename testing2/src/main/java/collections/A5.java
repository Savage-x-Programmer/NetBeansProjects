/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author angelfigeralperezestevez
 */
public class A5 {

    public static void main(String[] args) {
        System.out.println("Sorting in ascending order");
        List<String> list1 = Arrays.asList("red",
                "green", "blue");
        Collections.sort(list1);
        System.out.println(list1);
        System.out.println("Sorting in decending order");
        List<String> list2 = Arrays.asList("yellow", "red",
                "green", "blue");
        Collections.sort(list2, Collections.reverseOrder());
        System.out.println(list2);
        System.out.println("\nBinary search");
        List<Integer> list3
                = Arrays.asList(2, 4, 7, 10, 11, 45, 50, 59, 60, 66);
        System.out.println(list3 + "is at index: " + Collections.binarySearch(list3, 7));
        System.out.println(list3 + " 9 is at index: " + Collections.binarySearch(list3, 9));
        System.out.println(list3 + " 100 is at index: " + Collections.binarySearch(list3, 100));
        List<String> list4 = Arrays.asList("blue", "green", "red"
        );
        System.out.println(list4 + " red is at index: " + Collections.binarySearch(list4, "red"
        ));
        System.out.println(list4 + " amber is at index:" + Collections.binarySearch(list4,
                "amber"));
        System.out.println(list4 + " brown is at index: " + Collections.binarySearch(list4,
                "brown"));
        System.out.println("\nReverse the list");
        List<String> list5 = Arrays.asList("yellow", "red", "green", "blue");
        System.out.println("Original list: " + list5);
        Collections.reverse(list5);
        System.out.println("Reversed list: " + list5);
        System.out.println("InSuffle lists");
        List<String> list6 = Arrays.asList("yellow", "red", "green", "blue");
        List<String> list7 = Arrays.asList("yellow", "red", "green", "blue");
        System.out.println("Original list: " + list6);
        Collections.shuffle(list6, new Random(20));
        System.out.println("Suffled list: " + list6);
        System.out.println("Original list: " + list7);
        Collections.shuffle(list7, new Random(20));
        System.out.println("Suffled list: " + list6);

        List<String> list8 = Arrays.asList("yellow", "red", "green", "blue");
        List<String> list9 = Arrays.asList("white", "black");
        System.out.println("\nCopy into " + list8 + " the list " + list9);
        Collections.copy(list8, list9);
        System.out.println(list8);
        System.out.println("The output for list8 is [white, black, green, blue].\n"
                + "The copy method performs a\n"
                + "shallow copy: only the references of the elements from the source list are copied.");
        List<String> list10 = Arrays.asList("red", "green", "blue");
        System.out.println("InFiil the list " + list10 + " with \'black\' ");
        Collections.fill(list10, "black");
        System.out.println(list10);

        System.out.println("\nCollentions.disjoint()");
        Collection<String> collection1 = Arrays.asList("red", "cyan");
        Collection<String> collection2 = Arrays.asList("red",
                "blue");
        Collection<String> collection3 = Arrays.asList("pink", "tan");
        System.out.println(Collections.disjoint(collection1, collection2));
        System.out.println(Collections.disjoint(collection1, collection3));
        System.out.println("\nFrequency");
        Collection<String> collection = Arrays.asList("red", "cyan", "red");
        System.out.println(collection + " red occurs " + Collections.frequency(collection, "red") + " times");

    }
}
