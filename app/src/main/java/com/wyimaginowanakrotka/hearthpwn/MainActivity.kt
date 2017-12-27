package com.wyimaginowanakrotka.hearthpwn

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
        val iii = URL(photo).openStream()
        val options = BitmapFactory.Options()
        options.inSampleSize = 3
        return BitmapFactory.decodeStream(iii,null,options)
    }

    fun articleEnd(begin_index: Int,raw_page: String):Int{
        val page = raw_page.substring(begin_index,raw_page.length)
        val article_end = page.indexOf("</article>")+10
        return article_end + raw_page.substring(0,begin_index).length
    }

    fun displayArticles(strona:String){
        var article_end = 0
        articleOne.text =  articleTitle(article_end,strona)
        imageView1.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleTwo.text =  articleTitle(article_end,strona)
        imageView2.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleThree.text =  articleTitle(article_end,strona)
        imageView3.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleFour.text =  articleTitle(article_end,strona)
        imageView4.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleFive.text =  articleTitle(article_end,strona)
        imageView5.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleSix.text =  articleTitle(article_end,strona)
        imageView6.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleSeven.text =  articleTitle(article_end,strona)
        imageView7.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleEight.text =  articleTitle(article_end,strona)
        imageView8.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleNine.text =  articleTitle(article_end,strona)
        imageView9.setImageBitmap(articlePhoto(article_end,strona))
        article_end = articleEnd(article_end,strona)
        articleTen.text =  articleTitle(article_end,strona)
        imageView10.setImageBitmap(articlePhoto(article_end,strona))
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
