package Coursera.Week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private Node first;
  private Node last;
  private int size;

  private class Node {

    Item data;
    Node pre;
    Node next;
  }

  private class ListNode implements Iterator<Item> {

    private Node first;

    ListNode(Node first) {
      this.first = first;
    }

    @Override
    public boolean hasNext() {
      return first != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item item = first.data;
      first = first.next;
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  public Deque() {
    first = null;
    last = null;
    size = 0;
  }

  // is the deque empty?
  public boolean isEmpty() {
    return last == null;
  }

  // return the number of items on the deque
  public int size() {
    return size;
  }

  // add the item to the front
  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node node = new Node();
    node.data = item;
    if (size == 0) {
      first = node;
      last = node;
    } else {
      node.next = first;
      first.pre = node;
      first = node;
      node.pre = null;
    }
    size++;
  }

  // add the item to the back
  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node node = new Node();
    node.data = item;
    if (size == 0) {
      first = node;
      last = node;
    } else {
      last.next = node;
      node.pre = last;
      last = node;
      node.next = null;
    }
    size++;
  }

  // remove and return the item from the front
  public Item removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    Item returnI = first.data;
    if (size == 1) {
      first = null;
      last = null;
    } else {
      first = first.next;
      first.pre = null;
    }
    size--;
    return returnI;
  }

  // remove and return the item from the back
  public Item removeLast() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    Item returnI = last.data;
    if (size == 1) {
      first = null;
      last = null;
    } else {
      last = last.pre;
      last.next = null;
    }
    size--;
    return returnI;
  }

  // return an iterator over items in order from front to back
  public Iterator<Item> iterator() {
    return new ListNode(first) {
    };
  }

  // unit testing (required)
  public static void main(String[] args) {

  }
}
