package com.slack.jeanpokou.datafrominternet

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.slack.jeanpokou.datafrominternet.utilities.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.net.URL

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

     private fun makeGitHubSearchQuery() {
        val url  =  NetworkUtils.buildUrl(et_search_box.text.toString())
        tv_url_display.text =url.toString()
        tv_github_search_results_json.text = NetworkUtils.getResponseFromHttpUrl(url)
    }

    private fun showErrorMessage() {
        tv_error_message_display.visibility = View.VISIBLE
        tv_github_search_results_json.visibility = View.INVISIBLE
    }

    private fun showJsonDataView() {
        tv_error_message_display.visibility = View.INVISIBLE
        tv_github_search_results_json.visibility = View.VISIBLE
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

//        if(item!!.itemId == R.id.action_search){
//            toast("Item  search clicked")
//        }
        when(item!!.itemId) {
            R.id.action_search ->{
                toast("Item  search clicked")
                //      makeGitHubSearchQuery()
                val url  =  NetworkUtils.buildUrl(et_search_box.text.toString())
                GitHubQueryTask().execute(url)
            }

        }
        return super.onContextItemSelected(item)
    }

     inner class GitHubQueryTask : AsyncTask<URL, Void, String>() {

         override fun onPreExecute() {
             pb_loading_indicator.visibility = View.VISIBLE
             super.onPreExecute()
         }
        override fun doInBackground(vararg p0: URL?): String {
             return NetworkUtils.getResponseFromHttpUrl(p0[0])

        }

        override fun onPostExecute(result: String?) {
            pb_loading_indicator.visibility = View.INVISIBLE
            if(result != null && result != ""){
                showJsonDataView()
                tv_github_search_results_json.text = result
            } else {
                showErrorMessage()
            }
        }

    }
}


