package com.example.quizzie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizzie.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFinish.text = "FINISH"

        val username = intent.getStringExtra(Constants.USER_NAME)
        binding.tvUsername.text = username
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0);
        val totalQuestions = intent.getIntExtra((Constants.TOTAL_QUESTIONS), 0);

        binding.tvScore.text = "Your total score is ${correctAnswers.toString()}/${totalQuestions.toString()}"

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}