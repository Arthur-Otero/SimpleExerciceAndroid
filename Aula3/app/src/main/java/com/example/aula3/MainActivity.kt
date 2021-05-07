package com.example.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.fragment1,Fragment1())
        transaction.add(R.id.fragment2,Fragment2())
        transaction.commit()

        val botao = findViewById<Button>(R.id.botao)
        var aux = true

        if (aux) {
            botao.setOnClickListener {
                aux=false
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragment1, Fragment2())
                transaction.replace(R.id.fragment2, Fragment1())
                transaction.commit()
            }
        }else{
            botao.setOnClickListener {
                aux=true
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragment1, Fragment1())
                transaction.replace(R.id.fragment2, Fragment2())
                transaction.commit()
            }
        }
    }
}