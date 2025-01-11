package implementation

class DayOfProgrammer {

    fun dayOfProgrammer(year: Int): String {
        val isLeapYear = when {
            year < 1918 -> year % 4 == 0
            year > 1918 -> (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) // Gregorian calendar
            else -> false
        }

        val day = when {
            year == 1918 -> 26
            isLeapYear -> 12
            else -> 13
        }

        return "$day.09.$year"
    }
}


