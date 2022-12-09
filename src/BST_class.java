import java.util.ArrayList;

class BST_class {
    //node class that defines BST node
    static class Node {
        String word;
        String meaning;
        int frequency;
        Node left, right;

        public Node(String word){
            this.word = word;
            this.left = this.right = null;
        }

        public Node(String word, int freq){
            this.word = word;
            this.frequency = freq;
            this.left = this.right = null;
        }
    }
    // BST root node
    Node root;

    // Constructor for BST =>initial empty tree
    BST_class(){
        root = null;
    }
    //delete a node from BST
    void deleteKey(String key) {
        root = delete_Recursive(root, key);
    }

    //recursive delete function
    Node delete_Recursive(Node root, String key)  {
        //tree is empty
        if (root == null)  return root;

        //traverse the tree
        if (root.word.compareTo(key) > 0)     //traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (root.word.compareTo(key) < 0)  //traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else  {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.word = minValue(root.right);

            // Delete the inorder successor
            root.right = delete_Recursive(root.right, root.word);
        }
        return root;
    }

    String minValue(Node root)  {
        //initially minval = root
        String minval = root.word;
        //find minval
        while (root.left != null)  {
            minval = root.left.word;
            root = root.left;
        }
        return minval;
    }

    // insert a node in BST
    void insert(String key, int freq)  {
        root = insert_Recursive(root, key, freq);
    }

    //recursive insert function
    Node insert_Recursive(Node root, String key, int freq) {
        //tree is empty
        if (root == null) {
            root = new Node(key, freq);
            return root;
        }
        //traverse the tree
        if (root.word.compareTo(key) < 0)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key, freq);
        else if (root.word.compareTo(key) > 0)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key, freq);
        // return pointer
        return root;
    }
    // insert a node in BST
    void insert(String key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    Node insert_Recursive(Node root, String key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (root.word.compareTo(key) > 0)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (root.word.compareTo(key) < 0)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    void inorder() {
        inorder_Recursive(root);
    }

    // recursively traverse the BST
    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.word + " ");
            inorder_Recursive(root.right);
        }
    }

    boolean search(String key)  {
        root = search_Recursive(root, key);
        if (root!= null)
            return true;
        else
            return false;
    }

    //recursive insert function
    Node search_Recursive(Node root, String key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.word.equals(key) ){
            if (root != null) {
                root.frequency++;
            }
            return root;
        }
        // val is greater than root's key
        if (root.word.compareTo(key) > 0)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }
    static class Elemento{
        int posicao;
        int frequencia;
        int chave;
    }
    public static Elemento[] checaCusto(ArrayList<Integer> freq, int custoTotal){
        int tamanho = freq.size();
        Elemento[] elementos = new Elemento[tamanho];
        int custoPossivel = 0;
        for (int i = 0; i < tamanho; i++){
            Elemento atual = new Elemento();

            int posicao = i + 1;
            atual.posicao = posicao;

            custoPossivel += freq.get(i) * posicao;
            atual.frequencia = freq.get(i);

            elementos[i] = atual;
        }
        if (custoPossivel == custoTotal){
            return elementos;
//        }else{
//            for (int i = 0; i < 10; i++){
//                Elemento atual = new Elemento();
//
//                int posicao = 2 ^ i;
//                atual.posicao = posicao;
//
//                custoPossivel += freq.get(i) * posicao;
//                atual.frequencia = freq.get(i);
//
//                elementos[i] = atual;
//            }
        }
        int aux = freq.get(0);
        freq.remove(0);
        freq.add(aux);
        return checaCusto(freq, custoTotal);
    }


}