/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortpractice;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author Training
 */
public class SortPractice {

    public static void main(String[] args) {
        System.out.println("generated array:");
        Integer[] arr = generateArray();
        printArray(arr);

        System.out.println("quick sort:");
        Integer[] tmpArr = Arrays.copyOf(arr, arr.length);
        quickSort(tmpArr);
        printArray(tmpArr);

        System.out.println("bubble sort:");
        tmpArr = Arrays.copyOf(arr, arr.length);
        bubbleSort(tmpArr);
        printArray(tmpArr);

        System.out.println("insertion sort: ");
        tmpArr = Arrays.copyOf(arr, arr.length);
        insertionSort(tmpArr);
        printArray(tmpArr);

        System.out.println("radix sort: ");
        tmpArr = Arrays.copyOf(arr, arr.length);
        radixSort(tmpArr);
        printArray(tmpArr);
    }

    public static Integer[] generateArray() {
        int len = (int) (Math.random() * 100);
        Integer[] out = new Integer[len];
        for (int i = 0; i < len; i++) {
            out[i] = (int) (Math.random() * 100);
        }
        return out;
    }

    public static <T> void printArray(T[] arr) {
        System.out.print("[ ");
        for (T val : arr) {
            System.out.print(val);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public static <T extends Comparable> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (0 > arr[j].compareTo(arr[j - 1])) {
                    T tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static <T extends Comparable> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (0 < arr[j - 1].compareTo(arr[j])) {
                    T tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    public static <T extends Comparable> void mergeSort(T[] arr) {

    }

    public static <T extends Comparable> void mergeSort(T[] arr, int low, int high) {

    }

    public static <T extends Comparable> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static <T extends Comparable> int partition(T[] arr, int low, int high) {
        int i = low + 1,
                j = high;
        T pivot = arr[low];
        while (true) {
            while (i <= j && 0 >= arr[i].compareTo(pivot)) {
                i++;
            }
            while (j >= i && 0 <= arr[j].compareTo(pivot)) {
                j--;
            }
            if (i > j) {
                T tmp = arr[low];
                arr[low] = arr[j];
                arr[j] = tmp;
                return j;
            }
            T tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void radixSort(Integer[] inp) {
        int[] bucket = new int[10];
        Integer[] out = new Integer[inp.length];
        int max = inp[0];
        for (int i = 1; i < inp.length; i++) {
            if (max < inp[i]) {
                max = inp[i];
            }
        }
        for (int digitNum = 1; max / digitNum > 0; digitNum++) {
            //initialize bucket
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = 0;
            }
            for (int i = 0; i < inp.length; i++) {
                bucket[inp[i] / digitNum % 10]++;
            }
            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = inp.length - 1; 0 <= i; i--) {
                int val = inp[i];
                out[--bucket[val / digitNum % 10]] = val;
            }
            for (int i = 0; i < out.length; i++) {
                inp[i] = out[i];
            }
        }
    }
}
