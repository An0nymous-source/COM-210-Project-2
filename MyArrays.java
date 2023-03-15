
import java.util.Arrays;
import java.util.Random;

public class MyArrays {
  public static void main(String[] args) {

    // Sorted arrays
    int[] smallSortedArray = generateSortedArray(10);
    int[] mediumSortedArray = generateSortedArray(100);
    int[] largeSortedArray = generateSortedArray(1000);



    // Unsorted arrays
    int[] smallUnsortedArray = generateUnsortedArray(10);
    int[] mediumUnsortedArray = generateUnsortedArray(10);
    int[] largeUnsortedArray = generateUnsortedArray(10);


    int numToSearch = 9;

    System.out.println("Array: " + Arrays.toString(smallSortedArray));
    System.out.println("The number "+ numToSearch + " is found at index " + fetchSorted(smallSortedArray, numToSearch));

    numToSearch = 2;
    System.out.println("Array: " + Arrays.toString(smallUnsortedArray));
    System.out.println("The number "+ numToSearch + " is found at index " + fetchSorted(smallUnsortedArray, numToSearch));
  }

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

  public static int fetchUnSorted(int[] myArray, int numToSearch) {
    return 1;
  }

  public static int[] generateSortedArray(int arrayLength){
    int[] myArray = new int[arrayLength];
    for (int i = 0; i < myArray.length; i++) {
      myArray[i] = i;
    }

    return myArray;
  }

  public static int[] generateUnsortedArray(int arrayLength){
    int[] myArray = new int[arrayLength];
    Random random = new Random();

    for (int i = 0; i < myArray.length; i++) {
      int randomInt = random.nextInt(arrayLength);
      if(!constraints(myArray, randomInt)){
        myArray[i] = random.nextInt(arrayLength);
      }
    }

    return myArray;
  }

  public static boolean constraints (int[] myArray, int num){
    for (int i = 0; i < myArray.length; i++) {
      if(myArray[i] == num){
        return true;
      }
    }
    return false;
  }

}
