package org.karabalin.lab28

import android.content.*
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textViewStatus: TextView
    private lateinit var buttonSend: Button
    private lateinit var customReceiver: MyBroadcastReceiver
    private lateinit var connectivityReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewStatus = findViewById(R.id.text_view_status)
        buttonSend = findViewById(R.id.button_send)

        customReceiver = MyBroadcastReceiver { message ->
            Log.d("MY", message)
            textViewStatus.text = message
        }

        connectivityReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val network = connectivityManager.activeNetwork
                val capabilities = connectivityManager.getNetworkCapabilities(network)
                val isConnected = capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
                textViewStatus.text = if (isConnected) "Connected to Internet" else "Disconnected from Internet"
            }
        }

        buttonSend.setOnClickListener {
            val intent = Intent("org.karabalin.lab28.CUSTOM_ACTION")
            intent.putExtra("message", "Hello from MainActivity!")
            sendBroadcast(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onResume() {
        super.onResume()
        val customFilter = IntentFilter("org.karabalin.lab28.CUSTOM_ACTION")
        registerReceiver(customReceiver, customFilter, RECEIVER_EXPORTED)

        val connectivityFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(connectivityReceiver, connectivityFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(customReceiver)
        unregisterReceiver(connectivityReceiver)
    }
}
