import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Create multiple unsorted and sorted arrays of different sizes
 * + Small 10 elements
 * + Medium 100
 * + Large 1000
 * Code and run the fetch, insert, and delete algorithms on each noting their
 * execution
 * time. You can see this metric in Java
 * 
 * Author: Armando Escobar Castillo, Cassandra Davies
 * Date: 16 March 2023
 */
public class MyArrays {

  public static void main(String[] args) {

    // Sorted arrays
    testSortedArrayAlgorithms(10);
    testSortedArrayAlgorithms(100);
    testSortedArrayAlgorithms(1000);
    testSortedArrayAlgorithms(10000);

    // Unsorted arrays
    testUnsortedArrayAlgorithms(10);
    testUnsortedArrayAlgorithms(100);
    testUnsortedArrayAlgorithms(1000);
    testUnsortedArrayAlgorithms(10000);

  }

  public static void testSortedArrayAlgorithms(int arraySize) {
    int[] myArray = generateSortedArray(arraySize);

    // Pick the last element in the array to test the worst case scenario for the
    // fetch, insert, and delete algorithms
    int testNumber = myArray[myArray.length - 1];

    if (arraySize < 11) {
      // Test sorted arrays
      System.out.println("Small Sorted Array: " + Arrays.toString(myArray));

      System.out.println("Index of number " + testNumber + " in the array: " + fetchSorted(myArray, testNumber));

      myArray = insertSorted(myArray, testNumber + 1);

      System.out.println("Insert number " + (testNumber + 1) + " into the array" + Arrays.toString(myArray));

      myArray = deleteSorted(myArray, testNumber + 1);

      System.out.println("Delete number " + (testNumber + 1) + " from the array" + Arrays.toString(myArray));
      System.out.println("\n");
    }

    // Test sorted arrays
    System.out.println("\nSorted array size: " + arraySize);
    System.out.println("Index of number " + testNumber + " in the array: " + fetchSorted(myArray, testNumber));

    myArray = insertSorted(myArray, testNumber + 1);

    System.out.println("Insert number " + (testNumber + 1) + " into the array" + myArray);

    myArray = deleteSorted(myArray, testNumber + 1);

    System.out.println("Delete number " + (testNumber + 1) + " from the array" + myArray);

    System.out.println("\n");
  }

  public static void testUnsortedArrayAlgorithms(int arraySize) {
    int[] myArray = generateUnsortedArray(arraySize);

    // Pick the last element in the array to test the worst case scenario for the
    // fetch, insert, and delete algorithms
    int testNumber = myArray[myArray.length - 1];

    System.out.println("\n===========================================================================\n");

    if (arraySize < 11) {
      // Test Unsorted arrays
      System.out.println("Small Unsorted Array: " + Arrays.toString(myArray));

      System.out.println("Index of number " + testNumber + " in the array: " + fetchUnsorted(myArray, testNumber));

      fetchSorted(myArray, testNumber);
      myArray = insertUnsorted(myArray, testNumber + 1);

      System.out.println("Insert number " + (testNumber + 1) + " into the array" + Arrays.toString(myArray));

      myArray = deleteUnsorted(myArray, testNumber + 1);

      System.out.println("Delete number " + (testNumber + 1) + " from the array" + Arrays.toString(myArray));
      System.out.println("\n");
    }

    // Test Unsorted arrays
    System.out.println("\nUnsorted array size: " + arraySize);
    System.out.println("Index of number " + testNumber + " in the array: " + fetchUnsorted(myArray, testNumber));

    fetchSorted(myArray, testNumber);
    myArray = insertUnsorted(myArray, testNumber + 1);

    System.out.println("Insert number " + (testNumber + 1) + " into the array" + myArray);

    myArray = deleteUnsorted(myArray, testNumber + 1);

    System.out.println("Delete number " + (testNumber + 1) + " from the array" + myArray);

    System.out.println("\n");
  }

  /**
   * This method fetches the index of the given number in the sorted array.
   * 
   * @param myArray     The sorted array to search in.
   * @param numToSearch The number to search for.
   * @return The index of the number in the array, or -1 if not found.
   */
  public static int fetchSorted(int[] myArray, int numToSearch) {

    // Initialize the low and high indices of the array
    int low = 0;
    int high = myArray.length - 1;

    // Initialize a counter variable to keep track of the number of iterations
    int count = 0;

    // Loop until the low index is greater than the high index
    while (low <= high) {

      // Increment the counter variable by 1 in every iteration.
      count++;

      // Calculate the midpoint of the array
      int midPoint = low + (high - low) / 2;

      // If the midpoint element is equal to the number being searched for, return the
      // index of the midpoint
      if (myArray[midPoint] == numToSearch) {
        System.out.println("---Number of iterations in fetch algorithm: " + count);
        return midPoint;

        // If the midpoint element is less than the number being searched for, set the
        // low index to the midpoint + 1
      } else if (myArray[midPoint] < numToSearch) {
        low = midPoint + 1;

        // If the midpoint element is greater than the number being searched for, set
        // the high index to the midpoint - 1
      } else {
        high = midPoint - 1;
      }
    }

    return -1;
  }

