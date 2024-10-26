package org.karabalin.lab18

import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grassImageView: ImageView = findViewById(R.id.grass)

        val sunImageView: ImageView = findViewById(R.id.sunImageView)
        val riseAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.rise)
        val dawnAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.dawn)

        grassImageView.setOnClickListener {
            Log.i("MyOwnLog", "TAPTAPTAP $i")
            when (i) {
                0 -> {
                    sunImageView.startAnimation(riseAnimation)
                }
                else -> {
                    sunImageView.startAnimation(dawnAnimation)
                }
            }

            i = (i + 1) % 2
        }
    }
}