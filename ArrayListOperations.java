import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    // Add element
    public static void add(ArrayList<Integer> list, int value) {
        list.add(value);
    }

    // Remove element (by index)
    public static void remove(ArrayList<Integer> list, int index) {
        list.remove(index);
    }

    // Search element
    public static int search(ArrayList<Integer> list, int value) {
        return list.indexOf(value);
    }

    // Sort list
    public static void sort(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    // Traverse
    public static void traverse(ArrayList<Integer> list) {
        System.out.println(list);
    }
}
