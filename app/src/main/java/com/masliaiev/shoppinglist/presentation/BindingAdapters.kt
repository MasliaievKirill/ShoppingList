package com.masliaiev.shoppinglist.presentation

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorName")
fun bindErrorName(textInputLayout: TextInputLayout, error: Boolean) {
    if (error) {
        textInputLayout.error = "Error"
    } else {
        textInputLayout.error = null
    }
}

@BindingAdapter("errorCount")
fun bindErrorCount(textInputLayout: TextInputLayout, error: Boolean) {
    if (error) {
        textInputLayout.error = "Error"
    } else {
        textInputLayout.error = null
    }
}

