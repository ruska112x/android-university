package org.karabalin.counterkot

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var helloButton: Button
    private lateinit var countCrowsButton: Button
    private lateinit var countCatsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // my code
        var crowsCount = 0
        var catsCount = 0
        textView = findViewById(R.id.textView)
        helloButton = findViewById(R.id.helloButton)
        countCrowsButton = findViewById(R.id.countCrowsButton)
        countCatsButton = findViewById(R.id.countCatsButton)

        helloButton.setOnClickListener {
            textView.text = getString(R.string.helloText)
        }

        countCrowsButton.setOnClickListener {
            textView.text = String.format(getString(R.string.countCrowsText), ++crowsCount)
        }

        countCatsButton.setOnClickListener {
            textView.text = String.format(getString(R.string.countCatsText), ++catsCount)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}