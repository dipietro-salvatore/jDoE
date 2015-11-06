/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoe.designs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diego
 */
public class FactorialDesignTest {

    public FactorialDesignTest() {
    }

    @Test
    public void testFullFactorial() {

        FactorialDesign f = new FactorialDesign();
        int[][] matrix;

        f.FullFactorial(new int[]{2, 2});
        matrix = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        assertArrayEquals(f.getMatrix(), matrix);

        f.FullFactorial(new int[]{2, 3});
        matrix = new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}};
        assertArrayEquals(f.getMatrix(), matrix);

        f.FullFactorial(new int[]{3, 3});
        matrix = new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        assertArrayEquals(f.getMatrix(), matrix);

        f.FullFactorial(new int[]{2, 2, 3});
        matrix = new int[][]{{0, 0, 0}, {0, 0, 1}, {0, 0, 2}, {0, 1, 0}, {0, 1, 1}, {0, 1, 2}, {1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 1, 0}, {1, 1, 1}, {1, 1, 2}};
        assertArrayEquals(f.getMatrix(), matrix);
    }

    @Test
    public void testCalculateLines() {
        int r;
        int[] array = new int[]{2, 2};

        FactorialDesign f = new FactorialDesign();
        r = f.calculateLines(array);
        assertEquals(4, r);

        array = new int[]{2, 3};
        r = f.calculateLines(array);
        assertEquals(6, r);

        array = new int[]{3, 3};
        r = f.calculateLines(array);
        assertEquals(9, r);

        array = new int[]{2, 2, 2};
        r = f.calculateLines(array);
        assertEquals(8, r);

        array = new int[]{2, 3, 2};
        r = f.calculateLines(array);
        assertEquals(12, r);

        array = new int[]{2, 3, 4};
        r = f.calculateLines(array);
        assertEquals(24, r);

    }

    @Test
    public void testFf2n() {
        FactorialDesign f = new FactorialDesign();
        int[][] matrix;

        f.ff2n(2);
        matrix = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        assertArrayEquals(f.getMatrix(), matrix);

        f.ff2n(3);
        matrix = new int[][]{{-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1}, {1, -1, -1}, {1, -1, 1}, {1, 1, -1}, {1, 1, 1}};
        assertArrayEquals(f.getMatrix(), matrix);

    }

    @Test
    public void testReplaceValuesMatrix() {
    }

    @Test
    public void testCreateFullFactorial() {
    }

    @Test
    public void testFracfact() {
        FactorialDesign f = new FactorialDesign();
        int[][] matrix;

        f.fracfact("a b c ab ac bc abc");
        matrix = new int[][]{{-1, -1, -1, 1, 1, 1, -1}, {-1, -1, 1, 1, -1, -1, 1}, {-1, 1, -1, -1, 1, -1, 1}, {-1, 1, 1, -1, -1, 1, -1}, {1, -1, -1, -1, -1, 1, 1}, {1, -1, 1, -1, 1, -1, -1}, {1, 1, -1, 1, -1, -1, -1}, {1, 1, 1, 1, 1, 1, 1}};
        assertArrayEquals(f.getMatrix(), matrix);
    }

}
