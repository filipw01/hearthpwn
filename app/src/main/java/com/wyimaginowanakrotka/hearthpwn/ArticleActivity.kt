package com.wyimaginowanakrotka.hearthpwn

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class ArticleActivity : AppCompatActivity() {




    fun normalizeArticle(article:String):String{
        var edited = article.replace(Regex("\\<.*?\\>"),"")
        edited = edited.replace(Regex("\\&.*?\\;"),"")
        return edited
    }

    fun openArticle(articleUrl:String):String{
        val article = URL(articleUrl).readText()
        val articleContent_start = article.indexOf("<!-- CONTENT -->")+13
        val articleContent_end = article.indexOf("<!-- FOOTER -->")-1
        val articleContent = article.substring(articleContent_start,articleContent_end)
        val articleTrueContent = articleContent.substring(articleContent.indexOf("<p>")+3,articleContent.length)
        return normalizeArticle(articleTrueContent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val articleUrl = intent.getStringExtra("articleUrl")
        val articlePhoto = intent.getParcelableExtra<Bitmap>("articleImage")
        val title = intent.getStringExtra("articleTitle")
        articleContent.text=openArticle(articleUrl)
        articleImage.setImageBitmap(articlePhoto)
        articleTitle.text=title

    }

}
