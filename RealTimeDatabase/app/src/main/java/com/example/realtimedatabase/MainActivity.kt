package com.example.realtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private val name by lazy { findViewById<TextInputEditText>(R.id.name) }
    private val url by lazy { findViewById<TextInputEditText>(R.id.url) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseDatabase = FirebaseDatabase.getInstance()
    }

    fun configureUser(view:View){
        val user = User(name.text.toString(),url.text.toString())
        val reference = firebaseDatabase.getReference("ids")

        reference.child(name.text.toString()).setValue(user)

//        reference.child(name.text.toString()).addListenerForSingleValueEvent(object : ValueEventListener{
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val userCatch = snapshot.getValue(User::class.java)
//                Log.d("TesteFirebase", userCatch?.name!!)
//                Log.d("TesteFirebase", userCatch.url)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                error
//            }
//
//        })
    }
}