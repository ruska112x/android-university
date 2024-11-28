package org.karabalin.lab20

import android.os.Bundle
import android.view.KeyEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var logTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logTextView = findViewById(R.id.logTextView)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val log = "Key Down: " + KeyEvent.keyCodeToString(keyCode)
        logTextView.append(log + "\n")
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        val log = "Key Long Press: " + KeyEvent.keyCodeToString(keyCode)
        logTextView.append(log + "\n")
        return true
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        val log = "Key Up: " + KeyEvent.keyCodeToString(keyCode)
        logTextView.append(log + "\n")
        return super.onKeyUp(keyCode, event)
    }
}