package com.example.marsphotos.network

import com.example.marsphotos.ui.screens.MarsUiState
import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType


interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos():List<MarsPhoto>
}