package com.rohitksingh.nytarticles_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var incrementButton : Button
    lateinit var decrementButton : Button
    lateinit var counterTextView: TextView
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        incrementButton = findViewById(R.id.increment)
        decrementButton = findViewById(R.id.decrement)
        counterTextView = findViewById(R.id.counter)

        incrementButton.setOnClickListener(View.OnClickListener {
            counter++
            counterTextView.setText(""+counter)
        })

        decrementButton.setOnClickListener(this)


    }

    fun openActivity(counterValue: String){
        var intent = Intent(this, DetailActivity:: class.java)
        intent.putExtra("COUNTER_VALUE", counterValue)
        startActivity(intent)
    }

    override fun onClick(view: View?) {
        openActivity(" "+counter)
    }

    suspend fun runTimer() = coroutineScope {
        launch {
            delay(3000)
            counterTextView.setText("This is timer")
        }
        println("Hello")
    }

}