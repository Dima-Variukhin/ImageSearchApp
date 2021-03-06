package com.codinginflow.imagesearchapp.data.cloud

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhotoCloud(
    val id: String,
    val description: String?,
    val urls: UnsplashPhotoUrlsCloud,
    val user: UnsplashUserCloud,
) : Parcelable {
    @Parcelize
    data class UnsplashPhotoUrlsCloud(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String,
    ) : Parcelable

    @Parcelize
    data class UnsplashUserCloud(
        val name: String,
        val username: String
    ) : Parcelable {
        val attributionUrl get() = "https://usplashcom/$username?utm_source=ImageSearchApp&utm_medium=referral"
    }
}