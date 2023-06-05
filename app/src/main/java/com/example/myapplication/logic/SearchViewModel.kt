package com.example.myapplication.logic

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.*
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class SearchViewModel: ViewModel(){

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private var _books = MutableStateFlow(book_data_base)


    var books = searchText
        .debounce(1000L)
        .combine(_books){ text, books->
            if(text.isBlank()){
                books
            }else{
//                // Make API call here
                viewModelScope.launch {
                     try {
                        val data = fetchBookData(searchText)
                        // Handle the successful response and access the data

                        val bookListFromSearch = searchRequest2Book(data)
                        println(data?.totalItems)

                         _books.value = bookListFromSearch

                    } catch (e: Exception) {
                        // Handle the API call failure and display an error message or take appropriate actions
                        Log.d("Error", "Failed to retrieve data from API: ${e.message}")
                    }
                }



                books.filter { it.doesMatchSearchQuery(text) }
            }

        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
                 initialValue = _books.value)




    fun onSearchTextChange(text : String){
        _searchText.value = text
    }
}