package org.karabalin.lab21

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.textView)
        val buttonEnglish = findViewById<Button>(R.id.buttonEnglish)
        val buttonRussian = findViewById<Button>(R.id.buttonRussian)

        updateText()

        buttonEnglish.setOnClickListener { setLocale("en") }
        buttonRussian.setOnClickListener { setLocale("ru") }
    }

    private fun setLocale(lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val resources = resources
        val config: Configuration = resources.configuration
        val dm = resources.displayMetrics
        config.setLocale(locale)
        resources.updateConfiguration(config, dm)
        recreate()
    }

    private fun updateText() {
        textView.text = getString(R.string.greeting)
    }
}