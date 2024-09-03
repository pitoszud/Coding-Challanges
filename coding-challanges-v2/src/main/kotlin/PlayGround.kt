import java.util.*

fun main() {

}



fun searchSuggestions(repository: List<String>, customerQuery: String): List<List<String>> {
    val sortedRepository = repository.sorted().map { it.lowercase(Locale.getDefault()) }
    val result = mutableListOf<List<String>>()
    for (i in 1..customerQuery.length) {
        val query = customerQuery.substring(0, i)
        val tempWords = mutableListOf<String>()
        for (word in sortedRepository) {
            if (word.startsWith(query) && tempWords.size < 3) {
                tempWords.add(word)
            }
            if (tempWords.size == 3) {
                break
            }
        }
    }
    return result
}