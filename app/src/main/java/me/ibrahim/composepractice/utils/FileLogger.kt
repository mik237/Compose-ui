package me.ibrahim.composepractice.utils

import kotlin.experimental.xor


open class FileLogger {
    open fun logError(error: String) {
        println("logError1: $error")
    }
}

class MyFileLogger : FileLogger() {
    override fun logError(error: String) {

    }


    private fun deObfuscateKey(pair: Pair<String, String>): String {
        if (pair.first.length != pair.second.length) {
            return ""
        }
        val byteArray1: ByteArray = pair.first.hex2Bytes()
        val byteArray2: ByteArray = pair.second.hex2Bytes()
        val result = ByteArray(byteArray1.size)
        for (i in byteArray1.indices) {
            result[i] = (byteArray1[i] xor byteArray2[i])
        }
        return String(result)
    }
}

class ScopeFunctions {
    private var name: String? = null

    fun tryLet() {
        name = "name"
        val n = name?.let {
            it.trim('e')
        } ?: "non-null"
        println("let: Name: $n")
    }

    fun tryAlso() {
        name = "name"
        val n = name?.also {
            it.trim('e')
        }
        println("also: Name: $n")
    }

    fun tryApply() {
        name = "name"
        name = name?.apply {
            name = name.plus("-sd")
        }
        println("apply: Name: $name")

        val person = Person("", 0)
        person.apply {
            name = "ibrahim"
            age = 30
        }
        println("apply: Person: $person")

    }

    fun tryWith() {}
    fun tryRun() {}
}


fun main() {
    val logger = MyFileLogger()
    logger.logError("This is error")
//    val scopeFunctions = ScopeFunctions()
//    scopeFunctions.tryLet()
//    scopeFunctions.tryAlso()
//    scopeFunctions.tryApply()
}


data class Person(var name: String, var age: Int)