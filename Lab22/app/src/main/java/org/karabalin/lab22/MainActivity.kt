package org.karabalin.lab22

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLocation = findViewById<Button>(R.id.buttonLocation)
        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        val buttonMarker = findViewById<Button>(R.id.buttonMarker)

        buttonLocation.setOnClickListener {
            val uri = String.format("geo:%f,%f", 54.983334, 73.366669)
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        }

        buttonSearch.setOnClickListener {
            val uri = "geo:0,0?q=restaurants"
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(uri)
            )
            startActivity(intent)
        }

        buttonMarker.setOnClickListener {
            val uri = String.format(
                "geo:%f,%f?q=%f,%f(Label)",
                54.983334, 73.366669,
                54.983334, 73.366669
            )
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(uri)
            )
            startActivity(intent)
        }
    }
}