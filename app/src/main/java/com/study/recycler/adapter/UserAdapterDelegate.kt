package com.study.recycler.adapter

import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.study.recycler.R
import com.study.recycler.data.Person
import com.study.recycler.extensions.inflate
import com.study.recycler.holder.UserHolder

class UserAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<Person.User, Person, UserHolder>(){

    override fun isForViewType(item: Person, items: MutableList<Person>, position: Int): Boolean {
        return item is Person.User
    }

    override fun onCreateViewHolder(parent: ViewGroup): UserHolder {
        return UserHolder(parent.inflate(R.layout.item_user), onItemClicked)
    }

    override fun onBindViewHolder(
        item: Person.User,
        holder: UserHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }
}