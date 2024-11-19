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
import com.example.studentnotes.User.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

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

        loginText.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
// Register button click listener
        registerButton.setOnClickListener {
            toRegister()
        }
    }

    // Registration logic moved here
    private fun toRegister() {
        val nameText = nameText.text.toString()
        val emailText = emailText.text.toString()
        val passwordText = passwordText.text.toString()
        val conformpasswordText = conformpasswordText.text.toString()

        if (nameText.isEmpty()) {
            Toast.makeText(this, "Fill Name", Toast.LENGTH_SHORT).show()
            return
        }
        if (emailText.isEmpty()) {
            Toast.makeText(this, "Fill Email", Toast.LENGTH_SHORT).show()
            return
        }
        if (passwordText.isEmpty() || conformpasswordText.isEmpty()) {
            Toast.makeText(this, "Fill Password", Toast.LENGTH_SHORT).show()
            return
        }
        if (passwordText != conformpasswordText) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        // Firebase Authentication
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(emailText, passwordText)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val firebaseUser = task.result?.user
                    firebaseUser?.let {
                        // Save user data to Firestore
                        val firestore = FirebaseFirestore.getInstance()
                        val user = User(name = nameText, email = emailText, uid = it.uid)
                        firestore.collection("users")
                            .document(it.uid)
                            .set(user)
                            .addOnSuccessListener {
                                Toast.makeText(
                                    this,
                                    "Registration Successful!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                // Redirect to Home Activity
                                val home = Intent(this, HomeActivity::class.java)
                                startActivity(home)
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                            }
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Error: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}