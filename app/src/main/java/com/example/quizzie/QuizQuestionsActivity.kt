package com.example.quizzie

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizzie.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mUserName: String? = null

    private var mCurrentPosition: Int = 1;
    private var mQuestionList: ArrayList<QuestionModel>? = null;
    private var mSelectedOptionPosition: Int = 0;
    private var score: Int = 0;

    private lateinit var binding: ActivityQuizQuestionsBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root);

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestion()

        setQuestion();

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

    }

    private fun setQuestion() {
        mSelectedOptionPosition = 0
        if(mCurrentPosition == mQuestionList!!.size) {
            binding.btnSubmit.text = "Finish"
        }
        else {
            binding.btnSubmit.text = "Submit"
        }

        val question = mQuestionList!![mCurrentPosition - 1];

        defaultOptionsView();

        binding.progressBar.progress = mCurrentPosition;
        binding.tvProgressCount.text = "$mCurrentPosition/${binding.progressBar.max}";

        binding.tvQues.text = question.question;
        binding.ivFlag.setImageResource(question.image);
        binding.tvOptionOne.text = question.optionOne;
        binding.tvOptionTwo.text = question.optionTwo;
        binding.tvOptionThree.text = question.optionThree;
        binding.tvOptionFour.text = question.optionFour;
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>();
        options.add(0, binding.tvOptionOne);
        options.add(1, binding.tvOptionTwo);
        options.add(2, binding.tvOptionThree);
        options.add(3, binding.tvOptionFour);

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg);
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(binding.tvOptionOne, 1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(binding.tvOptionTwo, 2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(binding.tvOptionThree, 3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(binding.tvOptionFour, 4)
            }
            R.id.btnSubmit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    if(mCurrentPosition <= mQuestionList!!.size) {
                        setQuestion()
                    }
                    else {
                        val intent = Intent(this, ResultActivity::class.java);
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                        intent.putExtra(Constants.CORRECT_ANSWERS, score)
                        startActivity(intent)
                        finish()
                    }
                }
                else {
                    checkCorrectAnswer(mSelectedOptionPosition)

                    if(mCurrentPosition == mQuestionList!!.size) {
                        binding.btnSubmit.text = "Finish"
                    }
                    else {
                        binding.btnSubmit.text = "Next Question"

                    }
                    mSelectedOptionPosition = 0


                }

            }
        }
    }



    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView();
        mSelectedOptionPosition = selectedOptionNumber;
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg);
    }

    private fun checkCorrectAnswer(option: Int) {
        val question: QuestionModel = mQuestionList!![mCurrentPosition - 1];
        if(option == question.correctAnswer) {
            score++
            setAnswerColor(option, R.drawable.correct_option_border_bg);
        }
        else {
            setAnswerColor(option, R.drawable.wrong_option_border_bg);
            setAnswerColor(question.correctAnswer, R.drawable.correct_option_border_bg);
        }
    }

    private fun setAnswerColor(option: Int, drawable: Int) {
        when(option) {
            1 -> {
                binding.tvOptionOne.background = ContextCompat.getDrawable(this, drawable);
            }
            2-> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(this, drawable);
            }
            3 -> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(this, drawable);
            }
            4 -> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(this, drawable);
            }
        }
    }
}