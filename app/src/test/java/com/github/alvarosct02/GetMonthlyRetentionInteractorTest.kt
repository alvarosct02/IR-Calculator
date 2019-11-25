package com.github.alvarosct02

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GetMonthlyRetentionInteractorTest {

    @Test
    fun `test december is not included on a january range of 3 months`() {
        assertEquals(GetMonthlyRetentionInteractor.MonthRange(Month.JANUARY, 3).includes(Month.DECEMBER),false)
    }

    @Test
    fun `test february is included on a january range of 3 months`() {
        assertEquals(GetMonthlyRetentionInteractor.MonthRange(Month.JANUARY, 3).includes(Month.FEBRUARY),true)
    }

    @Test
    fun `test march is included on a january range of 3 months`() {
        assertEquals(GetMonthlyRetentionInteractor.MonthRange(Month.JANUARY, 3).includes(Month.MARCH),true)
    }

    @Test
    fun `test april is not included on a january range of 3 months`() {
        assertEquals(GetMonthlyRetentionInteractor.MonthRange(Month.JANUARY, 3).includes(Month.MARCH),true)
    }

    @Test
    fun `test january is included on a january range of X months`() {
        assertEquals(GetMonthlyRetentionInteractor.MonthRange(Month.JANUARY, 3).includes(Month.JANUARY),true)
    }


    @Test
    fun `test january is not included on a april range of X months`() {
        assertEquals(GetMonthlyRetentionInteractor.MonthRange(Month.APRIL, 3).includes(Month.JANUARY),false)
    }


    @Test
    fun `test march is not included on a april range of X months`() {
        assertEquals(GetMonthlyRetentionInteractor.MonthRange(Month.APRIL, 3).includes(Month.MARCH),false)
    }


}
