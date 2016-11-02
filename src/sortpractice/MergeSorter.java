/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortpractice;

import java.util.Arrays;

/**
 *
 * @author Training
 */
public class MergeSorter<T extends Comparable> {
    
    T[] copy;
    T[] arr;
    
    public MergeSorter(T[] arr) {
        this.arr = arr;
        this.copy = Arrays.copyOf(arr, arr.length);
    }
    
    public void sort() {
        sort(0, arr.length-1);
    }
    
    private void sort(final int low, final int high) {
        if (low < high) {
            final int mid = low + (high - low) / 2;
            sort(low, mid);
            sort(mid+1, high);
            merge(low, mid, high);
        }
    }
    
    private void merge(final int low, final int mid, final int high) {
        for(int i = low; i <= high; i++ ) {
            copy[i] = arr[i];
        }
        int i = low,
            j = mid + 1,
            k = low;
        while(i <= mid && j <= high) {
            int cmp = copy[i].compareTo(copy[j]);
            if(0 >= cmp) {
                arr[k] = copy[i++];
            }
            else {
                arr[k] = copy[j++];
            }
            k++;
        }
        while(i <= mid) {
            arr[k++] = copy[i++];
        }
    }
}
