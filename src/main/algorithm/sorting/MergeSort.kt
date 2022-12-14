package algorithm.sorting

/**
 * Invented in 1945 by John von Neumann, merge sort is an efficient algorithm using the divide and conquer approach
 * which is to divide a big problem into smaller problems and solve them. Conceptually, a merge sort works as follows:
 * 1) Divide the unsorted list into n sub-lists, each containing 1 element (a list of 1 element is considered sorted).
 * 2) Repeatedly merge sub-lists to produce new sorted sub-lists until there is only 1 sublist remaining.
 *
 * Divide, Conquer and Combine
 * Divide - Partition array into 2 sub-arrays S1 and S2 with n / 2 element each
 * Conquer - Sort sublist S1 and S2
 * Combine - Merge sorted sublist S1 and S2 into a unique sorted group.
 * */

@ComparisonSort
@StableSort
class MergeSort: AbstractSortStrategy() {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        val aux = arr.clone()
        sort(arr, aux, 0, arr.size - 1)
    }

    private fun <T : Comparable<T>> sort(arr: Array<T>, aux: Array<T>, lo: Int, hi: Int) {
        if(hi <= lo) return
        val mid = (lo + hi) / 2
        sort(arr, aux, lo, mid)
        sort(arr, aux, lo, mid)
        merge(arr, aux, lo, mid, hi)
    }

    private fun <T : Comparable<T>> merge(arr: Array<T>, aux: Array<T>, lo: Int, mid: Int, hi: Int) {
        System.arraycopy(arr, lo, aux, lo, hi - lo + 1)
        var i = lo
        var j = mid + 1
        for (k in lo .. hi) {
            when {
                i > mid -> arr[k] = aux[j++]
                j > hi -> arr[k] = aux[i++]
                aux[j] < aux[i] -> arr[k] = aux[j++]
                else -> arr[k] = aux[i++]
            }

        }
    }
}