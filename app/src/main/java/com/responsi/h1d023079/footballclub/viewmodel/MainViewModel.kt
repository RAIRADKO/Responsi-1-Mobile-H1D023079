package com.responsi.h1d023079.footballclub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.responsi.h1d023079.footballclub.data.model.TeamResponse
import com.responsi.h1d023079.footballclub.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // Private MutableLiveData for internal use
    private val _teamData = MutableLiveData<TeamResponse>()
    // Public LiveData exposed to the UI
    val teamData: LiveData<TeamResponse> = _teamData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // Function to fetch data from the API
    fun fetchTeamDetails(teamId: Int) {
        viewModelScope.launch {
            try {
                // Call the suspend fun from the API interface
                val response = RetrofitInstance.api.getTeamDetails(teamId)

                if (response.isSuccessful && response.body() != null) {
                    _teamData.postValue(response.body())
                } else {
                    _error.postValue("API Error: ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                _error.postValue("Network Exception: ${e.message ?: "Unknown error"}")
            }
        }
    }
}