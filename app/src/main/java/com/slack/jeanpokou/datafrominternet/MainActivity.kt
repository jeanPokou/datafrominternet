package com.slack.jeanpokou.datafrominternet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            R.id.action_search ->{
               toast("Item  search clicked")
            }

        }
        return super.onContextItemSelected(item)
    }
}


