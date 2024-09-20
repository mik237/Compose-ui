package me.ibrahim.composepractice.utils


import com.google.common.truth.Truth.assertThat
import me.ibrahim.composepractice.testing_practice.utils.HomeWorkUtil
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWorkUtilTest {

    @Test
    fun `fib should return 0 for n=0`() {
        assertThat(HomeWorkUtil.fib(0)).isEqualTo(0)
    }

    @Test
    fun `fib should return 1 for n=1`() {
        assertThat(HomeWorkUtil.fib(1)).isEqualTo(1)
    }

    @Test
    fun `fib should return 1 for n=2`() {
        assertThat(HomeWorkUtil.fib(2)).isEqualTo(1)
    }

    @Test
    fun `fib should return 2 for n=3`() {
        assertThat(HomeWorkUtil.fib(3)).isEqualTo(2)
    }

    @Test
    fun `fib should return 3 for n=4`() {
        "0,1,1,2,3,5,8,13,21,34,55"
        assertThat(HomeWorkUtil.fib(4)).isEqualTo(3)
    }

    @Test
    fun `fib should return 5 for n=5`() {
        assertThat(HomeWorkUtil.fib(5)).isEqualTo(5)
    }


    @Test
    fun `fib should return 8 for n=6`() {
        assertThat(HomeWorkUtil.fib(6)).isEqualTo(8)
    }

    @Test
    fun `fib should return 13 for n=7`() {
        assertThat(HomeWorkUtil.fib(7)).isEqualTo(13)
    }

    @Test
    fun `fib should return 21 for n=8`() {
        assertThat(HomeWorkUtil.fib(8)).isEqualTo(21)
    }

    @Test
    fun `fib should return 34 for n=9`() {
        assertThat(HomeWorkUtil.fib(9)).isEqualTo(34)
    }

    @Test
    fun `fib should return 55 for n=10`() {
        assertThat(HomeWorkUtil.fib(10)).isEqualTo(55)
    }






    @Test
    fun `checkBraces should return true for equal number of opening & closing braces ( )`() {
        assertTrue(HomeWorkUtil.checkBraces("(())"))
    }

    @Test
    fun `checkBraces should return true for string not containing braces ( or )`() {
        assertThat(HomeWorkUtil.checkBraces("")).isTrue()
    }

    @Test
    fun `checkBraces should return false for unequal number of braces`() {
        assertFalse(HomeWorkUtil.checkBraces("((()"))
    }

    @Test
    fun `checkBraces should return false for wrong order of braces`() {
        assertFalse(HomeWorkUtil.checkBraces(")("))
        assertFalse(HomeWorkUtil.checkBraces("(()))("))
    }

}