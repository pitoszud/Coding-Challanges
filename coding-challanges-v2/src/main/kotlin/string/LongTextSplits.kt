package string

import kotlin.collections.get
import kotlin.compareTo

fun main() {
    val r: List<String> = htmlDataSplitTextTest.htmlSimpleDataSplit()
    r.forEach {
        println(it.length)
    }
    println("---- Original ----")
    for (string in r) {
        println(string)
    }
    println("-------------------------------------------")
    val cl = combineAdjacentText(r, 400)
    cl.forEach { c ->
        println(c)
        println("--- end ---")
    }
}

fun combineAdjacentText(r: List<String>, maxChar: Int): List<String> {
    val updated = mutableListOf<String>()
    var i = 0
    while (i < r.size) {
        val sb = StringBuilder(r[i])
        var totalLength = r[i].length
        var j = i + 1
        while (j < r.size && totalLength + r[j].length < maxChar) {
            sb.append(r[j])
            totalLength += r[j].length
            j++
        }
        updated.add(sb.toString())
        i = j
    }
    return updated
}

fun String.htmlSimpleDataSplit(delimiter: String = "<br/><br/>"): List<String> {
    val parts = this.split(delimiter)

    return parts.mapIndexed { index, part ->
        if (index < parts.size - 1) {
            part + delimiter
        } else {
            part
        }
    }
}



private val htmlDataSplitTextTest = """
    <b>Part on with other <b>html<b/> tags</b><br/><br/>Some text in part two with links <a href="https://www.example.co.uk/contact-us">www.example.co.uk/contact-us/help-us-improve</a> for example<br/><br/>Some more text in part three with only one break <br/>, which should be omitted in the algorithm.<br/><br/>Another part with bullet points<ul><li>Bullet point A;</li><li>Bullet point B</li></ul><br/>Text under bullet point.<br/><br/>Final part.
""".trimIndent()