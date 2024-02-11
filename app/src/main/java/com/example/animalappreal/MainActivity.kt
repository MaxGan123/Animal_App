package com.example.animalappreal

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var website : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        website = findViewById(R.id.website)
        website.setOnClickListener {
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("http://hola9.org")
            startActivity(url)
        }
        button2 = findViewById(R.id.button2)
        button2.text = "Adopt"
        button3 = findViewById(R.id.button3)
        button3.text = "firebase_Add"
        button3.setOnClickListener{
            var form = Intent(this, Form::class.java)
            startActivity(form)
        }
        button2.setOnClickListener {
            var adopt = Intent(this, Adopt::class.java)
            startActivity(adopt)
        }
//        fun firebase_Add() {
//            val db = Firebase.firestore
//
//            val user = hashMapOf(
//                "username" to "MaxG",
//                "picture" to "dog",
//                "bio" to "pure pomeranian"
//            )
//
//            db.collection("users")
//                .add(user)
//                .addOnSuccessListener { documentReference ->
//                    Log.d(
//                        "Firestore",
//                        "Document with document id: ${documentReference.id} added successfully"
//                    )
//                }
//                .addOnFailureListener { e -> Log.w("Firestore", "Error adding doc: ${e}") }
//
//            db.collection("users")
//                .get()
//                .addOnSuccessListener { collection ->
//                    for (doc in collection) {
//                        Log.d("Firestore", "${doc.id} => ${doc.data}")
//                    }
//                }
//                .addOnFailureListener { e -> Log.w("Firestore", "Error adding doc: ${e}") }
//        }
//        button3.setOnClickListener{
//            firebase_Add()
//        }
    }
}