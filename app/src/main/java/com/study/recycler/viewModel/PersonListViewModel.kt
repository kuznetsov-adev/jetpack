package com.study.recycler.viewModel

import androidx.lifecycle.ViewModel
import com.study.recycler.data.Person
import com.study.recycler.repository.PersonRepository
import java.util.*

class PersonListViewModel : ViewModel() {
    private val repository = PersonRepository()
    private var persons = repository.getPersons()

    fun addPerson() {
        val newUser = repository.createPerson()
        persons = listOf(newUser) + persons
    }

    fun deletePerson(position: Int) {
        persons = repository.deletePerson(persons, position)
    }

    fun getPersonList(): List<Person> = persons
}