package com.github.alvarosct02

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainTest {

    val UIT = 4200.0
    val SALARY = 3000.0
    val SALARY_2 = 3500.0

    @Test
    fun `test 2019 with extra`() {

        val incomeList = listOf(
            MonthlyIncome(Month.JANUARY, SALARY, 0.0, 0.0),
            MonthlyIncome(Month.FEBRUARY, SALARY, 0.0, 0.0),
            MonthlyIncome(Month.MARCH, SALARY, 0.0, 0.0),
            MonthlyIncome(Month.APRIL, SALARY, 0.0, 0.0),
            MonthlyIncome(Month.MAY, SALARY, 0.0, 0.0),
            MonthlyIncome(Month.JUNE, SALARY_2, 0.0, 0.0),
            MonthlyIncome(Month.JULY, SALARY_2, SALARY_2, 0.0),
            MonthlyIncome(Month.AUGUST, SALARY_2, 0.0, 0.0),
            MonthlyIncome(Month.SEPTEMBER, SALARY_2, 0.0, 0.0),
            MonthlyIncome(Month.OCTOBER, SALARY_2, 0.0, 0.0),
            MonthlyIncome(Month.NOVEMBER, SALARY_2, 0.0, 0.0),
            MonthlyIncome(Month.DECEMBER, SALARY_2, SALARY_2, 0.0)
        )

        var accIncome = 0.toDouble()
        var retentionList = mutableListOf<Double>()
        incomeList.forEach {
            val estimateAnnualIncome = EstimateAnnualIncomeInteractor(accIncome, it).execute()
            accIncome += it.total
            val annualTax = GetAnnualTaxInteractor(UIT).execute(estimateAnnualIncome)
            val monthlyTax = GetMonthlyRetentionInteractor(annualTax, retentionList, it.month).execute()
            retentionList.add(monthlyTax)
            println("Retencion [${it.month}]: $monthlyTax")
        }


        Assert.assertEquals(retentionList.sum(), GetAnnualTaxInteractor(UIT).execute(incomeList.sumByDouble { it.total }).setScale(2), 0.01)

    }

    @Test
    fun `test 2020`() {

        val incomeList = listOf(
            MonthlyIncome(Month.JANUARY, SALARY_2, 0.0, 0.0),
            MonthlyIncome(Month.FEBRUARY, SALARY_2,0.0, 0.0 ),
            MonthlyIncome(Month.MARCH, SALARY_2,0.0, 0.0 ),
            MonthlyIncome(Month.APRIL, SALARY_2,0.0, 0.0),
            MonthlyIncome(Month.MAY, SALARY_2,0.0, 0.0 ),
            MonthlyIncome(Month.JUNE, SALARY_2,0.0, 0.0 ),
            MonthlyIncome(Month.JULY, SALARY_2,SALARY_2, 0.0 ),
            MonthlyIncome(Month.AUGUST, SALARY_2,0.0, 0.0 ),
            MonthlyIncome(Month.SEPTEMBER, SALARY_2,0.0, 0.0 ),
            MonthlyIncome(Month.OCTOBER, SALARY_2,0.0, 0.0 ),
            MonthlyIncome(Month.NOVEMBER, SALARY_2,0.0, 0.0),
            MonthlyIncome(Month.DECEMBER, SALARY_2,SALARY_2, 0.0)
        )

        var accIncome = 0.toDouble()
        var retentionList = mutableListOf<Double>()
        incomeList.forEach {
            val estimateAnnualIncome = EstimateAnnualIncomeInteractor(accIncome, it).execute()
            accIncome += it.total
            val annualTax = GetAnnualTaxInteractor(UIT).execute(estimateAnnualIncome)
            val monthlyTax = GetMonthlyRetentionInteractor(annualTax, retentionList, it.month).execute()
            retentionList.add(monthlyTax)
            println("Retencion [${it.month}]: $monthlyTax")
        }


        Assert.assertEquals(retentionList.sum(), GetAnnualTaxInteractor(UIT).execute(incomeList.sumByDouble { it.total }).setScale(2), 0.01)


    }

}
