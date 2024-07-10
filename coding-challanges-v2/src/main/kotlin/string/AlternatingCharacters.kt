package string

fun main() {
    val s1 = "AABAAB"
    println(alternatingCharacters(s1))
}

fun alternatingCharacters(s: String): Int {
    var deletions = 0

    for (i in s.indices) {
        if (i+1 == s.length) {
            break
        }

        if (s[i] == s[i+1]) {
            deletions++
        }
    }

    return deletions

}