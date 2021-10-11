package com.codinginflow.imagesearchapp.data

import com.codinginflow.imagesearchapp.data.cloud.UnsplashService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsplashRepository @Inject constructor(private val service: UnsplashService) {
}