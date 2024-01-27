package com.example.studentnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var loginImg: ImageView
    private lateinit var googleLogo: ImageView
    private lateinit var welcomeText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var alreadyText: TextView
    private lateinit var loginText: TextView
    private lateinit var registerText: TextView
    private lateinit var registerButton: Button
    private lateinit var nameText: EditText
    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    private lateinit var conformpasswordText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginImg = findViewById(R.id.loginImg)
        googleLogo = findViewById(R.id.googleLogo)
        welcomeText = findViewById(R.id.welcomeText)
        descriptionText = findViewById(R.id.descriptionText)
        alreadyText = findViewById(R.id.alreadyText)
        loginText = findViewById(R.id.loginText)
        registerText = findViewById(R.id.registerText)
        registerButton = findViewById(R.id.registerButton)
        nameText = findViewById(R.id.nameText)
        emailText = findViewById(R.id.emailText)
        passwordText = findViewById(R.id.passwordText)
        conformpasswordText = findViewById(R.id.conformpasswordText)

    }

    fun toRegister(view: View) {
        val nameText = nameText.text.toString()
        val emailText = emailText.text.toString()
        val passwordText = passwordText.text.toString()
        val conformpasswordText = conformpasswordText.text.toString()
        if (view.getId() == R.id.registerButton){
            if (nameText.isEmpty()){
                Toast.makeText(this, "Fill Name", Toast.LENGTH_SHORT).show()
            }
            else if (emailText.isEmpty()){
                Toast.makeText(this, "Fill Email", Toast.LENGTH_SHORT).show()
            }
            else if (passwordText.isEmpty() || conformpasswordText.isEmpty() ){
                Toast.makeText(this, "Fill Password", Toast.LENGTH_SHORT).show()
            }
            else if(passwordText != conformpasswordText){
                Toast.makeText(this, "Password not Match", Toast.LENGTH_SHORT).show()
            }
            else{
                val home = Intent(this, HomeActivity::class.java)
                startActivity(home)
            }
        }
        if (view.getId() == R.id.registerText){
            Toast.makeText(this, "Opening Google", Toast.LENGTH_SHORT).show()
        }
    }
    fun toLogin(view: View) {
            if (view.getId() == R.id.loginText){
                val login = Intent(this, LoginActivity::class.java)
                startActivity(login)
            }
    }
}


