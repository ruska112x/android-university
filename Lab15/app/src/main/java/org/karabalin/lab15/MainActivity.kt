package org.karabalin.lab15

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var radioButton4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioButton3 = findViewById(R.id.radioButton3)
        radioButton4 = findViewById(R.id.radioButton4)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                Toast.makeText(
                    applicationContext, "Введите длину кого-нибудь", Toast.LENGTH_LONG
                ).show()
            } else {
             val inputVal = editText.text.toString().toFloat()
                if (radioButton1.isChecked) {
                    editText.setText(meterToCat(inputVal).toString())
                } else if (radioButton2.isChecked) {
                    editText.setText(catToMeter(inputVal).toString())
                } else if (radioButton3.isChecked) {
                    editText.setText(meterToHamster(inputVal).toString())
                } else {
                    editText.setText(hamsterToMeter(inputVal).toString())
                }
            }
        }
    }

    private fun meterToCat(input: Float): Float = (input / 0.46).toFloat()

    private fun catToMeter(input: Float): Float = (input * 0.46).toFloat()

    private fun meterToHamster(input: Float): Float = (input / 0.05).toFloat()

    private fun hamsterToMeter(input: Float): Float = (input * 0.05).toFloat()
}