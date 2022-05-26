package com.android.unittesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result  = RegistrationUtil.validateRegistrationInput(
            username = "",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result  = RegistrationUtil.validateRegistrationInput(
            username = "Tom",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result  = RegistrationUtil.validateRegistrationInput(
            username = "Carl",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password empty returns false`() {
        val result  = RegistrationUtil.validateRegistrationInput(
            username = "Ahmed",
            password = "",
            confirmPassword = ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result  = RegistrationUtil.validateRegistrationInput(
            username = "Ahmed",
            password = "123",
            confirmPassword = "124"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password returns false`() {
        val result  = RegistrationUtil.validateRegistrationInput(
            username = "Mohamed",
            password = "abcde1",
            confirmPassword = "abcde1"
        )
        assertThat(result).isFalse()
    }
}