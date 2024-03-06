import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Test add
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList add: " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList add: " + (endTime - startTime) + "\n");

        //  Test get
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList get: " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList get: " + (endTime - startTime) + "\n");

        // Test remove
        startTime = System.nanoTime();
        for (int i = 999; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList remove: " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 999; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList remove: " + (endTime - startTime));
    }
}