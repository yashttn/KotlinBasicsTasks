package com.example.myapplication

import kotlin.math.pow

fun Int.square(): Int {
    return this * this
}

fun Double.power(p: Double): Double {
    return this.pow(p)
}

fun main() {
    println(5.square())
    println((5.0).power(3.0))
}