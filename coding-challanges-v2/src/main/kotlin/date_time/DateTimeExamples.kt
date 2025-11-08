package date_time

import kotlinx.datetime.*
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

fun main() {
    timeBetweenTwoDatesKotlinB()
}


@OptIn(ExperimentalTime::class)
fun longToLocalDateTime() {
    val startLong = 1762634228000L
    val startInstant = Instant.fromEpochMilliseconds(startLong)
    val startLocalDateTime: LocalDateTime = startInstant.toLocalDateTime(TimeZone.currentSystemDefault())
}


@OptIn(ExperimentalTime::class)
fun timeBetweenTwoDatesKotlinB() {
    val startSeconds = 1762634228L
    val startInstant = Instant.fromEpochSeconds(startSeconds)

    val now = Clock.System.now()
    val dateTimePeriod = startInstant.periodUntil(now, TimeZone.currentSystemDefault())
    val monthsDiff = startInstant.until(now, DateTimeUnit.MONTH, TimeZone.currentSystemDefault())

    val days = dateTimePeriod.days
    val months = dateTimePeriod.months
    val years = dateTimePeriod.years
    val hours = dateTimePeriod.hours
    val minutes = dateTimePeriod.minutes

    println("Difference is $years years, $months months, $days days, $hours hours, $minutes minutes")
}

/*
* The recommended way to use a LocalDateTime is to treat it as a representation of an Instant,
* perform all the required arithmetic on Instant values,
* and only convert to LocalDateTime when a human-readable representation is needed.
* */
@OptIn(ExperimentalTime::class)
fun addPeriodToInstant() {
    // Arithmetic on Instant
    val now = Clock.System.now()
    val systemTZ = TimeZone.currentSystemDefault()
    val nextMonth = now.plus(2, DateTimeUnit.MONTH, systemTZ)
    val nextYearAndMonth = now.plus(DateTimePeriod(years = 1, months = 1), systemTZ)

    // to LocalDateTime
    val nextMonthLocalDateTime = nextMonth.toLocalDateTime(systemTZ)
}