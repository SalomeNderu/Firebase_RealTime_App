package com.example.firebase_realtime_app_midmorning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var edit_carmake: EditText
    lateinit var edit_carmodel: EditText
    lateinit var edit_carprice: EditText
    lateinit var btn_carphoto: Button
    lateinit var btn_cardata: Button
    lateinit var btn_carphotoview: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_carmake = findViewById(R.id.edit_text_carmake)
        edit_carmodel = findViewById(R.id.edit_text_carmodel)
        edit_carprice = findViewById(R.id.edit_text_carprice)
        btn_carphoto = findViewById(R.id.carphoto_btn)
        btn_cardata = findViewById(R.id.cardata_btn)
        btn_carphotoview = findViewById(R.id.viewcar_btn)

        //initialise firebase
        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.getReference("cars")


        btn_carphoto.setOnClickListener {

        }
        btn_cardata.setOnClickListener {
            var carmake = edit_carmake.text.toString().trim()
            var carmodel = edit_carmodel.text.toString().trim()
            var carprice = edit_carprice.text.toString().trim()
            //validation of inputs
            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty()) {
                Toast.makeText(this, "Cannot Submit When One Of The Fields Is Missing", Toast.LENGTH_SHORT).show()
            }else {
                //saving inf to firebase db
            }


        }
        btn_carphoto.setOnClickListener {

        }

    }
}


////https://justpaste.it/bczmq