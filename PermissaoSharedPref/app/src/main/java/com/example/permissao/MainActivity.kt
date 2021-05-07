package com.example.permissao

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    companion object {
        val USER_PREFS = "USER_PREFS"
        val OPTION1 = "option1"
        val OPTION2 = "option2"
        val OPTION3 = "option3"
        val OPTION4 = "option4"
        val OPTION5 = "option5"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configSharedPrefs()
        setConfig(configSharedPrefs())
        configViews(configSharedPrefs())
    }

    private fun setConfig(prefs: SharedPreferences) {
        val option1 = findViewById<SwitchCompat>(R.id.option1)
        val option2 = findViewById<SwitchCompat>(R.id.option2)
        val option3 = findViewById<SwitchCompat>(R.id.option3)
        val option4 = findViewById<SwitchCompat>(R.id.option4)
        val option5 = findViewById<SwitchCompat>(R.id.option5)

        val opcao1 = prefs.getBoolean( OPTION1, false)
        val opcao2 = prefs.getBoolean( OPTION2, false)
        val opcao3 = prefs.getBoolean( OPTION3, false)
        val opcao4 = prefs.getBoolean( OPTION4, false)
        val opcao5 = prefs.getBoolean( OPTION5, false)

        option1.isChecked = opcao1
        option2.isChecked = opcao2
        option3.isChecked = opcao3
        option4.isChecked = opcao4
        option5.isChecked = opcao5

    }

    private fun configViews(prefs: SharedPreferences) {
        val option1 = findViewById<SwitchCompat>(R.id.option1)
        val option2 = findViewById<SwitchCompat>(R.id.option2)
        val option3 = findViewById<SwitchCompat>(R.id.option3)
        val option4 = findViewById<SwitchCompat>(R.id.option4)
        val option5 = findViewById<SwitchCompat>(R.id.option5)

        option1.setOnCheckedChangeListener{_, isCheck ->
            prefs.edit().putBoolean(OPTION1,isCheck).apply()
        }

        option2.setOnCheckedChangeListener{_, isCheck ->
            prefs.edit().putBoolean(OPTION2,isCheck).apply()
        }

        option3.setOnCheckedChangeListener{_, isCheck ->
            prefs.edit().putBoolean(OPTION3,isCheck).apply()
        }

        option4.setOnCheckedChangeListener{_, isCheck ->
            prefs.edit().putBoolean(OPTION4,isCheck).apply()
        }

        option5.setOnCheckedChangeListener{_, isCheck ->
            prefs.edit().putBoolean(OPTION5,isCheck).apply()
        }
    }

    private fun configSharedPrefs() = getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
}