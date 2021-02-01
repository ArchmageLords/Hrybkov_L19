package com.example.hrybkov_l19

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val name: String,
    val year: String,
    val country: String,
    val description: String,
    val rate: Double,
    val image: String
) : Parcelable