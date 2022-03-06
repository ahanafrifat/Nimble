package com.ahanaf.nimble.util

import android.util.Patterns
import android.widget.EditText
import androidx.core.util.PatternsCompat
import java.util.regex.Pattern

class Validator {
    companion object {
        private val PASSWORD_POLICY = """Password should be minimum 8 characters long,
            |should contain at least one capital letter,
            |at least one small letter,
            |at least one number and
            |at least one special character among ~!@#$%^&*()-_=+|[]{};:'\",<.>/?""".trimMargin()

        private const val NAME_VALIDATION_MSG = "Enter a valid name"
        private const val EMAIL_VALIDATION_MSG = "Enter a valid email address"
        private const val PHONE_VALIDATION_MSG = "Enter a valid phone number"

        fun isValidName(data: Any, updateUI: Boolean = true): Boolean {
            val str = getText(data)
            val valid = str.trim().length > 2

            if (updateUI) {
                val error: String? = if (valid) null else NAME_VALIDATION_MSG
                setError(data, error)
            }

            return valid
        }


        fun isValidEmail(data: Any, updateUI: Boolean = true): Boolean {
            val str = getText(data)
            val valid = PatternsCompat.EMAIL_ADDRESS.matcher(str).matches()

            if (updateUI) {
                val error: String? = if (valid) null else EMAIL_VALIDATION_MSG
                setError(data, error)
            }

            return valid
        }

        fun isValidPassword(data: Any, updateUI: Boolean = true): Boolean {
            val str = getText(data)
            var valid = true

            // Password policy check
            // Password should be minimum minimum 8 characters long
            if (str.length < 8) {
                valid = false
            }
            // Password should contain at least one number
            var exp = ".*[0-9].*"
            var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
            var matcher = pattern.matcher(str)
            if (!matcher.matches()) {
                valid = false
            }

            // Password should contain at least one capital letter
            exp = ".*[A-Z].*"
            pattern = Pattern.compile(exp)
            matcher = pattern.matcher(str)
            if (!matcher.matches()) {
                valid = false
            }

            // Password should contain at least one small letter
            exp = ".*[a-z].*"
            pattern = Pattern.compile(exp)
            matcher = pattern.matcher(str)
            if (!matcher.matches()) {
                valid = false
            }

            // Password should contain at least one special character
            // Allowed special characters : "~!@#$%^&*()-_=+|/,."';:{}[]<>?"
            exp = ".*[~!@#\$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*"
            pattern = Pattern.compile(exp)
            matcher = pattern.matcher(str)
            if (!matcher.matches()) {
                valid = false
            }

            // Set error if required
            if (updateUI) {
                val error: String? = if (valid) null else PASSWORD_POLICY
                setError(data, error)
            }

            return valid
        }

        private fun getText(data: Any): String {
            var str = ""

            if (data is EditText) {
                str = data.text.toString()
            } else if (data is String) {
                str = data
            }

            return str
        }

        private fun setError(data: Any, error: String?) {
            if (data is String) {
                return
            }

            if (data is EditText) {
                data.error = error
            }
        }
    }
}