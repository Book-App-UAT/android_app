package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.logic.SearchViewModel

@Composable
fun SearchScreen(navController: NavController) {

    val viewModel = viewModel<SearchViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val books by viewModel.books.collectAsState()
//    val books by viewModel.bookAPIList.collectAsState()

    val isSearching by viewModel.isSearching.collectAsState()


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search")}
                 )
        Spacer(modifier = Modifier.height(20.dp))

        if(isSearching){
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else
        {
            if(searchText.isNotBlank()){
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)){

                    items(books){book->
                        BookDisplayHome(book = book, navController = navController)
                    }
                }
            }

        }


        
        
        
        
    }


}