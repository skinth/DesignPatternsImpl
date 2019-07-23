package DesignPatternsImpl;

import DesignPatternsImpl.strategy.EfficientSorting;
import DesignPatternsImpl.strategy.ISortStrategy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class TestEfficientSorting {

    ISortStrategy sorter;

    @Before public void create() {
        sorter = new EfficientSorting();
    }

    @Test public void isSorted() {
        int[] a = {3,1,-1,2,2,90,12};
        int[] ret = sorter.sort(a);
        int i = 0;
        while(i < ret.length-1 && ret[i] <= ret[i+1])
            i++;
        assertEquals(ret.length-1, i);
    }

}
