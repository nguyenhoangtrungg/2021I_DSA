package Week4;

import java.io.*;

public class InsertSpecific {

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

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data,
        int position) {
      SinglyLinkedListNode newnode = new SinglyLinkedListNode(data);
      if (llist == null) {
        llist = newnode;
        return llist;
      }
      int i = 0;

      SinglyLinkedListNode addNote = llist;
      while (i < position - 1) {
        addNote = addNote.next;
        i++;
      }
      newnode.next = addNote.next;
      addNote.next = newnode;
      return llist;
    }
  }
}
