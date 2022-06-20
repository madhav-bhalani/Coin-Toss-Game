package com.example.cointoss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tossButton: Button = findViewById(R.id.button)
        tossButton.setOnClickListener() {
            val toast = Toast.makeText(applicationContext, "Coin Tossed!!", Toast.LENGTH_SHORT)
            toast.show()

            coinToss()
        }


    }

    private fun coinToss() {
        val coin = Coin(2)
        val coinToss = coin.toss()

        val coinImage: ImageView = findViewById(R.id.imageView)

        val resultText: TextView = findViewById(R.id.result)

        if (coinToss == 1) {
            coinImage.setImageResource(R.drawable.heads)
            resultText.text = getString(R.string.heads)
        } else {
            coinImage.setImageResource(R.drawable.tails)
            resultText.text = getString(R.string.tails)
        }
    }
}


class Coin(private var coinSides: Int) {
    fun toss(): Int {
        return (1..coinSides).random()
    }
}