package string

class Ghappy {
    /*
* We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true if all the g's in the given string are happy.
gHappy("xxggxx") → true
gHappy("xxgxx") → false
gHappy("xxggyygxx") → false
* */
    fun ghappy(str: String): Boolean {
        var happy = true

        for (i in str.indices) {
            if (str[i] == 'g') {
                if (str.length == 1) {
                    happy = false
                    break
                }

                if (i == 0 ) {
                    if (str[1] != 'g') {
                        happy = false
                        break
                    } else {
                        happy = true
                    }
                } else if (i == str.length-1) {
                    if (str[str.length-2] != 'g') {
                        happy = false
                        break
                    } else {
                        happy = true
                    }
                } else if (str[i+1] == 'g' || str[i-1] == 'g') {
                    happy = true
                } else {
                    happy = false
                    break
                }
            }
        }

        return happy
    }

    fun ghappyOptimized(str: String): Boolean {
        for (i in str.indices) {
            if (str[i] == 'g') {
                if ((i > 0 && str[i - 1] == 'g') || (i < str.length - 1 && str[i + 1] == 'g')) {
                    continue
                }
                return false
            }
        }
        return true
    }
}

