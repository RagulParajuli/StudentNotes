package com.example.studentnotes.TaskBar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.studentnotes.HomeActivity
import com.example.studentnotes.R

class CreateActivity : AppCompatActivity() {

    private lateinit var addtitleTxt: TextView
    private lateinit var titleTxt: TextView
    private lateinit var contentTxt: TextView
    private lateinit var savenoteTxt: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        addtitleTxt = findViewById(R.id.addtitleTxt)
        titleTxt = findViewById(R.id.titleTxt)
        contentTxt = findViewById(R.id.contentTxt)
        savenoteTxt = findViewById(R.id.savenoteTxt)

    }

    fun SaveNote(view: View) {
        val save = Intent(this, HomeActivity::class.java)
        startActivity(save)
    }

}