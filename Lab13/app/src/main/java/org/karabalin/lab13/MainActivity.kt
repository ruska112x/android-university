package org.karabalin.lab13

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var minusButton: Button
    private lateinit var plusButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        minusButton = findViewById(R.id.minusButton)
        plusButton = findViewById(R.id.plusButton)


        if (!Settings.System.canWrite(this)) {
            val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
            intent.data = Uri.parse("package:$packageName")
            startActivityForResult(intent, 0)
        } else {
            updateBrightnessValue()
        }

        minusButton.setOnClickListener {
            changeSystemBrightness(-10)
        }

        plusButton.setOnClickListener {
            changeSystemBrightness(10)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (Settings.System.canWrite(this)) {
            Toast.makeText(this, "Разрешение получено", Toast.LENGTH_SHORT).show()
            updateBrightnessValue()
        } else {
            Toast.makeText(this, "Разрешение не предоставлено", Toast.LENGTH_SHORT).show()
        }
    }

    private fun changeSystemBrightness(delta: Int) {
        if (!Settings.System.canWrite(this)) {
            Toast.makeText(this, "Нет разрешения на изменение настроек системы", Toast.LENGTH_SHORT)
                .show()
            return
        }

        try {
            val cResolver = contentResolver
            val brightness = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS)
            var newBrightness = brightness + delta
            if (newBrightness < 0) newBrightness = 0
            if (newBrightness > 255) newBrightness = 255

            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, newBrightness)
            Toast.makeText(this, "Яркость установлена на $newBrightness", Toast.LENGTH_SHORT).show()


            textView.text = "Текущая яркость экрана: $newBrightness"
        } catch (e: Settings.SettingNotFoundException) {
            e.printStackTrace()
        }
    }

    private fun updateBrightnessValue() {
        try {
            val cResolver = contentResolver
            val brightness = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS)
            textView.text = "Текущая яркость экрана: $brightness"
        } catch (e: Settings.SettingNotFoundException) {
            e.printStackTrace()
        }
    }
}
