class MergeSort {

  public static void main(String[] args) {
    int[] arr = { 5, 4, 3, 2, 1 };
    arr = mergeSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  static int[] mergeSort(int[] arr) {

    if (arr.length <= 1) {
      return arr;
    }

    int[] left = new int[arr.length / 2];
    int[] right = new int[arr.length - left.length];

    for (int i = 0; i < left.length; i++) {
      left[i] = arr[i];
    }
    for (int i = 0; i < right.length; i++) {
      right[i] = arr[i + left.length];
    }

    left = mergeSort(left);
    right = mergeSort(right);

    int i = 0, j = 0, k = 0;
    while (left.length != j && right.length != k) {
      if (left[j] < right[k]) {
        arr[i] = left[j];
        j++;
      } else {
        arr[i] = right[k];
        k++;
      }
      i++;
    }

    while (left.length != j) {
      arr[i] = left[j];
      j++;
      i++;
    }

    while (right.length != k) {
      arr[i] = right[k];
      k++;
      i++;
    }

    return arr;

  }
}