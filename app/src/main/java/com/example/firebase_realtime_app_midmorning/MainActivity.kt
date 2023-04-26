package com.example.firebase_realtime_app_midmorning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var edit_user_input: EditText
    lateinit var btn_save_data: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_user_input = findViewById(R.id.edit_data)
        btn_save_data = findViewById(R.id.save_btn)

        //initialise firebase
        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference


        btn_save_data.setOnClickListener {
            var user_data = edit_user_input.text.toString().trim()
            //Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
            databaseRef.setValue(user_data)
        }
    }
}