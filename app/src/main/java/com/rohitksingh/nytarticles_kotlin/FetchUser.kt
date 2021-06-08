package com.rohitksingh.nytarticles_kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main



class FetchUser : AppCompatActivity() {

    lateinit var userTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        userTextView = findViewById(R.id.counter)

        CoroutineScope(IO)
            .launch {
                fetchAndShowUserDetail()
            }

    }

    private suspend fun fetchAndShowUserDetail(){
        var user = fetchUser()
        showUser(user)
    }

    //Fetch user from USER API
    private suspend fun fetchUser() : User{
        return GlobalScope.async(IO) {
            delay(3000)
            User("Rohit", "r4rohit002@gmail.com")
        }.await()
    }


    private suspend fun showUser(user: User){
        withContext(Main){
            userTextView.setText(user.email)
        }
    }

}


// Data class
data class User(val name: String, val email: String)