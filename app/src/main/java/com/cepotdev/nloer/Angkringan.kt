package com.cepotdev.nloer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Angkringan (
    val name: String?,
    val description: String?,
    val photo: Int,
): Parcelable