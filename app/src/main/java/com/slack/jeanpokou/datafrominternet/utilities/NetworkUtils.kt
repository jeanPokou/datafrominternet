package com.slack.jeanpokou.datafrominternet.utilities

import android.net.Uri
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class NetworkUtils {

    companion object {
        val GITHUB_BASE_URL ="https://api.github.com/search/repositories"
        val PARAM_QUERY="q"
        /**
         * The sort field. One of stars, forks, or updated.
         * Default: results are sorted by best match if no field is specified.
         */
        val PARAM_SORT="sort"
        val sortBy = "stars"


        /**
         * Builds the URL used to query Github.
         *
         * @param githubSearchQuery The keyword that will be queried for.
         * @return The URL to use to query the weather server.
         */
        fun buildUrl(githubSearchQuery : String) : URL? {

            val builtUri = Uri.parse(GITHUB_BASE_URL)
                    .buildUpon()
                    .appendQueryParameter(PARAM_QUERY,githubSearchQuery)
                    .appendQueryParameter(PARAM_SORT, sortBy)
                    .build()

            var url : URL? = null
            try {
                url = URL(builtUri!!.toString())
            } catch ( ex :MalformedURLException) {
                ex.printStackTrace()
            }
            return url;

        }

        fun getResponseFromHttpUrl( url : URL)  : String {
            val connection = url.openConnection() as HttpURLConnection
             return connection.inputStream.bufferedReader().use {
                it.readText()
            }
        }
    }

}