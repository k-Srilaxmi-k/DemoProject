package com.lbdemo.data

import com.lbdemo.domain.model.Details
import com.lbdemo.navigations.Screen
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("all")
    suspend fun fetchDetails(@Query("fields") fields: String): List<Details>

    companion object {
        private var apiService: ApiService? = null

        fun getInstance(forLogin: Boolean? = false): ApiService {
                if (apiService == null) {
                    apiService = Retrofit.Builder()
                        .baseUrl("https://restcountries.com/v3.1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}