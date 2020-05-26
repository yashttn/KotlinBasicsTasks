package com.example.myapplication

data class Person(val name: String, val age: Int)

val persons = listOf(
    Person("abc", 23),
    Person("def", 18),
    Person("ghi", 8),
    Person("jkl", 12),
    Person("mno", 32),
    Person("pqr", 45)
)

fun filterUse() {
    val voterIdAgeCondition: (Person) -> Boolean = { person: Person -> person.age >= 18 }
    val result = persons.filter(voterIdAgeCondition)
    print(result)
}

fun mapUse() {
    val result = persons.map { person -> "${person.name} is eligible to vote" }
    println(result)
}

fun reduceUse() {
    val list = listOf(1, 2, 3, 4, 5)
    val result = list.reduce { acc, it -> acc + it }
    println(result)
}

fun flattenUse() {
    val nestedList = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
    println(nestedList.flatten())
}

fun main() {
    filterUse()
    mapUse()
    reduceUse()
    flattenUse()
}