package sorts

/**
 * Merge Sort Working Process:
 *
 * Think of it as a recursive algorithm continuously splits the array in half until it cannot be further divided.
 * This means that if the array becomes empty or has only one element lef, the dividing will stop, i.e it is the best case to stop
 * the recursion. If the array has multiple elements, split the array into halves and recursively invoke the merge sort on each of the halves.
 * Finally, when both halves are sorted, the merge operation is applied. Merge operation is the process of taking two smaller sorted
 * arrays and combining them to eventually make a larger one.
 *
* */
class MergeSortTest: AbstractSortTest<MergeSort>(MergeSort())
