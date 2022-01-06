package com.madbad.myapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
//    @DrawableRes
    val title: String,
    val poster: Int,
    val description: String
) : Parcelable
