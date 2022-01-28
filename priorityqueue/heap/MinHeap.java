package DSA.priorityqueue.heap;

public class MinHeap {
  int arr[];
  int size;
  int capacity;

  public MinHeap(int c) {
    arr = new int[c];
    size = 0;
    capacity = c;
  }

  public int left(int i) {
    return (2 * i + 1);
  }

  public int right(int i) {
    return (2 * i + 2);
  }

  public int parent(int i) {
    return (i - 1) / 2;
  }

  /**
   * @desc Insert element in a heap
   * 
   * COMPLEXITY 
   * Time: O(log(size of heap)) / O(h) 
   * Space: O(1)
   * 
   * Some constant work + traversing across the height of the tree
   */
  public void insert(int x) {
    if (size == capacity) {
      return;
    }

    // Increase heap size
    size++;

    // Insert the element at last index
    arr[size - 1] = x;

    // Keep swapping the newly inserted element up, with the root 
    //  If it is smaller than root
    //  And until we reach the root 
    for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; i--) {
      swap(arr[i], arr[parent(i)]);
      // Getting parent index as we move level wise
      i = parent(i);
    }
  }

  /**
   * @desc Min Heapify - fixing heap structure

   * COMPLEXITY
   * Time: O(log(size of heap)) / O(h)
   * Space: O(h)
   * 
   * We are travelling along the height of the tree
   * (n ∝ height of tree) nodes will be present in the memory at a time due to recursion
   */
  public void minHeapify(int i) {
    // We start from i=0
    int smallest = i;
    
    // Get index of left and right elements
    int lt = left(i), rt = right(i);

    // Check if left exists && and is smaller than current element
    if (lt < size && arr[lt] < arr[i]) {
      smallest = lt;
    }

    // Check if right exists && and is greater than current element
    if (rt < size && arr[rt] < arr[smallest]) {
      smallest = rt;
    }

    // Root is not the smallest value so again call minHeapify()
    if (smallest != i) {
      // Swap root with current element
      swap(arr[i], arr[smallest]);
      // Call min heapify till the heap structure is fixed
      minHeapify(smallest);
    }
  }

  /**
   * @desc Extract min value
   * 
   * COMPLEXITY
   * Time: O(log(size of heap)) / O(h)
   * Space: O(h)
   * 
   * Constant work + travelling along the height of the tree
   */
  public int extractMin() {
    // No elements in the heap
    if (size == 0) {
      return Integer.MAX_VALUE;
    }

    // Only 1 element in the heap
    if (size == 1) {
      size--;
      return arr[0];
    }

    // Swap last element with the root
    swap(arr[0], arr[size - 1]);

    // Reduce heap size
    size--;

    // Call the heapify function for i=0
    // NOTE: Heapify works good if the ROOT is disturbed
    minHeapify(0);

    // The last element is the one we want
    //    for which we did swapping earlier
    return arr[size];
  }

  /**
   * @desc Decrease key value
   * 
   * COMPLEXITY
   * Time: O(h)
   * Space: O(1)
   * 
   * Constant work + travelling along the height of the tree
   */
  public void decreaseKey(int i, int x) {
    // Replace value at index i with new value - x
    arr[i] = x;

    // Do swapping if the parent is greater than child
    //  and till we haven't reached the root
    while (i != 0 && arr[parent(i)] > arr[i]) {
      swap(arr[i], arr[parent(i)]);
      i = parent(i);
    }
  }

  /**
   * @desc Delete key
   * 
   * COMPLEXITY
   * Time: O(h)
   * Space: O(h)
   */
  public void deleteKey(int i, int x) {
    // Replace element to be deleted with -Infinity
    //    -Infinity is the smallest value, it will be moved to the top
    decreaseKey(i, x);
    // Once -Infinity reached root, call extractMin()
    //    It will place -Infinity at last index and will be removed
    extractMin();
  }

  /**
   * @desc Build Min Heap
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(h)
   */
  public void builMinHeap() {
    // Start from the parent of the last element in the heap
    // Last element is present at (size-1)th index 
    // Index of parent element will be (size-1) - 1 / 2 =~ size-2/2
    for (int i = (size - 2) / 2; i >= 0; i--) {
      // Once we have the index, call minHeapify function for that index
      //    until we reach the top/root
      minHeapify(i);
    }
  }

  /* Heap Sort */
  public void heapSort(int arr[], int size) {
    /* NOTE: For heap sort we use the max heap data structure */

    // Build a max heap - as we need the top element to be largest
    buildMaxHeap(arr, size);

    // Once the max heap is constructed, swap root element with last element
    // This way largest element goes to the last index and is removed 
    // Again call heapify() so that the largest element again goes to the top/root
    for (int i=size-1; i>=1; i--) {
      swap(arr[0], arr[i]);
      maxHeapify(arr, i, 0);
    }
  }

  /* Max Heapify */
  public void maxHeapify(int arr[], int size, int i) {    
    int lt = left(i), rt = right(i);
    int largest = i;

    if (lt < size && arr[lt] > arr[largest]) {
      largest = lt;
    }

    if (rt < size && arr[rt] > arr[largest]) {
      largest = rt;
    }

    if (largest != i) {
      swap(arr[largest], arr[i]);
      maxHeapify(arr, size, i);
    }
  } 

  /* Build Max Heap */
  public void buildMaxHeap(int arr[], int size) {
    for (int i=(size-2)/2; i>=0; i--) {
      maxHeapify(arr, size, i);
    }
  }

  /* Swap elements */
  public void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
  }
}