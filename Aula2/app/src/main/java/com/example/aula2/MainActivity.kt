package com.example.aula2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ids()

        Log.d("log","OnCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d("log","OnResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d("log","OnStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("log","OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("log","OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("log","onRestart")
    }

    override fun onStop() {
        super.onStop()

        Log.d("log","onStop")
    }

    private fun ids(){
        val botao = findViewById<FloatingActionButton>(R.id.botaoflutuante)
        val textId = findViewById<TextView>(R.id.texto)
        val pagina2 = findViewById<Button>(R.id.pag2)
        val pagina3 = findViewById<Button>(R.id.pag3)

        botao.setOnClickListener {
            textId.text = "Cliquei no Botão"
            textId.setBackgroundColor(Color.GREEN)
            Snackbar.make(botao,"SnackBar",Snackbar.LENGTH_INDEFINITE).setAction("Esconder"){
                Toast.makeText(this,"lalala",Toast.LENGTH_LONG).show()
            }.show()
        }

        pagina2.setOnClickListener {
            val intent = Intent(this, Pagina_2::class.java)
            intent.putExtra("frase","Você veio da pagina 1")
            startActivity(intent)
        }

        pagina3.setOnClickListener {
            val intent = Intent(this, Pagina_3::class.java)
            intent.putExtra("frase","Você veio da pagina 1")
            startActivity(intent)
        }

        val extra = intent.extras
        val string = extra?.getString("frase")
        textId.text = string
    }
}