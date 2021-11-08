package com.example.shareprefrences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var tvSave: TextView
    lateinit var btnRes: Button
    lateinit var sharedPreferences: SharedPreferences
    //lateinit var editor: SharedPreferences.Editor
    //var aHobby = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_hobby), MODE_PRIVATE)
        tvSave = findViewById(R.id.tvSave)
        btnRes = findViewById(R.id.btnRes)


        btnRes.setOnClickListener {
            //aHobby = sharedPreferences.getString("hobby", "Nothing to show!").toString()
            tvSave.text = sharedPreferences.getString("hobby", "Nothing to show!").toString()
        }
    }
}