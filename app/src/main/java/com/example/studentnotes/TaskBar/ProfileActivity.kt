package com.example.studentnotes.TaskBar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.studentnotes.HomeActivity
import com.example.studentnotes.LoginActivity
import com.example.studentnotes.MainActivity
import com.example.studentnotes.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var cros: ImageView
    private lateinit var userprofileImg: ImageView
    private lateinit var lOut: ImageView
    private lateinit var switchAcc: ImageView
    private lateinit var infoTxt: TextView
    private lateinit var userprofileName: TextView
    private lateinit var showprofileName: TextView
    private lateinit var userprofileEmail: TextView
    private lateinit var showprofileEmail: TextView
    private lateinit var userprofileNumber: TextView
    private lateinit var showprofileNumber: TextView
    private lateinit var userprofileAge: TextView
    private lateinit var showprofileAge: TextView
    private lateinit var userprofileRegion: TextView
    private lateinit var showprofileRegion: TextView
    private lateinit var userprofileLanguage: TextView
    private lateinit var showprofileLanguage: TextView
    private lateinit var logOut: TextView
    private lateinit var switchAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        cros = findViewById(R.id.cros)
        userprofileImg = findViewById(R.id.userprofileImg)
        lOut = findViewById(R.id.lOut)
        switchAcc = findViewById(R.id.switchAcc)
        switchAcc = findViewById(R.id.switchAcc)
        infoTxt = findViewById(R.id.infoTxt)
        userprofileName = findViewById(R.id.userprofileName)
        showprofileName = findViewById(R.id.showprofileName)
        userprofileEmail = findViewById(R.id.userprofileEmail)
        showprofileEmail = findViewById(R.id.showprofileEmail)
        userprofileNumber = findViewById(R.id.userprofileNumber)
        showprofileNumber = findViewById(R.id.showprofileNumber)
        userprofileAge = findViewById(R.id.userprofileAge)
        showprofileAge = findViewById(R.id.showprofileAge)
        userprofileRegion = findViewById(R.id.userprofileRegion)
        showprofileRegion = findViewById(R.id.showprofileRegion)
        userprofileLanguage = findViewById(R.id.userprofileLanguage)
        showprofileLanguage = findViewById(R.id.showprofileLanguage)
        logOut = findViewById(R.id.logOut)
        switchAccount = findViewById(R.id.switchAccount)
    }
    fun Cros(view: View) {
        val cross = Intent(this, HomeActivity::class.java)
        startActivity(cross)
    }
    fun SwitchAccount(view: View) {
        val switch = Intent(this, MainActivity::class.java)
        startActivity(switch)
    }
    fun LogOut(view: View) {
        val log = Intent(this, LoginActivity::class.java)
        startActivity(log)
    }
}