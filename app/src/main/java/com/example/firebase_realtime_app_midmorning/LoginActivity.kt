package com.example.firebase_realtime_app_midmorning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var edt_email: EditText
    lateinit var edt_password: EditText
    lateinit var loginbtn: Button
    lateinit var registerbtn: Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edt_email = findViewById(R.id.edit_email_login)
        edt_password = findViewById(R.id.edit_password_login)
        loginbtn = findViewById(R.id.login_btn_lg)
        registerbtn = findViewById(R.id.register_btn)

        auth = FirebaseAuth.getInstance()

        loginbtn.setOnClickListener {
            var email = edt_email.text.toString().trim()
            var password = edt_password.text.toString().trim()
            //validate
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "One of the Inputs is Empty", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()
                    }else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
        registerbtn.setOnClickListener {

        }
    }
}