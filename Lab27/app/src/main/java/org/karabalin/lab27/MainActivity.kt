package org.karabalin.lab27

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private val REQUEST_CODE_OPEN = 1
    private val REQUEST_CODE_SAVE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edit_text)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_open -> {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "text/plain"
                }
                startActivityForResult(intent, REQUEST_CODE_OPEN)
                true
            }
            R.id.action_save -> {
                val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TITLE, "document.txt")
                }
                startActivityForResult(intent, REQUEST_CODE_SAVE)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && data != null) {
            when(requestCode) {
                REQUEST_CODE_OPEN -> {
                    data.data?.also { uri ->
                        contentResolver.openInputStream(uri)?.bufferedReader().use {
                            editText.setText(it?.readText())
                        }
                    }
                }
                REQUEST_CODE_SAVE -> {
                    data.data?.also { uri ->
                        contentResolver.openOutputStream(uri)?.bufferedWriter().use {
                            it?.write(editText.text.toString())
                        }
                    }
                }
            }
        }
    }
}
