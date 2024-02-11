package com.example.animalappreal

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Adopt : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adopt)

        recyclerView = findViewById(R.id.RecyclerView)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(this)

        var profiles = mutableListOf<Profile>()
        var profile1 = Profile(""
                , "")
        var profile2 = Profile("", "")
        profiles.add(profile1)
        profiles.add(profile2)

        recyclerView.adapter = CustomAdapter(profiles)
    }

}