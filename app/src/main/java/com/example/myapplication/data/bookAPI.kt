package com.example.myapplication.data

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

suspend fun fetchBookData(searchText: StateFlow<String>): SearchRequest? {
    return withContext(Dispatchers.IO) {
        try {
            val url = URL("https://www.googleapis.com/books/v1/volumes?q=${searchText.value}")
            val connection = url.openConnection() as HttpURLConnection

            if (connection.responseCode == 200) {
                val inputSystem = connection.inputStream
                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
//                val request: List<SearchRequest> = Gson().fromJson(inputStreamReader, Array<SearchRequest>::class.java).toList()
                val request = Gson().fromJson(inputStreamReader, SearchRequest::class.java)

                inputStreamReader.close()
                inputSystem.close()

                request
            } else {
                throw Exception("Failed to retrieve data from API")
            }
        } catch (e: Exception) {
            throw e
        }
    }
}
