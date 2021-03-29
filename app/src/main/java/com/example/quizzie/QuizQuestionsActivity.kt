package com.example.quizzie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizzie.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root);

        val questionList = Constants.getQuestion()

        val currentPosition = 1;
        val question: QuestionModel = questionList[currentPosition - 1];

        binding.progressBar.progress = currentPosition;
        binding.tvProgressCount.text = "$currentPosition/${binding.progressBar.max}";

        binding.tvQues.text = question.question;
        binding.ivFlag.setImageResource(question.image);
        binding.tvOptionOne.text = question.optionOne;
        binding.tvOptionTwo.text = question.optionTwo;
        binding.tvOptionThree.text = question.optionThree;
        binding.tvOptionFour.text = question.optionFour;

    }
}