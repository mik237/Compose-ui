package me.ibrahim.composepractice.testing_practice.utils

object RegisterationUtil {

    private val existingUsers = listOf("Peter", "Carl", "Phillipe")

    /**
     * the input is not valid if..
     * ...the username/password is empty
     * ...the password & confirmPassword does not match
     * ...the username already exists.
     * ...the password does not contain at least one capital letter & one special character
     */
    fun validateRegisterationInput(
        username: String, password: String, confirmPassword: String
    ): Boolean {

        if ((username.isEmpty() || password.isEmpty()) || (existingUsers.contains(username)) || (password != confirmPassword)) return false

        val passwordContainsUpperCase = password.any { it.isUpperCase() }
        val passwordContainSpecialChar = password.any { it in "!@#$%&*" }

        return !(passwordContainSpecialChar.not() || passwordContainsUpperCase.not())
    }
}