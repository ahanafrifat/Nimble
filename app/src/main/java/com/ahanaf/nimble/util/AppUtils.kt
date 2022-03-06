package com.ahanaf.nimble.util

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import com.ahanaf.nimble.R
import com.google.android.material.snackbar.Snackbar

object AppUtils {
    fun log(tag: String, msg: String) {
        Log.d(tag, msg)
    }

    fun message(
        view: View?,
        msg: String?,
        textColor: Int,
        backgroundColor: Int
    ) {
        try {
            if (view == null) return
            val snack = Snackbar.make(view, msg!!, Snackbar.LENGTH_SHORT)
            val snackBarView = snack.view
            snackBarView.setBackgroundColor(backgroundColor)
            val snackBarText = snackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackBarText.setTextColor(textColor)
            snack.show()
        } catch (e: Exception) {
            return
        }
    }

    fun message(
        view: View?,
        msg: String?
    ) {
        try {
            if (view == null) return
            val snack = Snackbar.make(view, msg!!, Snackbar.LENGTH_SHORT)
            val snackBarView = snack.view
            snackBarView.setBackgroundColor(Color.GRAY)
            val snackBarText = snackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackBarText.setTextColor(Color.WHITE)
            snack.show()
        } catch (e: Exception) {
            return
        }
    }
}