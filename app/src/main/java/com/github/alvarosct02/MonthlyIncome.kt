package com.github.alvarosct02

data class MonthlyIncome(
    val month: Month,
    val salary: Double,
    val gratification: Double = 0.toDouble(),
    val extra: Double = 0.toDouble()
) {
    val total= salary + gratification + extra
}