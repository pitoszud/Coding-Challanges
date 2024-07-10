package string

import kotlin.math.abs

fun main() {
    val deletions1 = makeAnagram("cde", "dcf")
    println("deletions: $deletions1")
    val deletions2 = makeAnagram("cde", "abc")
    println("deletions: $deletions2")
    val deletions3 = makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke")
    println("deletions: $deletions3")
    val deletion4 = makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke")
    println(deletion4)
}

/*
* cde -> cde
* dcf -> cdf
* 0, 1, 2 =>
*
* cde -> cde
* abc -> abc
* 0 => 3 - 0
*
* */

fun makeAnagram(a: String, b: String): Int {
    val charMapA = mutableMapOf<Char, Int>()
    val charMapB = mutableMapOf<Char, Int>()

    for (i in a.indices) {
        charMapA[a[i]] = charMapA.getOrPut(a[i]) { 0 } + 1
        //charMapA[a[i]] = charMapA.getOrDefault(a[i], 0) + 1
    }

    for (i in b.indices) {
        charMapB[b[i]] = charMapB.getOrPut(b[i]) { 0 } + 1
        //charMapB[b[i]] = charMapB.getOrDefault(b[i], 0) + 1
    }

    var deletions = 0

    charMapA.forEach { (t, u) ->
         deletions += abs(u - (charMapB[t] ?: 0))
    }

    charMapB.forEach { (t, u) ->
        if (t !in charMapA) {
            deletions += u
        }
    }

    return deletions
}
