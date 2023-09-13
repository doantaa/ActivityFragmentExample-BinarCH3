package com.binar.activityfragmentexample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name : String,
    val job: String,
    val profileDesc: String,
    val profilPictUrl: String
) : Parcelable
