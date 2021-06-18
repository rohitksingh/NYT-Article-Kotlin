package com.rohitksingh.nytarticles_kotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rohitksingh.nytarticles_kotlin.R
import com.rohitksingh.nytarticles_kotlin.models.Article

class ArticleListAdapter() : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {

    private var articleList : List<Article> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_article, parent, false)
        return ArticleViewHolder(view)

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article = articleList[position]
        holder.articleHeadline.setText(article.headline)

    }

    override fun getItemCount(): Int = articleList.size

    fun updateItems(newItems: List<Article>){
        articleList = newItems
        notifyDataSetChanged()
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var articleImage: ImageView
        var articleHeadline: TextView

        init{
            articleHeadline = itemView.findViewById(R.id.article_name)
            articleImage = itemView.findViewById(R.id.article_image)
        }

    }
}