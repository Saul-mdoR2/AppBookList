package com.example.appbooklist.presentation.bookList

import android.view.View

interface BookClickListener {
    fun onClick(vista: View, index: Int)
}