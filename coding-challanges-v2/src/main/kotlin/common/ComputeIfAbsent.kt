package common

fun main() {
    val l1 = mutableListOf(
        StarUser(1, "A"),
        StarUser(2, "B"),
    )
    val m = mapOp(l1)
}

fun mapOp(elements: List<StarUser>): Map<Int, List<StarUser>> {
    val bm = mutableMapOf<Int, List<StarUser>>()
    elements.forEach { el ->
        val values = bm[el.id]?.toMutableList()
        if (values != null) {
            val elementIndex = values.indexOfFirst { it.id == el.id }
            if (elementIndex != -1) {
                values[elementIndex] = el
            } else {
                values.add(el)
            }
        } else {
            bm[el.id] = listOf(el)
        }
    }
    return bm
}


fun mapOpOptimised(elements: List<StarUser>): Map<Int, List<StarUser>> {
    val bm = mutableMapOf<Int, MutableList<StarUser>>()
    elements.forEach { el ->
        val values = bm.computeIfAbsent(el.id) { mutableListOf() }
        val elementIndex = values.indexOfFirst { it.id == el.id }
        if (elementIndex != -1) {
            values[elementIndex] = el
        } else {
            values.add(el)
        }
    }
    return bm
}

data class StarUser(
    val id: Int,
    val name: String
)