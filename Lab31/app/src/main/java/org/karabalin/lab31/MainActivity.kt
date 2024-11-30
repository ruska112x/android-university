package org.karabalin.lab31

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var welcomeTextView: TextView
    private lateinit var updateButton: Button
    private lateinit var snackbarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        welcomeTextView = findViewById(R.id.text_view_welcome)
        updateButton = findViewById(R.id.button_update)
        snackbarButton = findViewById(R.id.button_snackbar)
        updateButton.setOnClickListener {
            welcomeTextView.text = getString(R.string.updated_message)
        }
        snackbarButton.setOnClickListener {
            Snackbar.make(welcomeTextView, "Snackbar without action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}