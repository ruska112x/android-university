package org.karabalin.lab8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button2)
        editText = findViewById(R.id.editText)

        button.setOnClickListener {
            val toast = Toast(applicationContext)
            toast.setText(editText.text)
            val callback: Toast.Callback = object: Toast.Callback() {
                override fun onToastShown() {
                    super.onToastShown()
                    editText.text.clear()
                }
            }
            toast.addCallback(callback)
            toast.show()
        }
    }
}