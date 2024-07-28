# Types of Sorting Algorithms

## Space Used

### In-place Sorting
- Sorting algorithms that use constant extra space are called in-place sorting algorithms.
- In-place sorting algorithms are preferred as they do not require any extra space and sorting is done in the same array.
- Examples of in-place sorting algorithms are:
    - **Bubble Sort**
    - **Selection Sort**
    - **Insertion Sort**
    - **Heap Sort**
    - **Quick Sort**

### Out-of-place Sorting
- Sorting algorithms that require extra space proportional to the size of the input data are called out-of-place sorting algorithms.
- Examples of out-of-place sorting algorithms are:
    - **Merge Sort**
    - **Counting Sort**
    - **Radix Sort**
    - **Bucket Sort**

## Time Complexity

### O(n^2) Sorting Algorithms
- **Bubble Sort**
- **Selection Sort**
- **Insertion Sort**
- **Quick Sort** (worst case)

### O(n log n) Sorting Algorithms
- **Merge Sort**
- **Heap Sort**
- **Quick Sort** (average case and best case)
- **Timsort** (used in Java's Arrays.sort() for non-primitive types)

### O(n) Sorting Algorithms
- **Counting Sort**
- **Radix Sort**
- **Bucket Sort**

## Stability
- A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input array to be sorted.
- Stability is important when we have key-value pairs with duplicate keys.
- Examples of stable sorting algorithms are:
    - **Bubble Sort**
    - **Insertion Sort**
    - **Merge Sort**
    - **Counting Sort**
    - **Radix Sort**
    - **Bucket Sort**
    - **Timsort**

## Additional Notes

### Unstable Sorting Algorithms
- Some sorting algorithms are not stable by default but can be made stable with modifications.
- Examples of unstable sorting algorithms are:
    - **Selection Sort**
    - **Heap Sort**
    - **Quick Sort** (basic implementation)

### Adaptive Sorting Algorithms
- Adaptive sorting algorithms take advantage of existing order in their input.
- Examples of adaptive sorting algorithms are:
    - **Insertion Sort** (efficient for nearly sorted data)
    - **Timsort** (designed to perform well on many kinds of real-world data)

### Comparison-based vs. Non-comparison-based Sorting Algorithms
- **Comparison-based Sorting Algorithms**: These algorithms sort data by comparing elements.
    - Examples: Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, Heap Sort, Quick Sort, Timsort.

- **Non-comparison-based Sorting Algorithms**: These algorithms sort data without directly comparing elements.
    - Examples: Counting Sort, Radix Sort, Bucket Sort.

---

## Interview Questions and Answers

1. What is the difference between Merge Sort and Quick Sort?
Answer:
   1. Merge Sort divides the array into two halves, sorts the two halves independently, and then merges the two sorted halves. 
   2. Quick Sort picks an element as pivot and partitions the given array around the picked pivot. The key process in Quick Sort is partition(). 
   3. The worst-case time complexity of Quick Sort is O(n^2) {when the pivot is always the smallest or the largest element} whereas the worst-case time complexity of Merge Sort is O(n log n).
   4. Merge Sort is stable and Quick Sort is not stable.
   5. Merge Sort requires O(n) extra space whereas Quick Sort requires O(log n) extra space.
   6. Merge Sort is more efficient and works faster than Quick Sort in case of larger input sizes.
   7. Quick Sort is more efficient and works faster than Merge Sort in case of smaller input sizes.
   8. Merge Sort is more suitable for linked lists, and Quick Sort is more suitable for arrays.