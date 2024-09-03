
fun main() {
    val buckets = listOf(
        intArrayOf(4, 4, 4),
        intArrayOf(27, 7, 20),
        intArrayOf(6, 3, 2, 4, 1),
        intArrayOf(3, 2, 7, 7, 14, 5, 3, 4, 9, 2)
    )

    for (bucket in buckets) {
        for (k in 2..bucket.size) {
            if (canPartitionKSubsets(bucket, k)) {
                println("The bucket ${bucket.toList()} can be split into $k")
            }
        }
        println()
    }
}


fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
    val totalSum = nums.sum()
    if (totalSum % k != 0) return false

    val targetSum = totalSum / k
    val dp = IntArray(1 shl nums.size) { -1 }
    dp[0] = 0

    for (m in 0 until (1 shl nums.size)) {
        if (dp[m] == -1) continue

        for (i in nums.indices) {
            val nm = m or (1 shl i)
            if (nm != m && dp[m] + nums[i] <= targetSum) {
                dp[nm] = (dp[m] + nums[i]) % targetSum
            }
        }
    }

    return dp.last() == 0
}


