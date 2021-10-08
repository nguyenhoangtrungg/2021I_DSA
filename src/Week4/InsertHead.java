package Week4;

import java.io.*;

public class InsertHead {


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

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
      SinglyLinkedListNode newnode = new SinglyLinkedListNode(data);
      if (llist == null) {
        llist = newnode;
        return llist;
      }
      newnode.next = llist;
      return newnode;
    }

  }
}
