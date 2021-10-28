package Coursera.Week2;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

  private Item[] arr;
  private int number;

  private class List implements Iterator<Item> {

    private final int[] queue;
    private int i;

    public List() {
      i = 0;
      queue = new int[number];
      for (int j = 0; j < number; j++) {
        queue[j] = j;
      }
      StdRandom.shuffle(queue);
    }

    @Override
    public boolean hasNext() {
      return i < number;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return arr[queue[i++]];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  // construct an empty randomized queue
  public RandomizedQueue() {
    arr = (Item[]) new Object[5];
    number = 0;
  }

  // is the randomized queue empty?
  public boolean isEmpty() {
    return number == 0;
  }

  // return the number of items on the randomized queue
  public int size() {
    return number;
  }

  // add the item
  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    if (number == arr.length) {
      resize(2 * number);
    }
    arr[number++] = item;
  }

  // remove and return a random item
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    if (number == arr.length / 4) {
      resize(arr.length / 2);
    }
    int radomI = StdRandom.uniform(number);
    Item data = arr[radomI];
    arr[radomI] = arr[--number];
    arr[number] = null;
    return data;
  }

  // return a random item (but do not remove it)
  public Item sample() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    if (number == arr.length / 4) {
      resize(arr.length / 2);
    }
    int radomI = StdRandom.uniform(number);
    return arr[radomI];
  }

  // return an independent iterator over items in random order
  public Iterator<Item> iterator() {
    return new List();
  }


  private void resize(int newsize) {
    Item[] temp = (Item[]) new Object[newsize];
    if (number >= 0)
      System.arraycopy(arr, 0, temp, 0, number);
    arr = temp;
  }

  // unit testing (required)
  public static void main(String[] args) {

  }
}

