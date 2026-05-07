package string

fun main() {
    maxDistinctSubstringLengthInSessions("abcabcbb")
}

/*
*
Walkthrough
For "abcabcbb":

Window: [a] → OK → length = 1
Window: [ab] → OK → length = 2
Window: [abc] → OK → length = 3
Window: [abca] → duplicate 'a'
    → move left until 'a' removed
Window becomes [bca]
* */

fun maxDistinctSubstringLengthInSessions(sessionString: String): Int {
    val sessions = sessionString.split("*")
    var maxLength = 0

    for (session in sessions) {
        val set = mutableSetOf<Char>()
        var left = 0

        for (right in session.indices) {
            while (session[right] in set) {
                set.remove(session[left])
                left++
            }

            set.add(session[right])
            maxLength = maxOf(maxLength, right - left + 1)
        }
    }

    return maxLength
}

// abcabcbb
fun maxDistinctSubstringLengthInSessionsBruteForce(sessionString: String): Int {
    val sessions = sessionString.split("*")
    var maxLength = 0
    for (session in sessions) {
        var longestUnique = ""
        for (i in session.indices) {
            for (j in i + 1..session.length) {
                val ss = session.substring(i, j)
                if (ss.toSet().size == ss.length && ss.length > longestUnique.length) {
                    longestUnique = ss
                }
            }
        }

        if (longestUnique.length > maxLength) {
            maxLength = longestUnique.length
        }
    }

    return maxLength
}


/*
* Process
* Events: 1000, 2000, 3000, 4000, 9000
Current event: 9000
Window size: 5000

Valid window:

[4000 → 9000]

Now check:

1000 ❌ too old → remove
2000 ❌ too old → remove
3000 ❌ too old → remove
4000 ✅ keep
* */

fun maxEventsInWindow(events: List<Event>, windowSizeMs: Long): Int {
    var max = 0
    val arrEvents = ArrayDeque<Event>()

    for (event in events) {
        arrEvents.addLast(event)
        while(arrEvents.first().timestamp < event.timestamp - windowSizeMs) {
            arrEvents.removeFirst()
        }
        max = maxOf(max, arrEvents.size)
    }

    return max
}


data class Event(val userId: Long, val timestamp: Long)
