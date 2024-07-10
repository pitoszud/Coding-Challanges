package string

import java.util.*

fun main() {

    val ransomNote = RansomNote()

    val magazineText4 = "two times three is not four"
    val ransomNoteText4 = "two times two is four"
    println(ransomNote.checkMagazine(magazineText4.split(" ").toTypedArray(), ransomNoteText4.split(" ").toTypedArray()))

    val magazineText5 = "ive got a lovely bunch of coconuts"
    val ransomNoteText5 = "ive got some coconuts"
    println(ransomNote.checkMagazine(magazineText5.split(" ").toTypedArray(), ransomNoteText5.split(" ").toTypedArray()))

    val magazineText6 = "give me one grand today night"
    val ransomNoteText6 = "give one grand today"
    println(ransomNote.checkMagazine(magazineText6.split(" ").toTypedArray(), ransomNoteText6.split(" ").toTypedArray()))


}


class RansomNote {

    fun checkMagazine(magazine: Array<String>, note: Array<String>) {
        canReplicate(magazine, note)
    }
}


    fun canReplicate(magazine: Array<String>, note: Array<String>) {
        val magazineText = magazine.joinToString(" ")
        val ransomNoteText = note.joinToString(" ")
        var replicate = "No"
        val magazineWords = mutableMapOf<String, Int>()

        val magazineScanner = Scanner(magazineText).useDelimiter(" ")
        while (magazineScanner.hasNext()) {
            val word = magazineScanner.next()
            val occurrence = magazineWords.getOrDefault(word, 0)
            magazineWords[word] = occurrence + 1
        }

        val ransomNoteScanner = Scanner(ransomNoteText).useDelimiter(" ")
        while (ransomNoteScanner.hasNext()) {
            val word = ransomNoteScanner.next()
            if (magazineWords.containsKey(word)) {
                val occurrence = magazineWords.getOrDefault(word, 0)
                if (occurrence > 0) {
                    magazineWords[word] = occurrence - 1
                    replicate = "Yes"
                } else {
                    replicate = "No"
                    break
                }
            } else {
                replicate = "No"
                break
            }
        }


        print(replicate)
    }
