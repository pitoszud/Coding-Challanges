fun main(args: Array<String>) {

}

fun compress(str: String){
    val compressed = StringBuilder()
    var conc = 0
    for (i in str.indices) {
        conc++
        println(conc)
        if (i + 1 >= str.length || str[i] != str[i+1]){
            compressed.append(str[i])
            compressed.append(conc)
            conc = 0
        }
    }
}
