package org.karabalin.lab23

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val webView = findViewById<WebView>(R.id.webView)
        val topicIndex = intent.getIntExtra("topic_index", 0)
        val content = resources.getStringArray(R.array.content)
        webView.loadData(content[topicIndex], "text/html", "UTF-8")
    }
}