package com.slack.jeanpokou.datafrominternet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.slack.jeanpokou.datafrominternet.utilities.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main,menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

//        if(item!!.itemId == R.id.action_search){
//            toast("Item  search clicked")
//        }
        when(item!!.itemId) {
            R.id.action_search ->{
               toast("Item  search clicked")
                 tv_url_display.text = NetworkUtils.buildUrl(et_search_box.text.toString()).toString()

            }

        }
        return super.onContextItemSelected(item)
    }
}


