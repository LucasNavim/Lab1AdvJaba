import java.util.*;

public class DataStructurePerformance {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000};

        for (int size : sizes) {
            System.out.println("Size: " + size);

            // Array
            int[] array = new int[size];
            System.out.println("Array:");
            measureArray(array, size);

            // HashSet
            HashSet<Integer> hashSet = new HashSet<>();
            System.out.println("HashSet:");
            measureHashSet(hashSet, size);

            // ArrayList
            ArrayList<Integer> arrayList = new ArrayList<>();
            System.out.println("ArrayList:");
            measureArrayList(arrayList, size);

            // LinkedList
            LinkedList<Integer> linkedList = new LinkedList<>();
            System.out.println("LinkedList:");
            measureLinkedList(linkedList, size);
        }
    }

    // Measure operations for Array (basic array in Java)
    public static void measureArray(int[] array, int size) {
        long startTime, endTime;

        // Read by index
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        startTime = System.nanoTime();
        int value = array[size / 2];
        endTime = System.nanoTime();
        System.out.println("Read by index: " + (endTime - startTime) + " ns");

        // Read by value (search)
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            if (array[i] == size / 2) break;
        }
        endTime = System.nanoTime();
        System.out.println("Read by value: " + (endTime - startTime) + " ns");

        // Insert in the Head (shift elements)
        startTime = System.nanoTime();
        for (int i = size - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = -1;
        endTime = System.nanoTime();
        System.out.println("Insert in the Head: " + (endTime - startTime) + " ns");

        // Insert in the Mid
        startTime = System.nanoTime();
        for (int i = size - 1; i > size / 2; i--) {
            array[i] = array[i - 1];
        }
        array[size / 2] = -1;
        endTime = System.nanoTime();
        System.out.println("Insert in the Mid: " + (endTime - startTime) + " ns");

        // Insert in the Tail
        startTime = System.nanoTime();
        array[size - 1] = -1;
        endTime = System.nanoTime();
        System.out.println("Insert in the Tail: " + (endTime - startTime) + " ns");

        // Delete from Head (shift elements)
        startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        endTime = System.nanoTime();
        System.out.println("Delete from Head: " + (endTime - startTime) + " ns");

        // Delete from Mid
        startTime = System.nanoTime();
        for (int i = size / 2; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        endTime = System.nanoTime();
        System.out.println("Delete from Mid: " + (endTime - startTime) + " ns");

        // Delete from Tail
        startTime = System.nanoTime();
        array[size - 1] = 0;
        endTime = System.nanoTime();
        System.out.println("Delete from Tail: " + (endTime - startTime) + " ns");
    }

    // Measure operations for HashSet
    public static void measureHashSet(HashSet<Integer> set, int size) {
        long startTime, endTime;

        // Insert
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Insert in the Set: " + (endTime - startTime) + " ns");

        // Read by value (search)
        startTime = System.nanoTime();
        boolean exists = set.contains(size / 2);
        endTime = System.nanoTime();
        System.out.println("Read by value (search): " + (endTime - startTime) + " ns");

        // Delete by value
        startTime = System.nanoTime();
        set.remove(size / 2);
        endTime = System.nanoTime();
        System.out.println("Delete from Set: " + (endTime - startTime) + " ns");
    }

    // Measure operations for ArrayList
    public static void measureArrayList(ArrayList<Integer> list, int size) {
        long startTime, endTime;

        // Insert in the Tail
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Insert in the Tail: " + (endTime - startTime) + " ns");

        // Read by index
        startTime = System.nanoTime();
        int value = list.get(size / 2);
        endTime = System.nanoTime();
        System.out.println("Read by index: " + (endTime - startTime) + " ns");

        // Insert in the Mid
        startTime = System.nanoTime();
        list.add(size / 2, -1);
        endTime = System.nanoTime();
        System.out.println("Insert in the Mid: " + (endTime - startTime) + " ns");

        // Delete from Head
        startTime = System.nanoTime();
        list.remove(0);
        endTime = System.nanoTime();
        System.out.println("Delete from Head: " + (endTime - startTime) + " ns");

        // Delete from Mid
        startTime = System.nanoTime();
        list.remove(size / 2);
        endTime = System.nanoTime();
        System.out.println("Delete from Mid: " + (endTime - startTime) + " ns");

        // Delete from Tail
        startTime = System.nanoTime();
        list.remove(list.size() - 1);
        endTime = System.nanoTime();
        System.out.println("Delete from Tail: " + (endTime - startTime) + " ns");
    }

    // Measure operations for LinkedList
    public static void measureLinkedList(LinkedList<Integer> list, int size) {
        long startTime, endTime;

        // Insert in the Tail
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Insert in the Tail: " + (endTime - startTime) + " ns");

        // Read by index
        startTime = System.nanoTime();
        int value = list.get(size / 2);
        endTime = System.nanoTime();
        System.out.println("Read by index: " + (endTime - startTime) + " ns");

        // Insert in the Head
        startTime = System.nanoTime();
        list.addFirst(-1);
        endTime = System.nanoTime();
        System.out.println("Insert in the Head: " + (endTime - startTime) + " ns");

        // Insert in the Mid
        startTime = System.nanoTime();
        list.add(size / 2, -1);
        endTime = System.nanoTime();
        System.out.println("Insert in the Mid: " + (endTime - startTime) + " ns");

        // Delete from Head
        startTime = System.nanoTime();
        list.removeFirst();
        endTime = System.nanoTime();
        System.out.println("Delete from Head: " + (endTime - startTime) + " ns");

        // Delete from Mid
        startTime = System.nanoTime();
        list.remove(size / 2);
        endTime = System.nanoTime();
        System.out.println("Delete from Mid: " + (endTime - startTime) + " ns");

        // Delete from Tail
        startTime = System.nanoTime();
        list.removeLast();
        endTime = System.nanoTime();
        System.out.println("Delete from Tail: " + (endTime - startTime) + " ns");
    }
}