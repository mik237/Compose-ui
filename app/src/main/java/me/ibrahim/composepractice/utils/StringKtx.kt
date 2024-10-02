package me.ibrahim.composepractice.utils

import java.util.Locale

fun String.hex2Bytes(): ByteArray {
    var inputString: String = this
    if (inputString.length < 2) {
        return ByteArray(0)
    }
    inputString = inputString.lowercase(Locale.ENGLISH)
    val resultSize = inputString.length / 2
    val result = ByteArray(resultSize)
    for (i in 0 until resultSize) {
        val tmp = inputString.substring(2 * i, 2 * i + 2)
        result[i] = (tmp.toInt(16) and 0xFF).toByte()
    }
    return result
}