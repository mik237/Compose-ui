package me.ibrahim.composepractice.utils

import com.google.common.truth.Truth.assertThat
import me.ibrahim.composepractice.testing_practice.utils.RegisterationUtil
import org.junit.Test


class RegisterationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegisterationUtil.validateRegisterationInput(
            username = "", password = "pass", confirmPassword = "pass"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegisterationUtil.validateRegisterationInput(
            username = "username", password = "", confirmPassword = ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `valid username, password & confirmPassword should return true`() {
        val result = RegisterationUtil.validateRegisterationInput(
            username = "username", password = "passA@", confirmPassword = "passA@"
        )

        assertThat(result).isTrue()
    }

    @Test
    fun `password & confirmPassword does not match returns false`() {
        val result = RegisterationUtil.validateRegisterationInput("username", "pass1", "pass2")
        assertThat(result).isFalse()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegisterationUtil.validateRegisterationInput("Peter", "pass1", "pass2")
        assertThat(result).isFalse()
    }

    @Test
    fun `password not containing atleast one capital letter & one special character returns false`() {
        val result = RegisterationUtil.validateRegisterationInput("Peter", "pass1", "pass2")
        assertThat(result).isFalse()
    }

}