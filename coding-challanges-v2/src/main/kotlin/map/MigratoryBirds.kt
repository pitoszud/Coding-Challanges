package map

fun main() {
    val arr1 = arrayOf(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)
    println("Migratory Birds: ${migratoryBirds(arr1)}")

    val arr2 = arrayOf(1, 4, 4, 4, 5, 3)
    println("Migratory Birds Optimized: ${migratoryBirds(arr2)}")
}

/*
* Given an array of bird sightings where every element represents a bird type id,
* determine the id of the most frequently sighted type.
* If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
* */
fun migratoryBirds(arr: Array<Int>): Int {
    val birdMap = mutableMapOf<Int, Int>()
    arr.forEach { b ->
        val mostFrequent = birdMap[b]
        if (mostFrequent != null) {
            birdMap[b] = mostFrequent + 1
        } else {
            birdMap[b] = 1
        }
    }
    birdMap.forEach { (t, u) ->
        println("Key: $t, Value: $u")
    }
    /*
    * Key: 1, Value: 1
      Key: 4, Value: 3
      Key: 5, Value: 2
      Key: 3, Value: 3
    * */
    var maxCount = 0
    var minId = Int.MAX_VALUE

    for ((key, value) in birdMap) {
        if (value > maxCount || (value == maxCount && key < minId)) {
            maxCount = value
            minId = key
        }
    }

    return if (minId == Int.MAX_VALUE) -1 else minId

}

fun findMostFrequentBird(birdMap: Map<Int, Int>): Int {
    return birdMap.maxWithOrNull(compareBy({ it.value }, { -it.key }))?.key ?: -1
}

fun migratoryBirdsOptimized(arr: Array<Int>): Int {
    val birdMap = mutableMapOf<Int, Int>()
    arr.forEach { b ->
        birdMap[b] = birdMap.getOrDefault(b, 0) + 1
    }
    return birdMap.maxWithOrNull(compareBy({ it.value }, { -it.key }))?.key ?: -1
}

fun migratoryBirds2(arr: Array<Int>): Int {
    val sorted = arr.sortedArray()
    var ans = sorted[0]
    var maxOccur = 1
    var counter = 0

    for (i in sorted.indices) {
        counter = if (i > 0 && sorted[i] == sorted[i - 1]) counter + 1 else 1
        if (counter > maxOccur) {
            ans = sorted[i]
            maxOccur = counter
        }
    }

    return ans
}




