package Week4;

import java.io.*;

public class Merge {

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

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
      if (head1 == null && head2 == null) {
        return null;
      }
      if (head1 == null) {
        return head2;
      }
      if (head2 == null) {
        return head1;
      }
      if (head1.data < head2.data) {
        head1.next = mergeLists(head1.next, head2);
        return head1;
      }
      head2.next = mergeLists(head1, head2.next);
      return head2;
    }
  }
}
