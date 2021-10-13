package com.study.recycler.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.study.recycler.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_developer.*

abstract class BasePersonHolder(
    view: View,
    onItemClicked: (id: String) -> Unit
) : RecyclerView.ViewHolder(view), LayoutContainer {
    private var currentId: String? = null

    init {
        view.setOnClickListener {
            currentId?.let{onItemClicked(it)}
        }
    }

    protected fun bindMainInfo(
        id: String,
        name: String,
        avatarLink: String,
        age: Int
    ) {
        currentId = id
        nameTextView.text = name
        ageTextView.text = "Age = ${age}"

        Glide.with(itemView)
            .load(avatarLink)
            .placeholder(R.drawable.ic_portrait)
            .into(avatarImageView)
    }
}