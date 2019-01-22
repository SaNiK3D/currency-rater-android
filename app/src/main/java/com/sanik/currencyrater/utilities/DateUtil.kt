package com.sanik.currencyrater.utilities

import java.util.*

fun today() = Calendar.getInstance()

fun yesterday() = Calendar.getInstance().apply {  add(Calendar.DAY_OF_YEAR, -1) }