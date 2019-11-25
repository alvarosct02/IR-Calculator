package com.github.alvarosct02

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GetAnnualTaxInteractorTest {

    @Test
    fun `test average annual tax`() {
        assertEquals(GetAnnualTaxInteractor(4200.0).execute(70000.0), 4424.0, 0.01)
    }

    @Test
    fun `test no annual tax`() {
        assertEquals(GetAnnualTaxInteractor(4200.0).execute(10000.0), 0.0,0.01)
    }

    @Test
    fun `test high annual tax`() {
        assertEquals(GetAnnualTaxInteractor(4200.0).execute(700000.0), 174090.0,0.01)
    }
}
