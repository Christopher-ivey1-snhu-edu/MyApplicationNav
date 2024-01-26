package com.example.myapplicationnavigation.ui.scrolling

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationnavigation.data.remote.ApiDetails
import com.example.myapplicationnavigation.model.room.RoomModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScrollingViewModel : ViewModel() {

    private var _rooms = MutableLiveData<List<RoomModelItem>>()
    val rooms: LiveData<List<RoomModelItem>> = _rooms


    fun getRooms() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = ApiDetails.service.getRooms()
            if (result.isNotEmpty()) {
                _rooms.postValue(result)
            }
        }
    }
}