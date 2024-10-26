package org.karabalin.lab16

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.myTextView)
    }

    override fun onStart() {
        super.onStart()
        textView.text = "onStart"
        Log.i("MainActivity", "onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        textView.text = "onRestart"
        Log.i("MainActivity", "onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        // textView.text = "onResume"
        Log.i("MainActivity", "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        textView.text = "onPause"
        Log.i("MainActivity", "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        textView.text = "onStop"
        Log.i("MainActivity", "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        textView.text = "onDestroy"
        Log.i("MainActivity", "onDestroy() called")
    }

}