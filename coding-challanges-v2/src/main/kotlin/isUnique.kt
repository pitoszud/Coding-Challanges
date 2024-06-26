fun isUniqueString(str: String): Boolean {
    if (str.length > 128) return false

    val charSet = BooleanArray(128)
    for (element in str) {
        val charVal = element.code
        println("check $charVal")
        if (charSet[charVal]) {
            println("already exists - return false")
            return false
        }
        println("update " + charSet[charVal] + " to true")
        charSet[charVal] = true
    }
    return true
}






fun main(args: Array<String>){
    val unique = "unique"
    println(isUniqueString(unique))
}