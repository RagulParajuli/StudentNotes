package com.example.studentnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var doorImg: ImageView
    private lateinit var orImg: ImageView
    private lateinit var emailTxt: EditText
    private lateinit var passTxt: EditText
    private lateinit var logBtn: Button
    private lateinit var sinBtn: Button
    private lateinit var createrTxt: TextView
    private lateinit var forgetTxt: TextView

    // Firebase Authentication instance
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        doorImg = findViewById(R.id.doorImg)
        orImg = findViewById(R.id.orImg)
        emailTxt = findViewById(R.id.emailTxt)
        passTxt = findViewById(R.id.passTxt)
        logBtn = findViewById(R.id.logBtn)
        sinBtn = findViewById(R.id.sinBtn)
        createrTxt = findViewById(R.id.createTxt)
        forgetTxt = findViewById(R.id.forgetTxt)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Set click listeners
        logBtn.setOnClickListener { logIn() }
        sinBtn.setOnClickListener { signUp() }
        forgetTxt.setOnClickListener { forgetPassword() }
    }

    private fun logIn() {
        val email = emailTxt.text.toString().trim()
        val password = passTxt.text.toString().trim()

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
            return
        }

        // Log in using Firebase Auth
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login successful
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Login failed
                    Toast.makeText(this, "Login Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun signUp() {
        // Navigate to the registration screen
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun forgetPassword() {
        val email = emailTxt.text.toString().trim()

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your registered email", Toast.LENGTH_SHORT).show()
            return
        }

        // Send a password reset email
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Password reset email sent", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}
