package Week7.Survey;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

public class Main {

  public static void main(String[] args) {
    In in = new In("E:\\GitHub\\2021I_OOP\\src\\Week7\\Survey\\4Kints.txt");
    //int[] a = in.readAllInts();
    int[] a = new int[100000005];
    int n = a.length;
    CreatTest.RandomTestCase(a);
      long start = System.currentTimeMillis();
//    //InsertionSort.sort(a,a.length);
//    //MergeSort.sort(a,0,n-1);
      QuickSort.sort(a,0,n-1);
      long end = System.currentTimeMillis();
      //CreatTest.print(a);
      System.out.println(end-start);

  }
}
