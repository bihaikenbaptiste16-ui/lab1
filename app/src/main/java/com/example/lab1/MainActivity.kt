package com.example.lab1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var areAnswersVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val answer1TextView = findViewById<TextView>(R.id.answer1)
        val answer2TextView = findViewById<TextView>(R.id.answer2)
        val answer3TextView = findViewById<TextView>(R.id.answer3)
        val imageView = findViewById<ImageView>(R.id.imageView)

        val answerViews = listOf(answer1TextView, answer2TextView, answer3TextView)

        val correctAnswerTextView = answer3TextView

        imageView.setOnClickListener {
            
            areAnswersVisible = !areAnswersVisible

            if (areAnswersVisible)
            {  imageView.setImageResource(R.drawable.ic_eye_open)
                answerViews.forEach { it.visibility = View.VISIBLE }
            }

            else {imageView.setImageResource(R.drawable.ic_eye_closed)
                answerViews.forEach { it.visibility = View.GONE }
                answer1TextView.setBackgroundResource(R.drawable.orange_background)
                answer2TextView.setBackgroundResource(R.drawable.orange_background)
                answer3TextView.setBackgroundResource(R.drawable.orange_background)
            }}
    
        answer1TextView.setOnClickListener {
            it.setBackgroundColor(Color.RED) // "it" est la vue cliquée (answer1)
            correctAnswerTextView.setBackgroundColor(Color.GREEN) // Montrer la bonne réponse en vert
        }
        answer2TextView.setOnClickListener {
            it.setBackgroundColor(Color.RED)
            correctAnswerTextView.setBackgroundColor(Color.GREEN)
        }

        answer3TextView.setOnClickListener {
            it.setBackgroundColor(Color.GREEN) // Seule la réponse correcte devient verte
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}