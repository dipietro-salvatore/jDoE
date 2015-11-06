/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoe.designs;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diego
 */
public class PBDesignTest {

    PBDesign pb = new PBDesign();

    public PBDesignTest() {

    }

    @Test
    public void testGenerate() {
        FactorialDesign f = new FactorialDesign();

        f.clean();
        f.fracfact("a b ab");
        pb.clean();
        pb.generate(3);
        assertEquals(Arrays.deepToString(f.getMatrix()), Arrays.deepToString(pb.getMatrix()));

        f.clean();
        f.fracfact("a b ab c");
        pb.clean();
        pb.generate(4);
        assertEquals(Arrays.deepToString(f.getMatrix()), Arrays.deepToString(pb.getMatrix()));

        f.clean();
        f.fracfact("a b ab c ac bc abc");
        pb.clean();
        pb.generate(7);
        assertEquals(Arrays.deepToString(f.getMatrix()), Arrays.deepToString(pb.getMatrix()));
    }

    @Test
    public void testGenerateLabels() {
        pb.generateLabels(7);
        assertEquals("a b ab c ac bc abc", pb.getLabel());

        pb.clean();
        pb.generateLabels(3);
        assertEquals("a b ab", pb.getLabel());

        pb.clean();
        pb.generateLabels(4);
        assertEquals("a b ab c", pb.getLabel());
    }

}
