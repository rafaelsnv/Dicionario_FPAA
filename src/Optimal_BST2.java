import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Dynamic Programming Java code for Optimal Binary Search
// Tree Problem
public class Optimal_BST2 {

    /* A Dynamic Programming based function that calculates
        minimum cost of a Binary Search Tree. */
    public static int optimalSearchTree(String[] keys, int[] freq, int n) {

		/* Create an auxiliary 2D matrix to store results of
		subproblems */
        int[][] cost = new int[n + 1][n + 1];
        ArrayList<String> tree_arr = new ArrayList<>(n);
        String[] tree = new String[n];
		/* cost[i][j] = Optimal cost of binary search tree that
		can be formed from keys[i] to keys[j]. cost[0][n-1]
		will store the resultant cost */

        // For a single key, cost is equal to frequency of the key
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];

        // Now we need to consider chains of length 2, 3, ... .
        // L is chain length.
        for (int L = 2; L <= n; L++) {

            // i is row number in cost[][]
            for (int i = 0; i <= n - L + 1; i++) {

                // Get column number j from row number i and
                // chain length L
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
                int off_set_sum = sum(freq, i, j);

                // Try making all keys in interval keys[i..j] as root
                for (int r = i; r <= j; r++) {

                    // c = cost when keys[r] becomes root of this subtree
                    int c;
                    int cost_minus;
                    int cost_plus;
                    if (r > i) {
                        if (r < j){
                            cost_minus = cost[i][r - 1];
                            cost_plus = cost[r + 1][j];
                            c = cost_minus + cost_plus + off_set_sum;
                        }
                        else{
                            cost_minus = cost[i][r - 1];
                            c = cost_minus + off_set_sum;
                            if (r < keys.length){
                                tree[r-1] = keys[r-1];
                            }
                        }
                    }else {
                        if (r < j) {
                            cost_plus = cost[r + 1][j];
                            c = cost_plus + off_set_sum;
                        }
                        else{
                            c = off_set_sum;
                        }
                    }
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }
        return cost[0][n - 1];
    }

    // A utility function to get sum of array elements
    // freq[i] to freq[j]
    static int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            if (k >= freq.length)
                continue;
            s += freq[k];
        }
        return s;
    }
    public static ArrayList<String> carregarDicionario(String caminho) throws FileNotFoundException {
        Scanner leitorArq = new Scanner(new File(caminho));
        ArrayList<String> dicionario = new ArrayList<>();

        while (leitorArq.hasNextLine()) {
            String[] palavra = leitorArq.nextLine().split("\n");
            dicionario.add(Arrays.toString(palavra));
        }
        leitorArq.close();
        return dicionario;
    }
    public static void main(String[] args) throws FileNotFoundException {
//        ArrayList<String> dicionario = carregarDicionario("src/palavrasReduzidas.txt");
//        String[] keys = dicionario.toArray(new String[0]);
//        int n = keys.length;
//
//        int[] freq = new int[n];
//        Arrays.fill(freq, 1);
//
//        System.out.println("Cost of Optimal BST is "
//                + Optimal_BST2.optimalSearchTree(keys, freq, n));

        String keys[] = { "A", "B", "C" };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;
        System.out.println("Cost of Optimal BST is "
                + optimalSearchTree(keys, freq, n));
    }
}
//This code is contributed by Sumit Ghosh
