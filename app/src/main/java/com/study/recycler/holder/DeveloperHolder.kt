package com.study.recycler.holder

import android.view.View
import com.study.recycler.data.Person
import kotlinx.android.synthetic.main.item_developer.*

class DeveloperHolder(
    override val containerView: View,
    onItemClicked: (id: String) -> Unit
) : BasePersonHolder(containerView, onItemClicked) {

    fun bind(person: Person.Developer) {
        bindMainInfo(person.id, person.name, person.avatarLink, person.age)
        programmingLanguageTextView.text = person.programmingLanguage
    }
}