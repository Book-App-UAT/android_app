package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TitleLayout()
            BottomLayout()
        }
    }
}

@Composable
fun TitleLayout(){
    Column() {
        Text(text = stringResource(id = R.string.ereading), fontSize = 32.sp,
            color = Color(color = 0xFFFFC266 ) // First 2 chars of color are opacity
        )

        Text(text = "yeah", fontSize = 32.sp,
            color = Color(color = 0xFFFFC265 )
        )
    }
}
@Composable
fun BottomLayout(){

    // TODO  Not adequate, cant get buttons down with row :c

    Box( Modifier.fillMaxSize(), // Without this the row goes to the top?
        contentAlignment = Alignment.BottomCenter) {

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
}
