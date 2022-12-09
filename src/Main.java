class Main{
    public static void main(String[] args)  {
        //create a BST object
        BST_class bst = new BST_class();
        /* BST tree example
              45
           /     \
          10      90
         /  \    /
        7   12  50

              R
           /     \
          F      Z
         /  \    /
        D   H  V
         */
        //insert data into BST
        bst.insert("R"); // bst.insert(45);
        bst.insert("F"); // bst.insert(10);
        bst.insert("D"); // bst.insert(7);
        bst.insert("H"); // bst.insert(12);
        bst.insert("Z"); // bst.insert(90);
        bst.insert("V"); // bst.insert(50);
        //print the BST
        System.out.println("The BST Created with input data(Left-root-right):");
        bst.inorder();

        //delete leaf node
        System.out.println("\nThe BST after Delete H(leaf node):");
//        bst.deleteKey(12);
        bst.deleteKey("H");
        bst.inorder();
        //delete the node with one child
        System.out.println("\nThe BST after Delete Z (node with 1 child):");
//        bst.deleteKey(90);
        bst.deleteKey("Z");
        bst.inorder();

        //delete node with two children
        System.out.println("\nThe BST after Delete R (Node with two children):");
//        bst.deleteKey(45);
        bst.deleteKey("R");
        bst.inorder();
        //search a key in the BST
        boolean ret_val = bst.search ("V");
        System.out.println("\nKey V found in BST:" + ret_val );
        ret_val = bst.search ("H");
        System.out.println("\nKey H found in BST:" + ret_val );
    }
}