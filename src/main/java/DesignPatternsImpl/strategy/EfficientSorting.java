package DesignPatternsImpl.strategy;

import java.util.Arrays;

public class EfficientSorting implements ISortStrategy {

    @Override
    public int[] sort(int[] array) {
        return mergeSort(array);
    }

    //divide: divide the array recursively and merge
    private int[] mergeSort(int a[]) {
        int middle = (a.length/2);
        //one element, return the element!
        if (middle == 0)
            return a;
        //merge the two sorted parts
        return merge(
                //sort the left side
                mergeSort(Arrays.copyOfRange(a, 0, middle)),
                //sort the right side
                mergeSort(Arrays.copyOfRange(a, middle, a.length)));
    }

    //impera: merge two sorted array
    private int[] merge(int a[], int b[]) {
        int ret[] = new int[a.length+b.length];
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] <= b[j])
                ret[k++] = a[i++];
            else
                ret[k++] = b[j++];
        }
        while(i < a.length)
            ret[k++] = a[i++];
        while(j < b.length)
            ret[k++] = b[j++];
        return ret;
    }

}
