
fun main() {
    val a = arrayOf(1, 1, 2, 2, 4, 4, 5, 5, 5)
    val longest = pickingNumbers(a)
    println(longest)
}

// 4 6 5 3 3 1 => 2
// 1 2 2 3 1 2 => 5


fun pickingNumbers(a: Array<Int>): Int {
    var longestSubarray = 0
    val longestSubarrayItems = mutableListOf<Int>()

    for (i in a.indices) {
        if (longestSubarrayItems.isEmpty()) {
            longestSubarrayItems.add(a[i])
        } else {
            if (a[i] == longestSubarrayItems.last() || (a[i]-1) == longestSubarrayItems.last()) {
                longestSubarrayItems.add(a[i])
            } else {
                if (longestSubarrayItems.size > longestSubarray) {
                    longestSubarray = longestSubarrayItems.size
                }
                longestSubarrayItems.clear()
                longestSubarrayItems.add(a[i])
            }
        }

    }

    if (longestSubarrayItems.size > longestSubarray) {
        longestSubarray = longestSubarrayItems.size
    }

    //println(longestSubarrayItems)
    return longestSubarray
}