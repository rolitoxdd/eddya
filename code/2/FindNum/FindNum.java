import java.util.Scanner;

class FindNum {
  public static void main(String[] args) {
    int size;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array: ");
    size = sc.nextInt();
    int[] arr = new int[size];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Enter the number to be searched: ");
    int num = sc.nextInt();

    long startTime = System.nanoTime();
    System.out.println("Start time: " + startTime);
    boolean wasFound = FindNum.findInArray(arr, num);
    long endTime = System.nanoTime();
    System.out.println("End time: " + endTime);
    long timeElapsed = endTime - startTime;
    double timeInSeconds = timeElapsed / 1e9;
    System.out.println("Time taken to search: " + timeInSeconds + " seconds");

    if (wasFound) {
      System.out.println("Number " + num + " was found");
    } else {
      System.out.println("Number " + num + " not found");
    }

    sc.close();

  }

  public static boolean findInArray(int[] arr, int num) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        return true;
      }
    }
    return false;
  }
}