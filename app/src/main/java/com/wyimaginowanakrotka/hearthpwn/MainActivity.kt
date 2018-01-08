package com.wyimaginowanakrotka.hearthpwn

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import android.os.StrictMode
import android.view.View
import android.graphics.BitmapFactory


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                articleOne.visibility = View.GONE
                articleTwo.visibility = View.GONE
                articleThree.visibility = View.GONE
                articleFour.visibility = View.GONE
                articleFive.visibility = View.GONE
                articleSix.visibility = View.GONE
                articleSeven.visibility = View.GONE
                articleEight.visibility = View.GONE
                articleNine.visibility = View.GONE
                articleTen.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                articleOne.visibility = View.VISIBLE
                articleTwo.visibility = View.VISIBLE
                articleThree.visibility = View.VISIBLE
                articleFour.visibility = View.VISIBLE
                articleFive.visibility = View.VISIBLE
                articleSix.visibility = View.VISIBLE
                articleSeven.visibility = View.VISIBLE
                articleEight.visibility = View.VISIBLE
                articleNine.visibility = View.VISIBLE
                articleTen.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                articleOne.visibility = View.GONE
                articleTwo.visibility = View.GONE
                articleThree.visibility = View.GONE
                articleFour.visibility = View.GONE
                articleFive.visibility = View.GONE
                articleSix.visibility = View.GONE
                articleSeven.visibility = View.GONE
                articleEight.visibility = View.GONE
                articleNine.visibility = View.GONE
                articleTen.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    fun articleTitle( begin_index:Int,raw_page:String ):String{
        val page = raw_page.substring(begin_index,raw_page.length)
        val article_start = page.indexOf("<article>")
        val article_end = page.indexOf("</article>")+10
        val article = page.substring(article_start,article_end)
        val rawTitle = article.substring(article.indexOf("<h2>")+4,article.indexOf("</h2>"))
        val title = rawTitle.substring(rawTitle.indexOf(">")+1,rawTitle.indexOf("</a>"))
        return title
    }

    fun articlePhoto( begin_index:Int,raw_page:String ): Bitmap?{
        val page = raw_page.substring(begin_index,raw_page.length)
        val article_start = page.indexOf("<article>")
        val page_article = page.substring(article_start,page.length)
        val photo_start = page_article.indexOf("<img src")+10
        val photo_end = page_article.indexOf(".jpeg")+5
        val photo = page_article.substring(photo_start,photo_end)
        val iii = URL(photo + "?quality=10").openStream()
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        return BitmapFactory.decodeStream(iii,null,options)
    }

    fun articleEnd(begin_index: Int,raw_page: String):Int{
        val page = raw_page.substring(begin_index,raw_page.length)
        val article_end = page.indexOf("</article>")+10
        return article_end + raw_page.substring(0,begin_index).length
    }

    fun articleUrl(begin_index: Int,raw_page: String):String{
        val page = raw_page.substring(begin_index,raw_page.length)
        val article_start = page.indexOf("<article>")
        val article_end = page.indexOf("</article>")+10
        val article = page.substring(article_start,article_end)
        val rawUrl = article.substring(article.indexOf("<h2>")+4,article.indexOf("</h2>"))
        val url = rawUrl.substring(rawUrl.indexOf("href=")+6,rawUrl.indexOf(">")-1)
        return url
    }



    fun displayArticles(strona:String){
        val article_end0 = 0
        articleOne.text =  articleTitle(article_end0,strona)
        articleOne.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end0,strona))
            intent.putExtra("articleImage", articlePhoto(article_end0,strona))
            intent.putExtra("articleTitle", articleTitle(article_end0,strona))
            startActivity(intent)
        }
        val article_end1 = articleEnd(article_end0,strona)
        articleTwo.text =  articleTitle(article_end1,strona)
        articleTwo.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end1,strona))
            intent.putExtra("articleImage", articlePhoto(article_end1,strona))
            intent.putExtra("articleTitle", articleTitle(article_end1,strona))
            startActivity(intent)
        }
        val article_end2 = articleEnd(article_end1,strona)
        articleThree.text =  articleTitle(article_end2,strona)
        articleThree.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end2,strona))
            intent.putExtra("articleImage", articlePhoto(article_end2,strona))
            intent.putExtra("articleTitle", articleTitle(article_end2,strona))
            startActivity(intent)
        }
        val article_end3 = articleEnd(article_end2,strona)
        articleFour.text =  articleTitle(article_end3,strona)
        articleFour.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end3,strona))
            intent.putExtra("articleImage", articlePhoto(article_end3,strona))
            intent.putExtra("articleTitle", articleTitle(article_end3,strona))
            startActivity(intent)
        }
        val article_end4 = articleEnd(article_end3,strona)
        articleFive.text =  articleTitle(article_end4,strona)
        articleFive.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end4,strona))
            intent.putExtra("articleImage", articlePhoto(article_end4,strona))
            intent.putExtra("articleTitle", articleTitle(article_end4,strona))
            startActivity(intent)
        }
        val article_end5 = articleEnd(article_end4,strona)
        articleSix.text =  articleTitle(article_end5,strona)
        articleSix.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end5,strona))
            intent.putExtra("articleImage", articlePhoto(article_end5,strona))
            intent.putExtra("articleTitle", articleTitle(article_end5,strona))
            startActivity(intent)
        }
        val article_end6 = articleEnd(article_end5,strona)
        articleSeven.text =  articleTitle(article_end6,strona)
        articleSeven.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end6,strona))
            intent.putExtra("articleImage", articlePhoto(article_end6,strona))
            intent.putExtra("articleTitle", articleTitle(article_end6,strona))
            startActivity(intent)
        }
        val article_end7 = articleEnd(article_end6,strona)
        articleEight.text =  articleTitle(article_end7,strona)
        articleEight.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end7,strona))
            intent.putExtra("articleImage", articlePhoto(article_end7,strona))
            intent.putExtra("articleTitle", articleTitle(article_end7,strona))
            startActivity(intent)
        }
        val article_end8 = articleEnd(article_end7,strona)
        articleNine.text =  articleTitle(article_end8,strona)
        articleNine.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end8,strona))
            intent.putExtra("articleImage", articlePhoto(article_end8,strona))
            intent.putExtra("articleTitle", articleTitle(article_end8,strona))
            startActivity(intent)
        }
        val article_end9 = articleEnd(article_end8,strona)
        articleTen.text =  articleTitle(article_end9,strona)
        articleTen.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("articleUrl", articleUrl(article_end9,strona))
            intent.putExtra("articleImage", articlePhoto(article_end9,strona))
            intent.putExtra("articleTitle", articleTitle(article_end9,strona))
            startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var page_number = 1
        var strona = URL("http://www.hearthpwn.com/?page="+page_number).readText()
        displayArticles(strona)
        prev_butt.setOnClickListener{
            if (page_number>1){
                page_number-=1
                strona = URL("http://www.hearthpwn.com/?page="+page_number).readText()
                displayArticles(strona)
            }
        }
        next_butt.setOnClickListener {
            page_number+=1
            strona = URL("http://www.hearthpwn.com/?page="+page_number).readText()
            displayArticles(strona)
        }


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
