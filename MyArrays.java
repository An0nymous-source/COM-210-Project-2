
import java.util.Arrays;
import java.util.Random;

/**
 * Create multiple unsorted and sorted arrays of different sizes
 * o Small – 10 elements
 * o Medium – 100
 * o Large 1000
 * Code and run the fetch, insert, and delete algorithms on each noting their execution
 * time. You can see this metric in Java
 * 
 * Author: Armando Escobar Castillo, Cassandra Davies
 * Date: 16 March 2023
 */
public class MyArrays {
  public static void main(String[] args) {

    // Sorted arrays
    int[] smallSortedArray = generateSortedArray(10);
    int[] mediumSortedArray = generateSortedArray(100);
    int[] largeSortedArray = generateSortedArray(1000);

    // Unsorted arrays
    int[] smallUnsortedArray = generateUnsortedArray(10);
    int[] mediumUnsortedArray = generateUnsortedArray(100);
    int[] largeUnsortedArray = generateUnsortedArray(1000);

    int numToSearch = 9;

    System.out.println("Sorted Array: " + Arrays.toString(smallSortedArray));
    System.out
        .println("The number " + numToSearch + " is found at index " + fetchSorted(smallSortedArray, numToSearch));

    numToSearch = 3;
    System.out.println("\n\nUnsorted Array: " + Arrays.toString(smallUnsortedArray));
    System.out
        .println("The number " + numToSearch + " is found at index " + fetchUnsorted(smallUnsortedArray, numToSearch));

  }

  /**
   * This method fetches the index of the given number in the sorted array.
   * 
   * @param myArray     The sorted array to search in.
   * @param numToSearch The number to search for.
   * @return The index of the number in the array, or -1 if not found.
   */
  public static int fetchSorted(int[] myArray, int numToSearch) {

    int low = 0;
    int high = myArray.length - 1;

    int counter = 0;
    while (low <= high) {
      counter++;
      int midPoint = low + (high - low) / 2;
      if (myArray[midPoint] == numToSearch) {
        System.out.println("Number of iterations: " + counter);
        return midPoint;
      } else if (myArray[midPoint] < numToSearch) {
        low = midPoint + 1;
      } else {
        high = midPoint - 1;
      }
    }

    System.out.println("Number of iterations: " + counter);
    return -1;
  }

  /**
   * This method fetches the index of the given number in the unsorted array.
   * 
   * @param myArray     The unsorted array to search in.
   * @param numToSearch The number to search for.
   * @return The index of the number in the array, or -1 if not found.
   */
  public static int fetchUnsorted(int[] myArray, int numToSearch) {
    for (int i = 0; i < myArray.length; i++) {
      if (myArray[i] == numToSearch) {
        return i;
      }
    }
    return -1;
  }

  /**
   * This method generates a sorted array of the given length.
   * 
   * @param arrayLength The length of the array to generate.
   * @return The sorted array.
   */
  public static int[] generateSortedArray(int arrayLength) {
    int[] myArray = new int[arrayLength];
    for (int i = 0; i < myArray.length; i++) {
      myArray[i] = i;
    }

    return myArray;
  }

  /**
   * This method generates an unsorted array of the given length.
   * 
   * @param arrayLength The length of the array to generate.
   * @return The unsorted array.
   */
  public static int[] generateUnsortedArray(int arrayLength) {
    int[] myArray = new int[arrayLength];
    Random random = new Random();

    for (int i = 0; i < myArray.length; i++) {
      myArray[i] = random.nextInt(arrayLength);
    }
    return myArray;
  }

}
