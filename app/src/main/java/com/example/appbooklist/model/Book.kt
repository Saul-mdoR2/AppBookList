package com.example.appbooklist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Book(
    var bookId: String = UUID.randomUUID().toString(),
    var cover: Int,
    var title: String,
    var author: String,
    var synopsis: String
): Parcelable
