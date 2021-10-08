package Week4;

import java.io.*;

import java.util.*;

public class GetNodeValue {

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

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }


  public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    if(llist.next == null && positionFromTail == 0) return llist.data;
    if(positionFromTail == 0) return llist.data;
    if(llist.next == null || llist == null) return 0;
    int data = getNode(llist.next,positionFromTail);
    if(data == 0) return getNode(llist.next,positionFromTail-1);
    return data;
  }


  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int tests = scanner.nextInt();

    for (int testsItr = 0; testsItr < tests; testsItr++) {
      SinglyLinkedList llist = new SinglyLinkedList();

      int llistCount = scanner.nextInt();

      for (int i = 0; i < llistCount; i++) {
        int llistItem = scanner.nextInt();

        llist.insertNode(llistItem);
      }

      int position = scanner.nextInt();
      int result = getNode(llist.head, position);


    }

    scanner.close();
  }
}
