class Heap {
  int[] arr;
  int size;

  Heap(int capacity) {
    this.arr = new int[capacity];
    this.size = 0;
  }

  public static void main(String[] args) {
    Heap heap = new Heap(10);
    heap.insert(10);
    heap.insert(5);
    heap.insert(15);
    heap.insert(20);
    // heap.insert(30);
    // heap.insert(25);
    // heap.insert(35);
    // heap.insert(40);
    // heap.insert(50);
    // heap.insert(45);

    System.out.println("Heap: ");
    for (int i = 0; i < heap.size; i++) {
      System.out.print(heap.arr[i] + " ");
    }
    System.out.println();

    heap.remove();

    System.out.println("Heap after removing the root: ");
    for (int i = 0; i < heap.size; i++) {
      System.out.print(heap.arr[i] + " ");
    }
    System.out.println();

  }

  void swap(int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  void insert(int value) {
    arr[size] = value;
    swim(size);
    size++;
  }

  void remove() {
    arr[0] = arr[size - 1];
    size--;
    sink(0);
  }

  void swim(int index) {
    int parent = (index - 1) / 2;
    while (index > 0 && arr[index] > arr[parent]) {
      swap(index, parent);
      index = parent;
      parent = (index - 1) / 2;
    }
  }

  void sink(int index) {
    while (2 * index + 1 < size) {
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      int largest = left;
      if (right < size && arr[right] > arr[left]) {
        largest = right;
      }
      if (arr[index] >= arr[largest]) {
        break;
      }
      swap(index, largest);
      index = largest;
    }

  }
}
