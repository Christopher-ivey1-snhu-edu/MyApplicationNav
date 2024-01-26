package com.example.myapplicationnavigation.ui.itemlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationnavigation.data.remote.ApiDetails
import com.example.myapplicationnavigation.model.people.PeopleModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemListViewModel : ViewModel() {

    private var _people = MutableLiveData<List<PeopleModelItem>>()
    val people: LiveData<List<PeopleModelItem>> = _people

    fun getPeople(): List<PeopleModelItem> {
        var people = listOf<PeopleModelItem>()

        viewModelScope.launch(Dispatchers.IO) {
            people = ApiDetails.service.getPeople()
        }
        return people
    }
}