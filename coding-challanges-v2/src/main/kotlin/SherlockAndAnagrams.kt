
fun main() {
    sherlockAndAnagrams("ifailuhkqq")
}

/*
*
* */
fun sherlockAndAnagrams(s: String): Int {

    val anagrams = mutableListOf<Pair<String, String>>()
    val anagramPairs = mutableMapOf<String, MutableList<String>>()
    for (i in s.indices) {
        for (j in i until s.length) {
            val substring = s.substring(i, j+1)
            println(substring) // fa, fai,
            val sortedSubstring = substring.toCharArray().sorted().joinToString("")
            println(sortedSubstring) // af, afi
            anagramPairs.getOrPut(sortedSubstring) {
                mutableListOf()
            }.add(substring)
            anagramPairs.forEach { (t, u) ->
                println("$t -> $u") // afi -> [ifa, fai]
            }
        }
    }

    for (sb in anagramPairs.values) {
        if (sb.size > 1) {
            for (i in sb.indices) {
                for (j in i + 1 until sb.size) {
                    anagrams.add(Pair(sb[i], sb[j]))
                }
            }
        }
    }

    anagrams.forEach {
        println(it)
    }

    return anagrams.size


}



