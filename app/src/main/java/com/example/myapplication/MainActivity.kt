package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.BookDisplayHome
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

//! App files
import com.example.myapplication.ui.theme.BottomLayout
import com.example.myapplication.ui.theme.TitleLayout
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(){

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = { TitleLayout() },
        bottomBar = { BottomLayout()}

    )
    {
        // Body here

        Column(modifier = Modifier.padding(10.dp)
            .verticalScroll(state = scrollState),
                verticalArrangement = Arrangement.SpaceEvenly) {
            BookDisplayHome()
            BookDisplayHome()
            BookDisplayHome()
        }

    }



}
