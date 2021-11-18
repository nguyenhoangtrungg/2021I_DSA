package Week10;

public class SelfBalancingTree {

  static class Node {

    int val;
    int ht;
    Node left;
    Node right;

    static Node insert(Node root, int val) {
      if (root == null) {
        Node node = new Node();
        node.val = val;
        return node;
      }
      if (root.val < val) {
        root.right = insert(root.right, val);
      } else {
        root.left = insert(root.left, val);
      }
      updateHeight(root);
      int bal = getHeight(root.left) - getHeight(root.right);

      if (bal > 1 && root.left.val > val) {
        return rightRotate(root);
      }
      if (bal < -1 && root.right.val < val) {
        return leftRotate(root);
      }
      if (bal > 1 && root.left.val < val) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
      }
      if (bal < -1 && root.right.val > val) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
      }
      return root;
    }

    static Node leftRotate(Node root) {
      if (root == null) {
        return null;
      }
      Node temp = root.right;
      root.right = temp.left;
      temp.left = root;
      updateHeight(root);
      updateHeight(temp);
      return temp;
    }

    static Node rightRotate(Node root) {
      if (root == null) {
        return null;
      }
      Node temp = root.left;
      root.left = temp.right;
      temp.right = root;
      updateHeight(root);
      updateHeight(temp);
      return temp;
    }

    static void updateHeight(Node temp) {
      int l = getHeight(temp.left);
      int r = getHeight(temp.right);
      temp.ht = (Math.max(l, r)) + 1;
    }

    static int getHeight(Node root) {
      if (root == null) {
        return -1;
      }
      return root.ht;
    }
  }
}
