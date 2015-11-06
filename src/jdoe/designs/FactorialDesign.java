/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoe.designs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import objects.Labels;

/**
 *
 * @author diego
 */
public class FactorialDesign extends design {

    private int counter = 0;

    public FactorialDesign() {

    }

    /*
    
     FullFactorialDesign( { 2,2,3} ) = {{0, 0, 0}, {0, 0, 1}, {0, 0, 2}, {0, 1, 0}, {0, 1, 1}, {0, 1, 2}, {1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 1, 0}, {1, 1, 1}, {1, 1, 2}}
       
     */
    public void FullFactorial(int[] levels) {
        this.levels = levels;
        this.numParams = levels.length;
        int[] matrix = new int[this.levels.length];

        this.matrix = new int[calculateLines(this.levels)][this.levels.length];
        this.counter = 0;

        createFullFactorial(0, matrix);

    }

    public void ff2n(int levels) {
        //create levels array
        int[] l = new int[levels];
        for (int i = 0; i < levels; i++) {
            l[i] = 2;
        }

        this.levels = l;
        this.numParams = l.length;
        int[] matrix = new int[this.levels.length];

        this.matrix = new int[calculateLines(this.levels)][this.levels.length];
        this.counter = 0;

        createFullFactorial(0, matrix);
        replaceValuesMatrix(new int[]{-1, +1});

    }

    public void createFullFactorial(int factor, int[] matrix) {

        if (this.levels.length == factor) {
            this.matrix[this.counter] = Arrays.copyOf(matrix, matrix.length);
            this.counter++;
            return;
        }

        for (int i = 0; i < this.levels[factor]; i++) {
            matrix[factor] = i;
            createFullFactorial(factor + 1, matrix);
        }

    }
    /*
    
     fracfact("a b c ab ac bc abc")
     */

    public void fracfact(String slabels) {
        Labels l = new Labels(slabels);
        String[] mainEffectLabels = l.getMainEffects();

        //generate ff2n design
        ff2n(mainEffectLabels.length);

        //Create matrix bigger for others effects
        int[][] mainEffectMatrix = Arrays.copyOf(this.matrix, this.matrix.length);
        this.matrix = new int[this.matrix.length][l.getSize()];

        //fill remaining boxes with other values
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) { //each cell

                //loop the lables
                int[] column = l.getLabel(j);

                int value = 1;
                for (int z = 0; z < column.length; z++) {
                    value = value * mainEffectMatrix[i][column[z]];
                }
                this.matrix[i][j] = value;

            }
        }


    }

}
