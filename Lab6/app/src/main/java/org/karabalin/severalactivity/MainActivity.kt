package org.karabalin.severalactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.karabalin.severalactivity.activities.AboutActivity
import org.karabalin.severalactivity.activities.PostActivity

class MainActivity : AppCompatActivity() {
    private lateinit var toAboutButton: Button
    private lateinit var toPostActivityButton: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //my code
        val textFromIntent = intent.getStringExtra("text")
        textView = findViewById(R.id.textView)
        if (!textFromIntent.isNullOrEmpty()) {
            textView.text = textFromIntent
        }
        toAboutButton = findViewById(R.id.toAboutButton)
        toAboutButton.setOnClickListener {
            val newIntent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(newIntent)
        }
        toPostActivityButton = findViewById(R.id.passVariableButton)
        toPostActivityButton.setOnClickListener {
            val newIntent = Intent(this@MainActivity, PostActivity::class.java)
            startActivity(newIntent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}