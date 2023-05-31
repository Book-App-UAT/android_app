package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.*

//! App files

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            Scaffold(
                topBar = { TitleLayout() },
                bottomBar = {
                    BottomLayout(
                        items = listOf(
                            BottomNavItem(
                                name = "Home",
                                route = "home",
                                icon = Icons.Default.Home
                                         ),
                            BottomNavItem (
                                name = "Collections",
                                route = "lists",
                                icon = Icons.Default.KeyboardArrowDown
                                )
                                      ),
                    navController = navController,
                    onItemClick = { navController.navigate(it.route) }
                    )
                }

                    )
            {
                Navigation(navController = navController)
            }


        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    val scrollState = rememberScrollState()

        // Body here
        Column(
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(state = scrollState),
            verticalArrangement = Arrangement.SpaceEvenly
              ) {
            BookDisplayHome()
            BookDisplayHome()
            BookDisplayHome()
        }
    }

@Composable
fun ListsScreen() {

    BookDisplayHome()
    BookDisplayHome()

}
