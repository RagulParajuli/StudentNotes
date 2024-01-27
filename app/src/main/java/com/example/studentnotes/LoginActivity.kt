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

class LoginActivity : AppCompatActivity() {

    private lateinit var doorImg: ImageView
    private lateinit var orImg: ImageView
    private lateinit var emailTxt: EditText
    private lateinit var passTxt: EditText
    private lateinit var logBtn: Button
    private lateinit var sinBtn: Button
    private lateinit var createrTxt: TextView
    private lateinit var forgetTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        doorImg = findViewById(R.id.doorImg)
        orImg = findViewById(R.id.orImg)
        emailTxt = findViewById(R.id.emailTxt)
        passTxt = findViewById(R.id.passTxt)
        logBtn = findViewById(R.id.logBtn)
        sinBtn = findViewById(R.id.sinBtn)
        createrTxt = findViewById(R.id.createTxt)
        forgetTxt = findViewById(R.id.forgetTxt)
    }
    fun LogIn(view: View) {
        val emailTxt = emailTxt.text.toString()
        val passTxt = passTxt.text.toString()
        if(view.getId() == R.id.logBtn){
            if(emailTxt.isEmpty()){
                Toast.makeText(this, "Fill Email", Toast.LENGTH_SHORT).show()
            }
            else if (passTxt.isEmpty()){
                Toast.makeText(this, "Fill Password", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Loging In", Toast.LENGTH_SHORT).show()
                val log = Intent(this, HomeActivity::class.java)
                startActivity(log)
            }
        }
    }
    fun SignIn(view: View) {
        Toast.makeText(this, "Signing In", Toast.LENGTH_SHORT).show()
        val sin = Intent(this, MainActivity::class.java)
        startActivity(sin)
    }

    fun Forget(view: View) {
        Toast.makeText(this, "Try To Remember", Toast.LENGTH_SHORT).show()
    }
}