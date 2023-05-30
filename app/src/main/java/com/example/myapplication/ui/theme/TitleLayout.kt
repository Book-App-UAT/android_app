package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import androidx.compose.ui.Modifier
@Composable
fun TitleLayout(){
    Column() {
        Text(text = stringResource(id = R.string.ereading), fontSize = 32.sp,
            color = Color(color = 0xFFFFC266 ) // First 2 chars of color are opacity
        )

        Text(text = "yeah", fontSize = 32.sp,
            color = Color(color = 0xFFFFC265 )
        )
        Image(painter = painterResource(id = R.drawable.book_logo), contentDescription = "", modifier = Modifier.size(150.dp))
    }
}
