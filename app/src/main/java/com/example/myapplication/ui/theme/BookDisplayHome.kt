package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.myapplication.data.Book
import com.example.myapplication.data.book_data_base
import coil.compose.rememberAsyncImagePainter as rememberAsyncImagePainter

@Composable
fun BookDisplayHome(book: Book,navController: NavController) {
//Book "category"
    Column(
        modifier = Modifier

          ) {
        // Book info
        Spacer(modifier = Modifier.size(10.dp))
        Row(modifier = Modifier
            .background(color = Color(0xFFedd89d))
            .fillMaxWidth()
            .clickable {

                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "book",
                    value = book
                                                                          )
                navController.navigate("book_details")
            }
           ) {
            //Book cover
            if(book.cover_url.isBlank()){
                Image(
                    painter = painterResource(book.cover_id), contentDescription = "",
//                    painter = painterResource(R.drawable.dune_cover), contentDescription = "",
                    modifier = Modifier.size(150.dp)
                     )
            }else{
                AsyncImage(model = book.cover_url, contentDescription = "", modifier = Modifier.size(150.dp))
            }

            Spacer(modifier = Modifier.width(16.dp))
            // Book details
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                  ) {

                //Book title
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = book.title)
                Spacer(modifier = Modifier.height(10.dp))

                // Author
                Text(text = book.author)
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
    }


}

