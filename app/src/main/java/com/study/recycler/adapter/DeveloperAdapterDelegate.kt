package com.study.recycler.adapter

import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.study.recycler.R
import com.study.recycler.data.Person
import com.study.recycler.extensions.inflate
import com.study.recycler.holder.DeveloperHolder

class DeveloperAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<Person.Developer, Person, DeveloperHolder>() {
    override fun isForViewType(item: Person, items: MutableList<Person>, position: Int): Boolean {
        return item is Person.Developer
    }

    override fun onCreateViewHolder(parent: ViewGroup): DeveloperHolder {
        return DeveloperHolder(parent.inflate(R.layout.item_developer), onItemClicked)
    }

    override fun onBindViewHolder(
        item: Person.Developer,
        holder: DeveloperHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }
}