package Week4;

import java.util.*;

public class PrintReverse {


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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
      while (node != null) {
        System.out.print(node.data);

        node = node.next;

        if (node != null) {
          System.out.print(sep);
        }
      }
    }


    public static void reversePrint(SinglyLinkedListNode llist) {
      if (llist != null) {
        reversePrint(llist.next);
        System.out.println(llist.data);
      }
    }

    private static final Scanner scanner = new Scanner(System.in);
  }
}