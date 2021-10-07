import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


fun lonelyinteger(a: Array<Int>): Int {
    val l = a.toList()
    val m = mutableMapOf<Int, Boolean>()
    l.forEach {
        if (m.contains(it)){
            m[it] = false
        } else {
            m.put(it, true)
        }
    }
    val f = m.filterValues { it == true }.keys.first()
    return f

}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = lonelyinteger(a)

    println(result)
}
