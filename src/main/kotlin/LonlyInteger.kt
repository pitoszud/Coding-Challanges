import kotlin.collections.*


fun lonelyinteger(a: Array<Int>): Int {
    val l = a.toList()
    val m = mutableMapOf<Int, Boolean>()
    l.forEach {
        if (m.contains(it)){
            m[it] = false
        } else {
            m[it] = true
        }
    }
    val f = m.filterValues { it }.keys.first()
    return f

}

fun main(args: Array<String>) {
    val n = readln().trim().toInt()

    val a = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = lonelyinteger(a)

    println(result)
}
