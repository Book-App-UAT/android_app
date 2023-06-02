package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
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
import androidx.navigation.NavController

@Composable
fun TitleLayout(navController: NavController) {
    Row(
        modifier = Modifier
            .height(60.dp)
            .background(color = Color(color = 0xFFFFC265))
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
       ) {

        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.Start
           ) {

            IconButton(onClick = {
                navController.popBackStack()}) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                    )
            }
        }
        Row(modifier = Modifier,
           horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.app_logo_no_background),
                contentDescription = "",
                modifier = Modifier
                    .scale(1.3f),
                 )
        }

        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.End
           ) {
            IconButton(onClick = { navController.navigate("search")}) {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = "",
                    modifier = Modifier.size(30.dp)
                    )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                    )
            }
        }
    }
}
