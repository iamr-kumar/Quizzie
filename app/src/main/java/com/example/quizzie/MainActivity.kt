package com.example.quizzie

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Toast
import com.example.quizzie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            if(binding.inputName.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name first!", Toast.LENGTH_SHORT).show();
            }
            else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.inputName.text.toString())
                startActivity(intent)
                finish();
            }
        }


    }
}