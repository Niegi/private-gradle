package algorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingAlgorithmsComparison {

    public static void main(String[] args) {
        int[] testArr = generateRandomIntArray(30000);

        Instant start = Instant.now();
        bubbleSort(testArr);
        Instant finish = Instant.now();
        long bubbleSortTimeElapsed = Duration.between(start, finish).toNanos();

        start = Instant.now();
        selectionSort(testArr);
        finish = Instant.now();
        long selectionSortTimeElapsed = Duration.between(start, finish).toNanos();

        start = Instant.now();
        insertionSort(testArr);
        finish = Instant.now();
        long insertionSortTimeElapsed = Duration.between(start, finish).toNanos();

        start = Instant.now();
        mergeSort(testArr, 0, testArr.length - 1);
        finish = Instant.now();
        long mergeSortTimeElapsed = Duration.between(start, finish).toNanos();

        start = Instant.now();
        quickSort(testArr, 0, testArr.length - 1);
        finish = Instant.now();
        long quickSortTimeElapsed = Duration.between(start, finish).toNanos();

        start = Instant.now();
        heapSort(testArr);
        finish = Instant.now();
        long heapSortTimeElapsed = Duration.between(start, finish).toNanos();

//        start = Instant.now();
//        countingSort(testArr);
//        finish = Instant.now();
//        long countingSortTimeElapsed = Duration.between(start, finish).toNanos();

        start = Instant.now();
        radixSort(testArr);
        finish = Instant.now();
        long radixSortTimeElapsed = Duration.between(start, finish).toNanos();

        System.out.println("Sorting times of each algorithm:\n" +
                "Bubble Sort: " + bubbleSortTimeElapsed + "\n" +
                "Selection Sort: " + selectionSortTimeElapsed + "\n" +
                "Insertion Sort: " + insertionSortTimeElapsed + "\n" +
                "Merge Sort: " + mergeSortTimeElapsed + "\n" +
                "Quick Sort: " + quickSortTimeElapsed + "\n" +
                "Heap Sort: " + heapSortTimeElapsed + "\n" +
//                "Counting Sort: " + countingSortTimeElapsed + "\n" +
                "Radix Sort: " + radixSortTimeElapsed
        );
    }

    private static int[] generateRandomIntArray(int size) {
        int upperBound = 1;
        int lowerBound = Integer.MAX_VALUE;
        int range = (upperBound - lowerBound) + 1;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * range) + lowerBound;
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // If no swaps occurred, the list is already sorted.
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap (start from the last non-leaf node)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one and heapify the reduced heap
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root (maximum element) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap (excluding the sorted elements)
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Find the largest element among the root and its children
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest element is not the root, swap and heapify the affected sub-tree
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void countingSort(int[] arr) {
        int n = arr.length;

        // Find the range of input values
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create the count array and initialize it
        int range = max - min + 1;
        int[] count = new int[range];

        // Count occurrences of each element
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Compute cumulative sum in the count array
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array
        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy the sorted array back to the original array
        System.arraycopy(sorted, 0, arr, 0, n);
    }

    public static void radixSort(int[] arr) {
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();

        // Perform counting sort for each digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, n, exp);
        }
    }

    public static void countingSortByDigit(int[] arr, int n, int exp) {
        int range = 10; // There are 10 possible digits (0 to 9)
        int[] output = new int[n];
        int[] count = new int[range];

        // Count occurrences of each digit in count array
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Compute cumulative sum in the count array
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array in reverse order to maintain stability
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n == 0) return;

        // Step 1: Create an array of empty buckets
        List<List<Float>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Step 2: Distribute elements into buckets based on value range
        for (float value : arr) {
            int bucketIndex = (int) (n * value);
            buckets.get(bucketIndex).add(value);
        }

        // Step 3: Sort each non-empty bucket
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket); // Using Collections.sort() (insertion sort)
            // Alternatively, you can use another sorting algorithm here
            // For example, recursively call bucketSort(bucket.toArray(new Float[0]));
        }

        // Step 4: Concatenate the sorted elements
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float value : bucket) {
                arr[index++] = value;
            }
        }
    }
}
