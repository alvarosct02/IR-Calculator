package com.github.alvarosct02

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class EstimateAnnualIncomeInteractorTest {

    val BRUTE_SALARY = 5000.0

    @Test
    fun `test estimation on january`() {
        assertEquals(
            EstimateAnnualIncomeInteractor(
                0.0,
                MonthlyIncome(Month.JANUARY, BRUTE_SALARY)
            ).execute(), BRUTE_SALARY * 14, 0.01
        )
    }

    @Test
    fun `test estimation on december (new employee)`() {
        val grati = 500.0
        assertEquals(
            EstimateAnnualIncomeInteractor(
                0.0,
                MonthlyIncome(Month.DECEMBER, BRUTE_SALARY, gratification = grati)
            ).execute(), BRUTE_SALARY + grati, 0.01
        )
    }

    @Test
    fun `test estimation on december`() {
        val grati = 500.0
        val prevIncome = 40000.0
        assertEquals(
            EstimateAnnualIncomeInteractor(
                prevIncome,
                MonthlyIncome(Month.DECEMBER, BRUTE_SALARY, gratification = grati)
            ).execute(), prevIncome + grati + BRUTE_SALARY, 0.01
        )
    }

    @Test
    fun `test estimation on before two gratifications`() {
        val prevIncome = 40000.0
        assertEquals(
            EstimateAnnualIncomeInteractor(
                prevIncome,
                MonthlyIncome(Month.MARCH, BRUTE_SALARY)
            ).execute(), prevIncome + BRUTE_SALARY + BRUTE_SALARY * 9 + BRUTE_SALARY * 2, 0.01
        )
    }

}
