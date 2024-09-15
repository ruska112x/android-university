package org.karabalin.severalactivity.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.karabalin.severalactivity.MainActivity
import org.karabalin.severalactivity.R

class PostActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_post)
        editText = findViewById(R.id.postText)
        button = findViewById(R.id.postButton)
        button.setOnClickListener {
            val newIntent = Intent(this@PostActivity, MainActivity::class.java)
            val textToPass = editText.text.ifEmpty { "Hello From Post!" }.toString()
            newIntent.putExtra("text", textToPass)
            startActivity(newIntent)
        }
    }
}