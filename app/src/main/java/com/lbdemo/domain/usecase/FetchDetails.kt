package com.lbdemo.domain.usecase

import android.content.Context
import com.lbdemo.domain.repository.Repository

class FetchDetails (
    private val repository: Repository
) {
    operator fun invoke(context: Context, fields: String) = repository.fetchDetails(context, fields)
}