package com.example.animalappreal

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Form : AppCompatActivity() {
//need local file path of the image, will not be uploading to firebase, store into storage instance
    //allows storage of files/images, keep track of it
    //when uploading image, upload local URI path(references to image on local phone, way u can find the image),
    //upload into firebase storage, will have unique path in path, store unique path into the database
    //ex. user fills out form, stores address to the firebase storage instance of the image in the image
    //take unique image key, reference in storage, pull image out
    // <!--    need variable that represents firebase storage-->
    //need variable of URI, variable of firebase storage, variable to represent storage reference(location)
    lateinit var filePath: Uri
    lateinit var storage: FirebaseStorage
    lateinit var nameInput: EditText
    lateinit var bioInput: EditText
    lateinit var submitButton: Button
    lateinit var chooseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form)
        val db = Firebase.firestore

        nameInput = findViewById(R.id.name)
        bioInput = findViewById(R.id.bio)
        chooseButton = findViewById(R.id.chooseButton)
        submitButton = findViewById(R.id.submitButton)
        submitButton.setOnClickListener {
            val user = hashMapOf(
                "bio" to bioInput.text,
                "name" to nameInput.text
            )
            db.collection("user")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(
                        "Firestore",
                        "Document with document id: ${documentReference.id} added successfully"
                    )
                }
                .addOnFailureListener { e -> Log.w("Firestore", "Error adding doc: ${e}") }
        }
    }
}