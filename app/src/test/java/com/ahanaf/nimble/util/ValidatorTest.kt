package com.ahanaf.nimble.util

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.google.common.truth.Truth.assertThat

@RunWith(JUnit4::class)
class ValidatorTest{


    @Test
    fun whenEmailIsValid(){
        val email = "johnSnow@gmail.com"
        val result = Validator.isValidEmail(email)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenEmailIsInValid(){
        val email = "johnSnowgmail.com"
        val result = Validator.isValidEmail(email)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun whenPasswordIsValid(){
        val email = "JohnSnow1234@~"
        val result = Validator.isValidEmail(email)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenPasswordIsInValid(){
        val email = "john5"
        val result = Validator.isValidEmail(email)
        assertThat(result).isEqualTo(false)
    }
}