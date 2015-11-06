/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdoe.designs;

/**
 *
 * @author diego
 */
public class PBDesign extends design {

    private String label = "";
    private final char a = 'a';
    private final int charA = (int) a;

    public void generate(int factors) {

        if (factors < 2) {

        }

        FactorialDesign f = new FactorialDesign();

        generateLabels(factors);

        f.fracfact(this.label);
        this.matrix = f.getMatrix();

    }

    public void generateLabels(int factors) {

        for (int i = 1; i <= factors; i++) { // lines
            String ls = "";
            String num = new StringBuilder(Integer.toBinaryString(i)).reverse().toString();

            for (int j = 0; j < num.length(); j++) { //convert binary string
                char c = num.charAt(j);
                if (c != '0') {
                    ls = ls + Character.toString((char) (charA + j));
                }
            }
            this.label += ls + " ";
        }
        this.label = this.label.trim();
    }
    
    /*
    
    An n x n matrix H = hij is an Hadamard matrix of
order n if the entries of H are either +1 or -1 and such
that HHt = nI, where Ht  is the transpose of H and I is the
order n identity matrix.
Put another way, a (+1,-1)-matrix is Hadamard if the inner
product of two distinct rows is 0 and the inner product of a
row with itself is n.
    

    
    
    */
    public void Hadamard(int N) {
        int keep = N;

        //fing the multiple of 4 near to N
        int test = N % 4;
        if (test != 0) {
            N = numberOfLines(N);
//            N = ((int) ((N / 4) + 1)) * 4;
            //N = (int) Math.pow(2, (int) ((N / 4) + 1));
        }

        boolean[][] H = new boolean[N][N];
        this.matrix = new int[N][N];

        // initialize Hadamard matrix of order N
        H[0][0] = true;
        for (int n = 1; n < N; n += n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    H[i + n][j] = H[i][j];
                    H[i][j + n] = H[i][j];
                    H[i + n][j + n] = !H[i][j];
                }
            }
        }

        boolean[][] o = new boolean[N][keep];
        for (int j = 0; j < H.length; j++) {
            int diff = (H.length - keep);
            for (int i = diff; i < H.length; i++) {
                o[j][i - diff] = H[j][i];
            }
        }

        H = o;

        // Convert  matrix
        String[][] lines = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < keep; j++) {
                if (o[i][j]) {
                    this.matrix[i][j] = -1;
                } else {
                    this.matrix[i][j] = +1;
                }
            }
        }

    }

    public String getLabel() {
        return label;
    }

    @Override
    public void clean() {
        super.clean();
        this.label = "";
    }

    public int numberOfLines(int n) {
        return 4 * ((int) (n / 4) + 1);
    }

    /*
     is it correct?
     */
    public int findCombinatiory(int num, int subset) {
        if (subset == 1) {
            return num;
        }

        int poss = factorial(num) / (factorial(num - subset) * factorial(subset));
        return poss + findCombinatiory(num, subset - 1);
    }
}
