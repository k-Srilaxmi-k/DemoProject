package com.lbdemo.presentation.details_screen


import android.app.Application
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.lbdemo.domain.model.Response
import com.lbdemo.domain.model.Details
import com.lbdemo.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val useCase: UseCases, application: Application) : AndroidViewModel(application) {
    var checkRefreshState = mutableStateOf(false)

    private val _detailsResponseState = mutableStateOf<Response<List<Details>>>(Response.Idle)
    val detailsResponseState: State<Response<List<Details>>> = _detailsResponseState

    fun fetchDetails(context: Context, fields: String) {
        viewModelScope.launch {
            useCase.fetchDetails(context, fields).collect { response ->
                _detailsResponseState.value = response
            }
        }
    }
}