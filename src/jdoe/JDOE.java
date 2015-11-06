/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoe;

import java.util.Arrays;
import jdoe.designs.FactorialDesign;
import jdoe.designs.PBDesign;

/**
 *
 * @author diego
 */
public class JDOE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        int[] levels = {2, 2};
        FactorialDesign f = new FactorialDesign();
//        f.FullFactorial(levels);
//        
//        f.printMatrix(f.getMatrix());
        System.out.println("=====ff2n====");
        f.ff2n(3);
        f.printMatrix(f.getMatrix());

        System.out.println("====fracfact=====");
        f.fracfact("a b c ab ac bc abc");
        f.printMatrix(f.getMatrix());
//        System.out.println(Arrays.deepToString(f.getMatrix()));

        System.out.println("====PBDesign=====");
        PBDesign pb = new PBDesign();
        pb.generate(7);
        System.out.println(pb.getLabel());
        pb.printMatrix(pb.getMatrix());
        
        System.out.println("=====Hadamard====");
        pb.Hadamard(4);
        pb.printMatrix(pb.getMatrix());

    }

}
