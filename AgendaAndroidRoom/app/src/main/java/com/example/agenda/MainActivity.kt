package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val dataBase by lazy { Room.databaseBuilder(applicationContext,DatabaseAgenda::class.java,"database").build() }
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    private val name by lazy { findViewById<TextInputEditText>(R.id.name) }
    private val phone by lazy { findViewById<TextInputEditText>(R.id.phone) }
    private val number by lazy { findViewById<TextView>(R.id.agenda) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.database = dataBase
        Log.d("aa","aa")
        viewModel.getAll()

        viewModel.agendaLiveData.observe(this) {
            var text = ""
            it.forEach { text += (it.toString() + "\n") }
            number.text = text
        }
    }

    fun addNumber(view: View){
        val number = Agenda(name = name.text.toString(),phone = phone.text.toString())
        name.setText("")
        phone.setText("")
        viewModel.add(number)
    }
}