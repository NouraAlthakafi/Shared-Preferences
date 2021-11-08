package com.example.shareprefrences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etHobby: EditText
    lateinit var btnShare: Button
    lateinit var btnSave: Button
    lateinit var tvShare: TextView
    lateinit var tvTest: TextView

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    //var aHobby = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        sharedPreferences = this.getSharedPreferences(
//            getString(R.string.preference_hobby), Context.MODE_PRIVATE)
//        aHobby = sharedPreferences.getString("SomeoneHobby", "").toString()
        sharedPreferences = getSharedPreferences(getString(R.string.preference_hobby), MODE_PRIVATE)
        etName = findViewById(R.id.etName)
        etHobby = findViewById(R.id.etHobby)
        btnShare = findViewById(R.id.btnShare)
        btnSave = findViewById(R.id.btnSave)
        tvShare = findViewById(R.id.tvShare)

        tvTest = findViewById(R.id.textView2)

        btnShare.setOnClickListener {
            tvShare.text = "${etName.text}'s hobby is ${etHobby.text}"
        }

        btnSave.setOnClickListener {
            //aHobby = "${etName.text}'s hobby is ${etHobby.text}"
            editor = sharedPreferences.edit()
            editor.putString("hobby", "${etName.text}'s hobby is ${etHobby.text}")
            editor.commit()
//            aHobby = "${etName.text}'s hobby is ${etHobby.text}"
//            with(sharedPreferences.edit()) {
//                putString("SomeoneHobby", aHobby)
//                apply()
//            }
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        //tvTest.text = sharedPreferences.getString("hobby", "Nothing to show!").toString()
    }
}