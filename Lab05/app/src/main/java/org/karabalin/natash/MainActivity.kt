package org.karabalin.natash

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var rootLayout: ConstraintLayout
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //my code
        rootLayout = findViewById(R.id.main)
        Thread {
            var red = 0
            var green = 0
            var blue = 0

            while (true) {
                handler.post {
                    val color = Color.rgb(red, green, blue)
                    rootLayout.setBackgroundColor(color)
                }

                red = (red + 5) % 256
                green = (green + 3) % 256
                blue = (blue + 7) % 256

                Thread.sleep(100)
            }
        }.start()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}