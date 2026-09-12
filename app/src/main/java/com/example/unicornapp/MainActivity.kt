package com.example.unicornapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoryContainer = findViewById<LinearLayout>(R.id.category)
        val inflater = LayoutInflater.from(this)

        val foodListC = listOf(
            foodCategory(R.drawable.khapao, "อาหารตามสั่ง"),
            foodCategory(R.drawable.salad, "สลัด"),
            foodCategory(R.drawable.noodle, "ก๋วยเตี๋ยว"),
            foodCategory(R.drawable.fish_chip, "ของกินเล่น"),
            foodCategory(R.drawable.sushi, "ซูชิ"),
            foodCategory(R.drawable.green_tee, "เครื่องดื่ม")
        )

        for (food in foodListC){
            val categoryView : View = inflater.inflate(R.layout.category_btn, categoryContainer, false)

            val imageBtn: ImageButton = categoryView.findViewById(R.id.btnImage)
            val text: TextView = categoryView.findViewById(R.id.categoryName)

            imageBtn.setImageResource(food.imageID)
            text.text = food.btnName

            categoryView.setOnClickListener {
                Toast.makeText(this, "you select ${food.btnName}", Toast.LENGTH_SHORT).show()
            }

            categoryContainer.addView(categoryView)
        }

    }
}