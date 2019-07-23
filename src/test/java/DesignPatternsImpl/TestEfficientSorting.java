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
