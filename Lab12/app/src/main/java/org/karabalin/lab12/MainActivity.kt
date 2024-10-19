package org.karabalin.lab12

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var rootLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        rootLayout = findViewById(R.id.main)
        val popupMenu = PopupMenu(this, button)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.light1 -> {
                    textView.text = "light1"
                    rootLayout.background = ColorDrawable(Color.WHITE)
                }
                R.id.light2 -> {
                    textView.text = "light2"
                    rootLayout.background = ColorDrawable(Color.CYAN)
                }
                R.id.dark1 -> {
                    textView.text = "dark1"
                    rootLayout.background = ColorDrawable(Color.RED)
                }
                R.id.dark2 -> {
                    textView.text = "dark2"
                    rootLayout.background = ColorDrawable(Color.GREEN)
                }
            }
            false
        }

        button.setOnClickListener {
            popupMenu.show()
        }
    }
}