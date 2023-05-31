package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale

@Composable
fun TitleLayout() {
    Row(
        modifier = Modifier
            .height(80.dp)
            .background(color = Color(color = 0xFFFFC265))
            .fillMaxWidth()
            , horizontalArrangement = Arrangement.Center
       ) {

        Image(
            painter = painterResource(id = R.drawable.app_logo_no_background),
            contentDescription = "",
            modifier = Modifier.scale(1.6f)
             )
    }
}
