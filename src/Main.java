//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static ArrayList<String> carregarDicionario(String caminho) throws FileNotFoundException {
//        Scanner leitorArq = new Scanner(new File(caminho));
//        ArrayList<String> dicionario = new ArrayList<>();
//
//        while (leitorArq.hasNextLine()) {
//            String[] palavra = leitorArq.nextLine().split("\n");
//            dicionario.add(Arrays.toString(palavra));
//        }
//        leitorArq.close();
//        return dicionario;
//    }
//    public static void main(String[] args) throws FileNotFoundException {
//        ArrayList<String> dicionario = carregarDicionario("palavras.txt");
//        String[] keys = dicionario.toArray(new String[0]);
//        int n = keys.length;
//
//        int[] freq = new int[n];
//        Arrays.fill(freq, 1);
//
//        System.out.println("Cost of Optimal BST is "
//                + Optimal_BST2.optimalSearchTree(keys, freq, n));
//    }
//
//}