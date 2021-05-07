package com.example.agenda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    lateinit var database : DatabaseAgenda
    val agendaLiveData by lazy { MutableLiveData<List<Agenda>>() }

    fun getAll(){
        viewModelScope.launch {
            val dataAgenda = database.agendaDao().getAll()
            agendaLiveData.postValue(dataAgenda)
        }
    }

    fun add(number:Agenda){
        viewModelScope.launch {
            database.agendaDao().insert(number)
        }.invokeOnCompletion {
            getAll()
        }
    }

    fun delete() {
        val number = agendaLiveData.value?.last()

        viewModelScope.launch {
            number?.let { database.agendaDao().delete(it) }
        }.invokeOnCompletion {
            getAll()
        }
    }
}