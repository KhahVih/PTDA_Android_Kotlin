package com.example.mytest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.VideoView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val albumButtons = listOf(
            findViewById<ImageButton>(R.id.albumlist),
            findViewById<ImageButton>(R.id.albumlist2),
            findViewById<ImageButton>(R.id.albumlist3),
            findViewById<ImageButton>(R.id.albumlist4)
        )
        val search = findViewById<EditText>(R.id.search)

        // Set click listener for each button
        albumButtons.forEach { albumButton ->
            albumButton.setOnClickListener {
                val intent = Intent(this, AlbumList::class.java)
                startActivity(intent)
            }
        }
    }
}

