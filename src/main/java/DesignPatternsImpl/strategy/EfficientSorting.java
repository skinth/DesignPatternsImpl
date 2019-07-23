/*
This file is part of DesignPatternsImpl.

DesignPatternsImpl is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

DesignPatternsImpl is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with DesignPatternsImpl.  If not, see <http://www.gnu.org/licenses/>.
*/
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
