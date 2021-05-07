package com.example.aula2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Pagina_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_3)

        ids()
        Log.d("log","OnCreate3")
    }

    override fun onResume() {
        super.onResume()
        Log.d("log","OnResume3")
    }

    override fun onStart() {
        super.onStart()
        Log.d("log","OnStart3")
    }

    override fun onPause() {
        super.onPause()
        Log.d("log","OnPause3")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("log","OnDestroy3")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("log","onRestart3")
    }

    override fun onStop() {
        super.onStop()

        Log.d("log","onStop3")
    }

    private fun ids(){
        var textId = findViewById<TextView>(R.id.texto)
        val pagina2 = findViewById<Button>(R.id.pag2)
        val pagina1 = findViewById<Button>(R.id.pag1)

        pagina2.setOnClickListener {
            val intent = Intent(this, Pagina_2::class.java)
            intent.putExtra("frase","Você veio da pagina 3")
            startActivity(intent)
        }

        pagina1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("frase","Você veio da pagina 3")
            startActivity(intent)
        }

        val extra = intent.extras
        val string = extra?.getString("frase")
        textId.text = string
    }
}