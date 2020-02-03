package arrays_and_list;

import java.util.Scanner;


/**
 * Learning notes: implementing restart using while loop
 */
public class MinimalElementChallenge {

  private static Scanner scanner = new Scanner(System.in);

  /**
   * Task:
   * Find the minimal element in the user input array from the console consists of integers
   */
  public static void main(String[] args) {
    // read the count from console
    System.out.println("How many numbers would you like to enter? ");
    int count = scanner.nextInt();

    // when user did not enter a positive count
    while (count <= 0) {
      System.out.println("The count of numbers entered must not be zero or negative.");
      // restart
      System.out.println("How many numbers would you like to enter? ");
      count = scanner.nextInt();
    }
    int[] inputArray = readIntegers(count);
    try {
      int min = findMin(inputArray);
      System.out.println("The minimal element in the array is " + min);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private static int[] readIntegers(int count) {
    // reads user input numbers from console
    // the number of user input numbers is determined by count
    if (count <= 0) {
      return null;
    }
    int[] inputArray = new int[count];

    for (int i = 0; i < count; i++) {
      System.out.println("Enter a number: ");
      inputArray[i] = scanner.nextInt();
    }
    return inputArray;
  }

  private static int findMin(int[] array) throws Exception {
    // returns the minimal element in the array
    // return 0 if the array is null or empty
    if (array != null && array.length > 0) {
      if (array.length == 1) {
        return array[0];
      } else {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
          if (array[i] < min) {
            min = array[i];
          }
        }
        return min;
      }
    } else {
      throw new Exception("input array is null or empty");
    }
  }
}
