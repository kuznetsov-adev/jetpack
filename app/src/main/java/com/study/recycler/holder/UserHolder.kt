package com.study.recycler.holder

import android.view.View
import com.study.recycler.data.Person

class UserHolder(
    override val containerView: View,
    onItemClicked: (id: String) -> Unit
) : BasePersonHolder(containerView, onItemClicked) {

    fun bind(person: Person.User) {
        bindMainInfo(person.id, person.name, person.avatarLink, person.age)
    }
}