package Week7.Survey;

import java.util.Random;

public class CreatTest {

  public static void print(int[] arr){
    for (int j : arr) {
      System.out.println(j);
    }
  }

  public static void RandomTestCase(int[] arr) {
    Random random = new Random(38103);
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt();
    }
    //print(arr);
  }
}
