package com.github.alvarosct02

import java.math.RoundingMode

fun Double.setScale(scale:Int) = this.toBigDecimal().setScale(scale, RoundingMode.HALF_EVEN).toDouble()