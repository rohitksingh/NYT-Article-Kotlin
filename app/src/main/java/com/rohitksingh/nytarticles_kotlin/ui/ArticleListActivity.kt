package com.rohitksingh.nytarticles_kotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.nytarticles_kotlin.R
import com.rohitksingh.nytarticles_kotlin.models.Article

class ArticleListActivity:AppCompatActivity() {

    lateinit var articleRecyclerView : RecyclerView
    lateinit var linearLayoutManager: LinearLayoutManager
    var articleListAdapter: ArticleListAdapter = ArticleListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_articles)
        articleRecyclerView = findViewById(R.id.articleRecyclerView)
        setuprecyclerview()
    }

    private fun setuprecyclerview(){

        articleListAdapter = ArticleListAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        articleRecyclerView.adapter = articleListAdapter
        articleRecyclerView.layoutManager = linearLayoutManager

        articleListAdapter.updateItems(getDummyArticles())

    }

    private fun getDummyArticles(): List<Article>{

        var list = ArrayList<Article>()

        for (i in 1..10){
            val article = Article(headline = "Headline $i", webUrl = "https:google.com/article $i", imageUrl = "https:example.com")
            list.add(article)
        }

        return list

    }

}