  /**
   * This method inserts a new element into a sorted array.
   * 
   * @param myArray     The array where we want to insert the new element.
   * @param numToInsert The new element we want to insert in the array.
   * @return A new array containing the new element.
   */
  public static int[] insertSorted(int[] myArray, int numToInsert) {
    // Create a new array with one more element than the original array
    int[] newArray = new int[myArray.length + 1];

    // Initialize a counter variable to keep track of the number of iterations
    int count = 0;

    int index = 0;

    // Find the index where the new element should be inserted
    int low = 0;
    int high = myArray.length - 1;

    // Loop until the low index is greater than the high index
    while (low <= high) {

      // Increment the counter variable by 1 in every iteration.
      count++;

      // Calculate the midpoint of the array
      int midPoint = low + (high - low) / 2;

      // If the midpoint element is equal to the number being searched for, return the
      // index of the midpoint
      if (myArray[midPoint] == numToInsert) {
        System.out.println("---Number of iterations in fetch algorithm: " + count);
        index = midPoint;

        // If the midpoint element is less than the number being searched for, set the
        // low index to the midpoint + 1
      } else if (myArray[midPoint] < numToInsert) {
        count++;
        low = midPoint + 1;

        // If the midpoint element is greater than the number being searched for, set
        // the high index to the midpoint - 1
      } else {
        count++;
        high = midPoint - 1;
      }
    }

    for (int i = 0; i < myArray.length; i++) {
      if (numToInsert >= myArray[i]) {
        index = i + 1;
        count++;
      } else {
        break;
      }
    }

    // Copy the elements from the original array up to the insertion point
    for (int i = 0; i < index; i++) {
      count++;
      newArray[i] = myArray[i];
    }

    // Insert the new element at the insertion point
    newArray[index] = numToInsert;
    count++;

    // Copy the remaining elements from the original array
    for (int i = index + 1; i < newArray.length; i++) {
      count++;
      newArray[i] = myArray[i];
    }

    System.out.println("---Number of iterations in insert algorithm: " + count);
    // Return the new array
    return newArray;
  }

  public static int[] deleteSorted(int[] myArray, int numToDelete) {
    int[] newArray = new int[myArray.length - 1];

    // Iterations counter
    int count = 0;

    // Find the index where the element to be deleted is.
    int index = fetchSorted(myArray, numToDelete);

    if (index < 0) {
      // Element not found in array
      return myArray;
    }

    // Copy the elements from the original array up to the deletion point
    for (int i = 0; i < index; i++) {
      newArray[i] = myArray[i];
      count++;
    }

    // Copy the remaining elements from the original array
    for (int i = index; i < myArray.length - 1; i++) {
      newArray[i] = myArray[i + 1];
      count++;
    }

    System.out.println("---Number of iterations in delete algorithm: " + count);

    // Return the new array;
    return newArray;
  }

  /**
   * This method fetches the index of the given number in the unsorted array.
   * 
   * @param myArray     The unsorted array to search in.
   * @param numToSearch The number to search for.
   * @return The index of the number in the array, or -1 if not found.
   */
  public static int fetchUnsorted(int[] myArray, int numToSearch) {

    int count = 0;

    for (int i = 0; i < myArray.length; i++) {

      if (myArray[i] == numToSearch) {
        count++;
        System.out.println("---Number of iterations in fetch algorithm: " + count);
        return i;
      }
      count++;
    }

    System.out.println("---Number of iterations in fetch algorithm: " + count);
    return -1;
  }

  /**
   * This method inserts a new element into the an unsorted array
   * 
   * @param myArray     The array where the element will be inserted.
   * @param numToInsert The element to be inserted into the array.
   * @return A new array containing the new element.
   */
  public static int[] insertUnsorted(int[] myArray, int numToInsert) {
    int[] newArray = new int[myArray.length + 1];

    int count = 0;

    for (int i = 0; i < myArray.length; i++) {

      newArray[i] = myArray[i];
    }

    newArray[newArray.length - 1] = numToInsert;
    count++;
    System.out.println("---Number of iterations in insert algorithm: " + count);
    return newArray;

  }

  /**
   * This method deletes an element from an unsorted array.
   * 
   * @param myArray     The array where we want to insert the new element.
   * @param numToInsert The new element we want to insert in the array.
   * @return A new array without the deleted element.
   */
  public static int[] deleteUnsorted(int[] myArray, int numToDelete) {
    int[] newArray = new int[myArray.length - 1];

    int count = 0;

    int index = fetchUnsorted(myArray, numToDelete);

    if (index < 0) {
      index = -(index + 1);
    }

    for (int i = 0; i < index; i++) {
      count++;
      newArray[i] = myArray[i];
    }

    for (int i = index; i < myArray.length; i++) {
      count++;
      newArray[i - 1] = myArray[i];
    }

    System.out.println("---Number of iterations in delete algorithm: " + count);
    return newArray;
  }

  /**
   * This method generates a sorted array of the given length.
   * 
   * @param arrayLength The length of the array to generate.
   * @return The sorted array.
   */
  public static int[] generateSortedArray(int arrayLength) {
    int[] myArray = new int[arrayLength];
    Random random = new Random();
    int ranInt;
    int num = 0;
    for (int i = 0; i < myArray.length; i++) {
      ranInt = random.nextInt(2);

      if (ranInt == 1) {
        myArray[i] = num + ranInt;
        num++;
      }
      myArray[i] = num;
      num++;
    }

    return myArray;
  }

  /**
   * This method generates an unsorted array of the given length with no repeating
   * numbers.
   * 
   * @param arrayLength The length of the array to generate.
   * @return The unsorted array.
   */
  public static int[] generateUnsortedArray(int arrayLength) {
    int[] myArray = new int[arrayLength];
    Random random = new Random();
    Set<Integer> usedNumbers = new HashSet<>();

    for (int i = 0; i < myArray.length; i++) {
      int ranInt = random.nextInt(arrayLength);
      while (usedNumbers.contains(ranInt)) {
        ranInt = random.nextInt(arrayLength);
      }
      usedNumbers.add(ranInt);
      myArray[i] = ranInt;
    }

    return myArray;
  }
}
