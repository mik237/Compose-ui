package me.ibrahim.composepractice.testing_practice.utils

import android.content.Context

class StringComparer {

    fun isEqual(context: Context, resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}