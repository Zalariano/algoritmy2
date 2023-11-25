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
            arr[i] = random.nextInt(100000) + 100_000;
        }
        return arr;
    }
    private static void findFastedSortMethod() {

        System.out.println("Bubble sort");

        Integer[] proba = generateRandomArray();

        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtilities.sortBubble(Arrays.copyOf(proba,100000))));
        System.out.println(System.currentTimeMillis() - start + " ms.");

        System.out.println("Selection sort");
        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtilities.sortSelection(Arrays.copyOf(proba,100000))));
        System.out.println(System.currentTimeMillis() - start + " ms.");

        System.out.println("Insertion sort");
        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtilities.sortInsertion(Arrays.copyOf(proba,100000))));
        System.out.println(System.currentTimeMillis() - start + " ms.");

    }

}
