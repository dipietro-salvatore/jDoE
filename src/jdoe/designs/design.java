/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoe.designs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author diego
 */
public class design {

    protected int[] levels;
    protected int numParams;
    protected List<String> matric2 = new ArrayList<String>();
    protected int[][] matrix;

    public int[][] getMatrix() {
        return this.matrix;
    }

    protected int calculateLines(int[] levels) {
        int r = 1;
        for (int l : levels) {
            r = r * l;
        }
        return r;
    }
    
    
    protected int calculateColumns(int factors) {
        int r = 1;
        for (int l : levels) {
            r = r * l;
        }
        return r;
    }

    public void clean(){
        this.levels = null;
        this.matrix = null;
        this.numParams = 0;
    }

    public void printMatrix(int[][] matrix) {
//        System.out.println(Arrays.deepToString(matrix));
//        return;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%+d  ", matrix[i][j]);
            }
            System.out.print("\n");
        }

    }

    protected void replaceValuesMatrix(int[] newvalues) {

        for (int l = 0; l < this.matrix.length; l++) {
            for (int r = 0; r < newvalues.length; r++) {
                for (int i = 0; i < this.matrix[l].length; i++) {
                    if (this.matrix[l][i] == r) {
                        this.matrix[l][i] = newvalues[r];
                    }
                }
            }
        }
    }

    

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


}
