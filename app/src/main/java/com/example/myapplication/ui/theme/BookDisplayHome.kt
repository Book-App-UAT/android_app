package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray

@Composable
fun BookDisplayHome(){
//Book "category"
    Column(modifier = Modifier

        ) {
        // Book info
        Text(text = "Currently Reading H")
        Row(modifier = Modifier
            .background(color = Color(0xFFedd89d))
            .fillMaxWidth()
            ) {
            //Book cover
            Image(painter = painterResource(id = R.drawable.dune_cover), contentDescription ="",
            modifier = Modifier.size(150.dp))

            Spacer(modifier = Modifier.width(16.dp))
            // Book details
            Column(verticalArrangement = Arrangement.SpaceEvenly,
                   ) {

                //Book title
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Title")
                Spacer(modifier = Modifier.height(10.dp))

                // Author
                Text(text = "Author")
                Spacer(modifier = Modifier.height(10.dp))

                //List - Should be dropdown list
                Text("list")
            }
        }
    }


}
@Preview(showBackground = true)
@Composable
fun BookDisplayPreview() {
    BookDisplayHome()
}
