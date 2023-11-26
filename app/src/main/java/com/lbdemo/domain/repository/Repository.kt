package com.lbdemo.domain.repository

import android.content.Context
import com.lbdemo.domain.model.Response
import com.lbdemo.domain.model.Details
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun fetchDetails(context: Context, fields: String): Flow<Response<List<Details>>>
}