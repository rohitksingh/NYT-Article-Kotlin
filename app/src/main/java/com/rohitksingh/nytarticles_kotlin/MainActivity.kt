package com.rohitksingh.nytarticles_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var incrementButton : Button
    lateinit var decrementButton : Button
    lateinit var counterTextView: TextView
    var counter = 0
    var timerValue = 10

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

        CoroutineScope(IO)
            .launch {
                fetchresultFromAPI()
            }

        //fetchresultFromAPI()


    }

    private fun openActivity(counterValue: String){
        var intent = Intent(this, FetchUser:: class.java)
        intent.putExtra("COUNTER_VALUE", counterValue)
        startActivity(intent)
    }

    override fun onClick(view: View?) {
        openActivity(" "+counter)
    }


    private suspend fun fetchresultFromAPI(){
        val apiResponse = networkCall()
        show(apiResponse)
    }


    private suspend fun networkCall() : String{
        delay(3000)
        return "This is response from API"
    }

    private suspend fun show(apiResponse: String){
        withContext(Main){
            counterTextView.setText(apiResponse)
        }
    }

    private suspend fun setTextView(apiResponse: String){
        withContext(Main){
            counterTextView.setText(apiResponse)
        }
    }


}