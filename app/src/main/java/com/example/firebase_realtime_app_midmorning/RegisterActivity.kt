package com.example.firebase_realtime_app_midmorning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var edt_fullname: EditText
    lateinit var edt_email_reg: EditText
    lateinit var edt_password_reg: EditText
    lateinit var createacc_btn: Button

    //initialise firebase
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        edt_fullname = findViewById(R.id.edit_fullname_reg)
        edt_email_reg = findViewById(R.id.edit_email_reg)
        edt_password_reg = findViewById(R.id.edit_password_reg)
        createacc_btn = findViewById(R.id.create_acc_btn)

        //initialise firebase again
        auth = FirebaseAuth.getInstance()

        createacc_btn.setOnClickListener {
            var name = edt_fullname.text.toString().trim()
            var email = edt_email_reg.text.toString().trim()
            var password = edt_password_reg.text.toString().trim()

            //validate your inputs
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One of the fields is empty", Toast.LENGTH_SHORT).show()
            }else{
                //create a user in firebase
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "Failed to Create Account", Toast.LENGTH_SHORT).show()
                }


                }


            }
        }
    }
}