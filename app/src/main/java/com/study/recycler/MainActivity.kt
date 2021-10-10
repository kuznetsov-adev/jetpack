package com.study.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.study.recycler.fragment.PersonListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, PersonListFragment())
            .commit()
    }

}