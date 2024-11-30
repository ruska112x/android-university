package org.karabalin.lab32

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MyAlertDialogFragment.AlertDialogListener {
    private lateinit var showDialogButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showDialogButton = findViewById(R.id.button_show_dialog)
        showDialogButton.setOnClickListener {
            val dialog = MyAlertDialogFragment()
            dialog.show(supportFragmentManager, "MyAlertDialogFragment")
        }
    }

    override fun onDialogPositiveClick() {
        Toast.makeText(this, "Positive button clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onDialogNegativeClick() {
        Toast.makeText(this, "Negative button clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onDialogNeutralClick() {
        Toast.makeText(this, "Neutral button clicked", Toast.LENGTH_SHORT).show()
    }
}
