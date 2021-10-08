package Week4;

import java.io.*;;

public class Delete {

  public static class Solution {

    static class SinglyLinkedListNode {

      public int data;
      public SinglyLinkedListNode next;

      public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
      }
    }

    static class SinglyLinkedList {

      public SinglyLinkedListNode head;
      public SinglyLinkedListNode tail;

      public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
      }

      public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
          this.head = node;
        } else {
          this.tail.next = node;
        }

        this.tail = node;
      }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep,
        BufferedWriter bufferedWriter) throws IOException {
      while (node != null) {
        bufferedWriter.write(String.valueOf(node.data));

        node = node.next;

        if (node != null) {
          bufferedWriter.write(sep);
        }
      }
    }


    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
      SinglyLinkedListNode newnode = llist;
      int i = 0;
      if (position == 0) {
        llist = llist.next;
        return llist;
      }
      while (i < position - 1) {
        newnode = newnode.next;
        i++;
      }
      newnode.next = newnode.next.next;
      return llist;
    }
  }
}
