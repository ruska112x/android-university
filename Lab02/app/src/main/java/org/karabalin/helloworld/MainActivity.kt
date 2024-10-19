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
    private lateinit var textViewHello: TextView
    private lateinit var textViewNiceDay: TextView
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // my code start
        editText = findViewById(R.id.textField)
        textViewHello = findViewById(R.id.textViewHello)
        textViewNiceDay = findViewById(R.id.textViewNiceDay)
        val imageButton = findViewById<ImageButton>(R.id.kittyButton)
        imageButton.setOnClickListener {
            if (editText.text.isEmpty()) {
                textViewHello.text = getString(R.string.helloWorld)
            } else {
                textViewHello.text = String.format("${getString(R.string.hello)} ${editText.text}!")
                textViewNiceDay.text = getString(R.string.haveANiceDay)
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