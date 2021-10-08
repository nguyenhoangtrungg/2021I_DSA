package Week4;

import java.io.*;

public class GetValue {


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


    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
      int n = 0, j = 0;
      for (SinglyLinkedListNode i = llist; i != null; i = i.next) {
        n++;
      }
      n -= positionFromTail;
      for (SinglyLinkedListNode i = llist; i != null; i = i.next) {
        j++;
        if (j == n) {
          return i.data;
        }
      }
      return 0;
    }
  }
}