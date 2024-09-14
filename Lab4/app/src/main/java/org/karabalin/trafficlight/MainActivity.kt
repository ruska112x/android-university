package org.karabalin.trafficlight

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var rootLayout: ConstraintLayout
    private lateinit var redButton: Button
    private lateinit var yellowButton: Button
    private lateinit var greenButton: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //my code
        val redColor = getColor(R.color.red)
        val yellowColor = getColor(R.color.yellow)
        val greenColor = getColor(R.color.green)
        rootLayout = findViewById(R.id.main)
        textView = findViewById(R.id.textView)
        redButton = findViewById(R.id.redButton)
        yellowButton = findViewById(R.id.yellowButton)
        greenButton = findViewById(R.id.greenButton)

        redButton.setOnClickListener {
            textView.text = getString(R.string.redText)
            rootLayout.setBackgroundColor(redColor)
        }

        yellowButton.setOnClickListener {
            textView.text = getString(R.string.yellowText)
            rootLayout.setBackgroundColor(yellowColor)
        }

        greenButton.setOnClickListener {
            textView.text = getString(R.string.greenText)
            rootLayout.setBackgroundColor(greenColor)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}