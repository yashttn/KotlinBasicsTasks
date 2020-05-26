package com.example.myapplication

fun letUse(s: String?) {
    s.let {
        if (it != null)
            println(it)
        else
            println("null")
    }
}

var i = 2
fun runUse(n: Int?) {
    i = n?.let {
        run {
            (n + i)
        }
    } ?: run {
        i
    }
    println(i)
    i = 2
}

fun alsoUse(n: Int?) {
    n?.also {
        (it + i)
    }
}

fun applyUse(n: Int?) {
    n?.apply {
        val v = n * 2
    }
}

fun withUse() {
    var v = 2
    with(v) {
        v = 3
        println("with block value v: $v")
    }
    println("with block value v: $v")
}

fun takeIfUse(s: String?) {
    println(s?.takeIf { !s.isNullOrEmpty() && s.length >= 5 } ?: "condition not satisfied")
}

fun takeUnlessUse(age: Int) {
    println("${age.takeUnless { age >= 18 } ?: "not"} eligible to vote")
}

fun main() {
    letUse("Hello")
    letUse(null)

    runUse(3)
    runUse(null)

    alsoUse(5)
    alsoUse(null)

    applyUse(3)
    applyUse(null)

    withUse()

    takeIfUse("Hello world")
    takeIfUse("hell")

    takeUnlessUse(13)
    takeUnlessUse(20)
}