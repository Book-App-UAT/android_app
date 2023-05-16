package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun BottomLayout(){

        Row() {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.padding(end = 5.dp)
            ) {
                Text(text = stringResource(id = R.string.collections), fontSize = 12.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 5.dp,end = 5.dp)
            ) {
                Text(text = stringResource(id = R.string.search), fontSize = 12.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 5.dp,end = 5.dp)
            ) {
                Text(text = stringResource(id = R.string.scan_book), fontSize = 12.sp)
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 5.dp)
            ) {
                Text(text = stringResource(id = R.string.settings), fontSize = 12.sp)
            }
        }
    }
