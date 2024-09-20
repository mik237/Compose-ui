package me.ibrahim.composepractice.testing_practice

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import me.ibrahim.composepractice.R
import me.ibrahim.composepractice.testing_practice.utils.StringComparer

import org.junit.After
import org.junit.Before
import org.junit.Test

class StringComparerTest {

    private var stringComparer: StringComparer? = null

    @Before
    fun setUp() {
        stringComparer = StringComparer()
    }

    @After
    fun tearDown() {
        stringComparer = null
    }

    @Test
    fun stringResourceSameAsInputString_returns_True() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = stringComparer?.isEqual(context, R.string.str_compare, "StringToCompare")
        assertThat(result).isTrue()
    }


    @Test
    fun stringResourceDifferentAsInputString_returns_False() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = stringComparer?.isEqual(context, R.string.str_compare, "DifferentString")
        assertThat(result).isFalse()
    }
}