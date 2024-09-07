package org.karabalin.helloworld

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mHelloTextView: TextView
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // my code start
        editText = findViewById(R.id.textField)
        mHelloTextView = findViewById(R.id.textView)
        val imageButton = findViewById<ImageButton>(R.id.kittyButton)
        imageButton.setOnClickListener {
            if (editText.text.isEmpty()) {
                mHelloTextView.text = "Hello, Kitty!"
            } else {
                mHelloTextView.text = "Hello, " + editText.text
            }
        }
        // my code end
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}