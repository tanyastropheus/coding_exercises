package arrays_and_list;

import java.util.Scanner;


/**
 * Learning Notes:
 * 1. Using System.arraycopy() to copy arrays
 * However - may be easier to use Arrays.copyOfRange(original, startIdx, endIdx) which returns the copied new array
 * 2. Using the Scanner class to read user input
 * 3. Practiced implementing bubble sort
 */
public class ArrayChallenge {

  private static Scanner scanner = new Scanner(System.in);



  /**
   * TasK:
   * reads array from input
   * return a new sorted array
   * prints out the new sorted array
   */
  public static void main(String[] args) {
    int[] inputArray = getIntegers(8);
    int[] sortedArray = sortArrayByBubbleSort(inputArray);
    System.out.println("Sorted Array: ");
    printArray(sortedArray);
  }

  private static int[] getIntegers(int number) {
    System.out.println("Please enter " + number + " of integer values: ");
    int[] values = new int[number];
    for (int i = 0; i < values.length; i++) {
      values[i] = scanner.nextInt();
    }
    return values;
  }

  private static void printArray(int[] array) {
    // input sanitation
    if (array != null) {
      // print array
      for (int i : array) {
        System.out.println(i);
      }
    }
  }

  private static int[] sortArrayByBubbleSort(int[] array) {
    if (array != null) {
      // create a copy of the array
      int[] sortedArray = new int[array.length];
      for (int i = 0; i < array.length; i++) {
        sortedArray[i] = array[i];
      }

      // can simply the above array copy by using System.arraycopy()
      int[] newArray = new int[array.length];
      System.arraycopy(array, 0, newArray, 0, array.length);

      // sort the new array
      for (int i = 0; i < sortedArray.length; i++) {
        for (int j = 0; j < sortedArray.length - 1; j++) {
          if (sortedArray[j] < sortedArray[j + 1]) {
            int temp = sortedArray[j];
            sortedArray[j] = sortedArray[j + 1];
            sortedArray[j + 1] = temp;
          }
        }
      }
      return sortedArray;
    } else {
      return null;
    }
  }


}
