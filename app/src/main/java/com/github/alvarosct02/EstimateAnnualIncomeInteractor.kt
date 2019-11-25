package com.github.alvarosct02


class EstimateAnnualIncomeInteractor(
    private val previousIncome: Double,
    private val income: MonthlyIncome
) {
    private val gratificationMonths = listOf(Month.JULY, Month.DECEMBER)

    fun execute(): Double {

        var estimateIncome = income.total

        val monthsToEndOfYear = Month.DECEMBER.value - income.month.value
        estimateIncome += income.salary * monthsToEndOfYear

        gratificationMonths.forEach {
            if (income.month.value < it.value) {
                estimateIncome += income.salary
            }
        }

        estimateIncome += previousIncome

        return estimateIncome

    }
}

