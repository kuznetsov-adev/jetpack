package com.study.recycler.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.recycler.data.Person
import com.study.recycler.event.SingleLiveEvent
import com.study.recycler.repository.PersonRepository
import java.util.*

class PersonListViewModel : ViewModel() {
    private val repository = PersonRepository()
    private val personLiveData = MutableLiveData<List<Person>>(repository.getPersons())
    private val showToastLiveData = SingleLiveEvent<Unit>()

    val persons: LiveData<List<Person>>
        get() = personLiveData
    val showToast: LiveData<Unit>
        get() = showToastLiveData

    fun addPerson() {
        val newUser = repository.createPerson()
        val updatedList = listOf(newUser) + personLiveData.value.orEmpty()
        personLiveData.postValue(updatedList)
        showToastLiveData.postValue(Unit)
    }

    fun deletePerson(position: Int) {
        personLiveData.postValue(
            repository.deletePerson(personLiveData.value.orEmpty(), position)
        )
    }
}