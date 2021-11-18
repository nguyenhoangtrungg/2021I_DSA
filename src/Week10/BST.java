package Week10;

public class BST {

  class Node {
    int data;
    Node left;
    Node right;
  }

  boolean checkBST(Node root) {
    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  boolean checkBST(Node root, int low, int high) {
    if(root == null) return true;
    return root.data > low && root.data < high && checkBST(root.left, low, root.data)
        && checkBST(root.right, root.data, high);
  }

}
