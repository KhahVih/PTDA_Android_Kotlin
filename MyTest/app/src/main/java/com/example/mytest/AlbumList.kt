package com.example.mytest

import android.annotation.SuppressLint
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class AlbumList : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.album_layout)
        val back = findViewById<ImageButton>(R.id.back)
        val heart = listOf(
            findViewById<ImageView>(R.id.heartview),
            findViewById<ImageView>(R.id.heartview2),
            findViewById<ImageView>(R.id.heartview3),
            findViewById<ImageView>(R.id.heartview4),
            findViewById<ImageView>(R.id.heartview5),
            findViewById<ImageView>(R.id.heartview6),
            findViewById<ImageView>(R.id.heartview7)
        )
        val isColor = mutableMapOf<ImageView, Boolean>()

        heart.forEach { imageview ->
            isColor[imageview] = false

            imageview.setOnClickListener{
                val isColorChanged = isColor[imageview] ?: false
                if(isColorChanged){
                    imageview.clearColorFilter()
                }
                else{
                    val colorField: ColorFilter = PorterDuffColorFilter(
                        resources.getColor(R.color.main_pink),
                        PorterDuff.Mode.SRC_IN
                    )
                    imageview.colorFilter = colorField
                }
                isColor[imageview] = !isColorChanged
            }
        }

        back.setOnClickListener{
            finish()
        }
    }
}
