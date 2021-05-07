package com.example.aula2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Pagina_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_2)

        ids()

        Log.d("log","OnCreate2")
    }

    override fun onResume() {
        super.onResume()
        Log.d("log","OnResume2")
    }

    override fun onStart() {
        super.onStart()
        Log.d("log","OnStart2")
    }

    override fun onPause() {
        super.onPause()
        Log.d("log","OnPause2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("log","OnDestroy2")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("log","onRestart2")
    }

    override fun onStop() {
        super.onStop()

        Log.d("log","onStop2")
    }

    private fun ids(){
        val textId = findViewById<TextView>(R.id.texto)
        val pagina3 = findViewById<Button>(R.id.pag3)
        val pagina1 = findViewById<Button>(R.id.pag1)

        pagina3.setOnClickListener {
            val intent = Intent(this, Pagina_3::class.java)
            intent.putExtra("frase","Você veio da pagina 2")
            startActivity(intent)
        }

        pagina1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("frase","Você veio da pagina 2")
            startActivity(intent)
        }

        val extra = intent.extras
        val string = extra?.getString("frase")
        textId.text = string
    }
}