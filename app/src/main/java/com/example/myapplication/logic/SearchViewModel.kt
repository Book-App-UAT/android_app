package com.example.myapplication.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.book_data_base
import kotlinx.coroutines.flow.*

class SearchViewModel:ViewModel(){

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _books = MutableStateFlow(book_data_base)
    val books = searchText
        .combine(_books){ text, books->
            if(text.isBlank()){
                books
            }else{

                books.filter { it.doesMatchSearchQuery(text) }
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
                 initialValue = _books.value)


    fun onSearchTextChange(text : String){
        _searchText.value = text
    }
}