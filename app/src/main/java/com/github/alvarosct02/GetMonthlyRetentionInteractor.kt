package com.github.alvarosct02


class GetMonthlyRetentionInteractor(
    private val estimatedAnnualTax: Double,
    private val retentionsMade: List<Double>,
    private val month: Month
) {

    private val monthRanges = listOf(
        MonthRange(Month.JANUARY, 3),
        MonthRange(Month.APRIL, 1),
        MonthRange(Month.MAY, 3),
        MonthRange(Month.AUGUST, 1),
        MonthRange(Month.SEPTEMBER, 3),
        MonthRange(Month.DECEMBER, 1)
    )

    fun execute(): Double {
        monthRanges.forEach {
            if (it.includes(month)) {
                val endOfPrevRange = it.start.value - 1
                val previousRetentions = retentionsMade.take(endOfPrevRange)
                val monthsLeft = Month.DECEMBER.value - endOfPrevRange
                return ((estimatedAnnualTax - previousRetentions.sum()) / monthsLeft).setScale(2)
            }
        }
        return 0.toDouble()
    }

    data class MonthRange(val start: Month, val period: Int) {
        fun includes(month: Month) =
            (start.value <= month.value) && (month.value < start.value + period)
    }

}

