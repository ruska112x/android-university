package org.karabalin.lab09

import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var catImage: ImageView
    private lateinit var duckImage: ImageView
    private lateinit var sheepImage: ImageView
    private lateinit var dogImage: ImageView
    private lateinit var cowImage: ImageView
    private lateinit var chickenImage: ImageView

    private lateinit var soundPool: SoundPool
    private lateinit var assetManager: AssetManager

    private var catSound: Int = 0
    private var duckSound: Int = 0
    private var sheepSound: Int = 0
    private var dogSound: Int = 0
    private var cowSound: Int = 0
    private var chickenSound: Int = 0

    private var streamId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catImage = findViewById(R.id.imageCat)
        duckImage = findViewById(R.id.imageDuck)
        sheepImage = findViewById(R.id.imageSheep)
        dogImage = findViewById(R.id.imageDog)
        cowImage = findViewById(R.id.imageCow)
        chickenImage = findViewById(R.id.imageChicken)

        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(attributes)
            .build()

        assetManager = assets

        catSound = soundPool.load(application.assets.openFd("cat.ogg"), 1)
        duckSound = soundPool.load(application.assets.openFd("duck.ogg"), 1)
        sheepSound = soundPool.load(application.assets.openFd("sheep.ogg"), 1)
        dogSound = soundPool.load(application.assets.openFd("dog.ogg"), 1)
        cowSound = soundPool.load(application.assets.openFd("cow.ogg"), 1)
        chickenSound = soundPool.load(application.assets.openFd("chicken.ogg"), 1)

        catImage.setOnClickListener { playSound(catSound) }
        duckImage.setOnClickListener { playSound(duckSound) }
        sheepImage.setOnClickListener { playSound(sheepSound) }
        dogImage.setOnClickListener { playSound(dogSound) }
        cowImage.setOnClickListener { playSound(cowSound) }
        chickenImage.setOnClickListener { playSound(chickenSound) }
    }

    private fun playSound(sound: Int): Int {
        if (sound > 0) {
            streamId = soundPool.play(sound, 1F, 1F, 1, 0, 1F)
        }
        return streamId
    }
}