package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun BottomLayout() {

    Row(modifier = Modifier
                    .fillMaxWidth()
        ) {

        BottomNavigation(elevation = 12.dp,
                         backgroundColor = Color(color = 0xFFc7a13a)) {

            // Home button
            BottomNavigationItem(selected = true ,
                                 onClick = {},
                                 icon = {
                                     Icon(imageVector = Icons.Default.Home, contentDescription = "")
                                 }
            )

            // Lists button
            BottomNavigationItem(selected = false ,
                onClick = {},
                icon = {
                    Icon(painter = painterResource(id =R.drawable.books), contentDescription = "", modifier = Modifier.size(24.dp))
                }
            )

        }


    }
    
    
}



