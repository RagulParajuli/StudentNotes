package com.example.studentnotes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.studentnotes.TaskBar.CreateActivity
import com.example.studentnotes.TaskBar.ProfileActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var joinedImg: ImageView
    private lateinit var createImg: ImageView
    private lateinit var profileImg: ImageView
    private lateinit var joinedTxt: TextView
    private lateinit var createTxt: TextView
    private lateinit var profileTxt: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        joinedImg = findViewById(R.id.joinedImg)
        createImg = findViewById(R.id.createImg)
        profileImg = findViewById(R.id.profileImg)
        joinedTxt = findViewById(R.id.joinedTxt)
        createTxt = findViewById(R.id.createTxt)
        profileTxt = findViewById(R.id.profileTxt)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.miAddContact -> {
                // Handle Add Contact action
                Toast.makeText(this, "Add Contact clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.miShare -> {
                // Handle Share action
                Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun Join(view: View) {
        if (view.getId() == R.id.joinedImg || view.getId() == R.id.joinedTxt){
            Toast.makeText(this,"See Joined Notes", Toast.LENGTH_SHORT).show()
        }
    }
    fun Create(view: View) {
        if (view.getId() == R.id.createImg || view.getId() == R.id.createTxt){
            Toast.makeText(this,"Create Notes", Toast.LENGTH_SHORT).show()
            val create = Intent(this, CreateActivity::class.java)
            startActivity(create)
        }
    }
    fun Profile(view: View) {
        if (view.getId() == R.id.profileImg || view.getId() == R.id.profileTxt){
            val profile = Intent(this, ProfileActivity::class.java)
            startActivity(profile)
            Toast.makeText(this,"Opening Profile", Toast.LENGTH_SHORT).show()
        }
    }
}