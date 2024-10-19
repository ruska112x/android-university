package org.karabalin.lab11

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.button -> {
                findViewById<TextView>(R.id.textView).text = "You choose Numbers!"
            }
            R.id.actionSettings -> {
                val newIntent = Intent(this@MainActivity, SettingActivity::class.java)
                startActivity(newIntent)
                return true
            }
            R.id.exitButton -> {
                finish()
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}