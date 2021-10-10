package com.study.recycler.viewModel

import androidx.lifecycle.ViewModel
import com.study.recycler.data.Person
import java.util.*

class PersonListViewModel : ViewModel() {

    private var persons = listOf(
        Person.Developer(
            id = UUID.randomUUID().toString(),
            name = "John Smith",
            avatarLink = "https://cdn.pixabay.com/photo/2014/04/03/10/32/businessman-310819_1280.png",
            age = 32,
            programmingLanguage = "Java"
        ),
        Person.User(
            id = UUID.randomUUID().toString(),
            name = "Kevin Costner",
            avatarLink = "https://png.pngtree.com/png-clipart/20190922/original/pngtree-business-male-user-avatar-vector-png-image_4774078.jpg",
            age = 29,
        ),
        Person.User(
            id = UUID.randomUUID().toString(),
            name = "Jane Blane",
            avatarLink = "https://png.pngtree.com/png-clipart/20190924/original/pngtree-female-user-avatars-flat-style-women-profession-vector-png-image_4822944.jpg",
            age = 25,

            ),
        Person.Developer(
            id = UUID.randomUUID().toString(),
            name = "Helen Snow",
            avatarLink = "https://cdn.pixabay.com/photo/2014/04/03/10/32/user-310807_1280.png",
            age = 40,
            programmingLanguage = "Kotlin"
        ),
    )

    fun addPerson() {
        val newUser = persons.random().let {
            when(it) {
                is Person.Developer -> it.copy(id = UUID.randomUUID().toString())
                is Person.User -> it.copy(id = UUID.randomUUID().toString())
            }
        }
        persons = listOf(newUser) + persons
    }

    fun deletePerson(position: Int) {
        persons = persons.filterIndexed{ index, user -> index != position}
    }

    fun getPersonList(): List<Person> = persons
}