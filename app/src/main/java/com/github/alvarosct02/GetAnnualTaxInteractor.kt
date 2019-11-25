package com.github.alvarosct02

class GetAnnualTaxInteractor(uitValue: Double) {

    private val taxTiers = listOf(
        TaxTier(uitValue.times(7), 0),
        TaxTier(uitValue.times(5), 8),
        TaxTier(uitValue.times(15), 14),
        TaxTier(uitValue.times(15), 17),
        TaxTier(uitValue.times(10), 20),
        TaxTier(uitValue.times(1000), 30)
    )

    fun execute(totalIncome: Double): Double {

        var annualTax = 0.toDouble()
        var remainingIncome = totalIncome

        taxTiers.forEach { tier ->
            if (remainingIncome > tier.coverage) {
                annualTax += tier.coverage * tier.taxPercentage / 100
                remainingIncome -= tier.coverage
            } else {
                println("Tier: ${tier.taxPercentage}% -> remainingIncome: ${tier.coverage - remainingIncome} ")
                annualTax += remainingIncome * tier.taxPercentage / 100
                return annualTax
            }
        }
        return annualTax


    }

    data class TaxTier(val coverage: Double, val taxPercentage: Int)
}

