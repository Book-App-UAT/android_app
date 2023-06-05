package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.data.Book
import com.example.myapplication.data.book_data_base
import com.example.myapplication.logic.DropdownLists

@Composable
fun BookInfo(book: Book) {

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
          ) {
        if (book.cover_url.isBlank()) {
            Image(
                painter = painterResource(id = book.cover_id),
                contentDescription = "",
                modifier = Modifier
                    .height(250.dp)
                    .padding(top = 5.dp)
                 )
        } else {
            AsyncImage(
                model = book.cover_url,
                contentDescription = "",
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 5.dp)
                      )
        }

        Text(text = book.title.toString())

        Row() {
            Text(text = book.author + " | " + book.n_pages + " pages")
        }

        Spacer(modifier = Modifier.size(10.dp))

        DropdownLists()

        Text(
            text = "Description",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 10.dp)
            )

        Spacer(modifier = Modifier.size(3.dp))

        LazyColumn(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .shadow(elevation = 1.dp, shape = RoundedCornerShape(3.dp)),
            contentPadding = PaddingValues(bottom = 16.dp) // Adjust the bottom padding to leave the desired gap
                  ) {

            item {
                Text(
                    text = book.description.toString(), modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 5.dp)
                    )
            }

            item {
                Spacer(modifier = Modifier.height(5.dp)) // Adjust the height value to create the desired gap
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun BookInfoPreview() {
    BookInfo(book_data_base[1])
}
