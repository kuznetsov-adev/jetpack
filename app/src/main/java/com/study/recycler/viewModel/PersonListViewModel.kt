package com.study.recycler.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.recycler.data.Person
import com.study.recycler.repository.PersonRepository
import java.util.*

class PersonListViewModel : ViewModel() {
    private val repository = PersonRepository()
    private val personLiveData = MutableLiveData<List<Person>>(repository.getPersons())
    val persons: LiveData<List<Person>>
        get() = personLiveData

    fun addPerson() {
        val newUser = repository.createPerson()
        val updatedList = listOf(newUser) + personLiveData.value.orEmpty()
        personLiveData.postValue(updatedList)
    }

    fun deletePerson(position: Int) {
        personLiveData.postValue(
            repository.deletePerson(personLiveData.value.orEmpty(), position)
        )
    }
}