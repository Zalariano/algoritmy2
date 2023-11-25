package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        IntegerList integerList = new SortedIntegerList(10);
        integerList.add(7);
        integerList.add(6);
        integerList.add(10);
        integerList.add(103);
        integerList.add(12);
        integerList.add(12);
        integerList.add(10);
        integerList.add(103);
        integerList.add(12);
        integerList.add(12);
        System.out.println(integerList.size());
        System.out.println(integerList.get(4));
        System.out.println(integerList.get(integerList.size() - 1));

        findFastedSortMethod();
    }

    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer [] arr = new  Integer [100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
    private static void findFastedSortMethod() {
        IntegerList integerList = new SortedIntegerList(5);
        integerList.add(7);
        integerList.add(6);
        integerList.add(10);
        integerList.add(103);
        integerList.add(12);
        System.out.println("Bubble sort");

        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtilities.sortBubble(Arrays.copyOf(integerList.toArray(), integerList.size()))));
        System.out.println(System.currentTimeMillis() - start + " ms.");
        IntegerList integerList2 = new SortedIntegerList(5);
        integerList2.add(7);
        integerList2.add(6);
        integerList2.add(210);
        integerList2.add(103);
        integerList2.add(12);
        System.out.println("Selection sort");

        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtilities.sortSelection(Arrays.copyOf(integerList2.toArray(), integerList2.size()))));
        System.out.println(System.currentTimeMillis() - start + " ms.");
        IntegerList integerList3 = new SortedIntegerList(5);
        integerList3.add(7);
        integerList3.add(62);
        integerList3.add(10);
        integerList3.add(1203);
        integerList3.add(12);
        System.out.println("Insertion sort");

        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtilities.sortInsertion(Arrays.copyOf(integerList3.toArray(), integerList3.size()))));
        System.out.println(System.currentTimeMillis() - start + " ms.");
    }

}
