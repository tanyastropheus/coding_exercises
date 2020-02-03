package arrays_and_list;

import java.util.Arrays;


public class ReverseArray {

  /**
   * Task:
   * Reverse an array of integers in place
   */
  public static void main(String[] args) {
    int[] array = {5, 8, 0, -2, 1};
    System.out.println("Original Array: " + Arrays.toString(array));
    int[] reversedArray = reverse(array);
    System.out.println("Reversed Array: " + Arrays.toString(reversedArray));
  }

  private static int[] reverse(int[] array) {
    // modifies the array in place
    if (array != null) {
      int len = array.length;

      // swap elements in mirroring position
      // only need to iterate through half of the array, else will "unreverse" the array
      for (int i = 0; i < len / 2; i++) {
        if (array[i] != array[len - 1 - i]) {
          int temp = array[i];
          array[i] = array[len - 1 - i];
          array[len - 1 - i] = temp;
        }
      }
      return array;
    }
    return null;
  }
}
