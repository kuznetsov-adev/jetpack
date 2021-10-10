package com.study.recycler.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.study.recycler.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_developer.*

abstract class BasePersonHolder(
    view: View,
    onItemClicked: (position: Int) -> Unit
) : RecyclerView.ViewHolder(view), LayoutContainer {

    init {
        view.setOnClickListener {
            onItemClicked(bindingAdapterPosition)
        }
    }

    protected fun bindMainInfo(
        name: String,
        avatarLink: String,
        age: Int
    ) {
        nameTextView.text = name
        ageTextView.text = "Age = ${age}"

        Glide.with(itemView)
            .load(avatarLink)
            .placeholder(R.drawable.ic_portrait)
            .into(avatarImageView)
    }
}