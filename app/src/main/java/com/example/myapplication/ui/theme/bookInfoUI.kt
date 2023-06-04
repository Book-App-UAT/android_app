package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Book
import com.example.myapplication.data.book_data_base

@Composable
fun BookInfo(book: Book) {

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
          ) {
        Image(
            painter = painterResource(id = book.cover_id),
            contentDescription = "",
            modifier = Modifier.height(400.dp)
             )

        Text(text = book.title)

        Row() {
            Text(text = book.author + " | " + book.n_pages + " pages")
        }

        Divider(modifier = Modifier.size(10.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(bottom = 100.dp).shadow(elevation = 1.dp,shape = RoundedCornerShape(3.dp)),
            contentPadding = PaddingValues(bottom = 16.dp) // Adjust the bottom padding to leave the desired gap
                  ) {

            item{
                Text(text = book.description, modifier = Modifier
                    .padding(horizontal = 15.dp))
            }

            item {
                Spacer(modifier = Modifier.height(15.dp)) // Adjust the height value to create the desired gap
            }
        }

        Row(modifier = Modifier.height(50.dp)) {
            Text(text = "OLA")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BookInfoPreview() {
    BookInfo(book_data_base[1])
}
