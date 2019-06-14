package de.mustafagercek.library

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import androidx.annotation.ColorInt


fun isColorDark(color: Int): Boolean {
    val darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
    return darkness >= 0.5
}
