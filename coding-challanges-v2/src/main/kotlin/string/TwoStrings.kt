package string

fun main() {
    val r = twoStrings("hello", "world")
    println(r)
}

fun twoStrings(s1: String, s2: String): String {
    val ssHashSet = s1.toHashSet()
    val slHashSet = s2.toHashSet()
    return if (ssHashSet.intersect(slHashSet).isNotEmpty()) "YES" else "NO"
}


fun twoStrings2(s1: String, s2: String): String {
    val s1Substrings = mutableListOf<String>()
    val s2Substrings = mutableListOf<String>()

    for (i in s1.indices) {
        val ss = s1.substring(i, s1.length)
        if (ss.isNotEmpty()) {
            s1Substrings.add(ss)
        }
    }

    for (i in s2.indices) {
        val ss = s2.substring(i, s2.length)
        if (ss.isNotEmpty()) {
            s2Substrings.add(ss)
        }

    }

    val combine = s1Substrings.intersect(s2Substrings.toSet())

    return if (combine.isNotEmpty()) "YES" else "NO"

}




