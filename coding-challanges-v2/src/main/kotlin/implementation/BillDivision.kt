package implementation

class BillDivision {

    /*
    * bill - an array of integers representing the cost of each item ordered.
    * k - an integer representing the index of the item that wasn't eaten.
    * b - the amount of money contributed to the bill.
    * */
    fun bonAppetit(bill: Array<Int>, k: Int, b: Int): String {
        val sharedItemsValue = bill
            .mapIndexed { index, i -> if (index != k) i else 0 }
            .sum() / 2.0
        return if (sharedItemsValue == b.toDouble()) "Bon Appetit" else
                (b.toDouble() - sharedItemsValue).toInt().toString()
    }
}