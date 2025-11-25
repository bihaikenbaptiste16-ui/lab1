package com.example.lab1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Main_activity : AppCompatActivity() {

    private var areAnswersVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // --- DÉBUT DE LA SECTION CORRIGÉE ---

        // 1. Récupérer les vues depuis le layout
        val answer1TextView = findViewById<TextView>(R.id.answer1)
        val answer2TextView = findViewById<TextView>(R.id.answer2)
        val answer3TextView = findViewById<TextView>(R.id.answer3)
        // CORRECTION : L'ID de l'icône est 'toggle_icon' dans le XML corrigé, pas 'imageView'.
        val toggleIcon = findViewById<ImageView>(R.id.imageView)

        // Regrouper les vues de réponse pour une gestion facile
        val answerViews = listOf(answer1TextView, answer2TextView, answer3TextView)

        // Définir la bonne réponse (par exemple, answer3)
        val correctAnswerTextView = answer3TextView

        // 2. Gérer le clic sur l'icône de l'œil
        toggleIcon.setOnClickListener {
            // Inverser l'état de visibilité
            areAnswersVisible = !areAnswersVisible

            if (areAnswersVisible) {
                // Si les réponses doivent être visibles :
                toggleIcon.setImageResource(R.drawable.ic_eye_open)
                answerViews.forEach { it.visibility = View.VISIBLE }
            } else {
                // Si les réponses doivent être cachées :
                toggleIcon.setImageResource(R.drawable.ic_eye_closed)
                answerViews.forEach { it.visibility = View.GONE }

                // Important : Réinitialiser les couleurs de fond
                answer1TextView.setBackgroundResource(R.drawable.orange_background)
                answer2TextView.setBackgroundResource(R.drawable.orange_background)
                answer3TextView.setBackgroundResource(R.drawable.orange_background)
            }
        }

        // 3. Gérer le clic sur chaque réponse
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

        // --- FIN DE LA SECTION CORRIGÉE ---

        // Code standard généré par Android Studio
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}