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
import com.example.myapplication.data.Book
import com.example.myapplication.data.book_data_base

@Composable
fun BookDisplayHome(book: Book,navController: NavController) {
//Book "category"
    Column(
        modifier = Modifier

          ) {
        // Book info
        Text(text = "Currently Reading H")
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
            Image(
                painter = painterResource(book.cover_id), contentDescription = "",
                modifier = Modifier.size(150.dp)
                 )

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

                //List - Should be dropdown list
                Text("list")
            }
        }
    }


}

