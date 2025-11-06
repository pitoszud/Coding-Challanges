import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    countApplesAndOrangesConcurrent(7, 10, 4, 12, arrayOf(2, 3, -4), arrayOf(3, -2, -4))
}

/*
* s - starting point
* t - ending point
* a - apple tree
* b - orange tree
* */
fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
    var applesLanded = 0
    var orangesLanded = 0

    apples.forEach { apple ->
       if ((a + apple) in s .. t) {
           applesLanded += 1
       }
    }

    oranges.forEach { orange ->
        if ((b + orange) in s .. t) {
            orangesLanded += 1
        }
    }
    println(applesLanded)
    println(orangesLanded)

}


suspend fun countApplesAndOrangesConcurrent(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>) = coroutineScope {

    val appleDeferred = async {
        var applesLanded = 0
        apples.forEach { apple ->
            if ((a + apple) in s .. t) {
                applesLanded += 1
            }
        }
        applesLanded
    }


    val orangeDeferred = async {
        var orangesLanded = 0
        oranges.forEach { orange ->
            if ((b + orange) in s .. t) {
                orangesLanded += 1
            }
        }
        orangesLanded
    }

    println(appleDeferred.await())
    println(orangeDeferred.await())

}