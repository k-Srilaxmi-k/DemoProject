package com.lbdemo.data

import android.content.Context
import android.widget.Toast
import com.lbdemo.domain.model.Response
import com.lbdemo.domain.model.Details
import com.lbdemo.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteRepositoryImpl @Inject constructor() : Repository {

    override fun fetchDetails(context: Context, fields: String): Flow<Response<List<Details>>> =
        flow {
            emit(Response.Loading)
            val apiService = ApiService.getInstance()
            try {
                val detailsListResult = apiService.fetchDetails(fields)
                emit(Response.Success(detailsListResult))
            } catch (e: Exception) {
                emit(Response.Error(e.message ?: e.toString()))
            }
        }
}