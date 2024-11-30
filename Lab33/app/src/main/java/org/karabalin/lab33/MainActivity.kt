package org.karabalin.lab33

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fruitAdapter: FruitAdapter
    private val fruitList = listOf(
        "Apple",
        "Banana",
        "Cherry",
        "Date",
        "Elderberry",
        "Fig",
        "Grape",
        "Honeydew",
        "Indian Fig",
        "Jackfruit",
        "Kiwi",
        "Lemon",
        "Mango",
        "Nectarine",
        "Orange",
        "Papaya",
        "Quince",
        "Raspberry",
        "Strawberry",
        "Tomato",
        "Ugli Fruit",
        "Vanilla",
        "Watermelon",
        "Xigua",
        "Yellow Passion Fruit",
        "Zucchini"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view_fruits)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fruitAdapter = FruitAdapter(fruitList) { selectedFruit ->
            Toast.makeText(this, "Selected: $selectedFruit", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = fruitAdapter
    }
}
