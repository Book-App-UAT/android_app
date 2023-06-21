package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.myapplication.data.BookDataBase
import com.example.myapplication.data.BookViewModel
import com.example.myapplication.data.book_data_base
import com.example.myapplication.data.book_lists
//import com.example.myapplication.data.fetchBookData
import com.example.myapplication.ui.theme.*

//! App files

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(applicationContext,
                            BookDataBase::class.java,
                            "books.db").build()


    }

    private val viewModel by viewModels<BookViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                 fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return  BookViewModel(db.dao) as T
                }
            }
        }
                                                      )


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val state = viewModel.state.collectAsState()
            val navController = rememberNavController()

            Scaffold(
                topBar = { TitleLayout(navController = navController) },
                bottomBar = {
                    BottomLayout(
                        items = listOf(
                            BottomNavItem(
                                name = "Home",
                                route = "home",
                                icon = Icons.Default.Home
                                         ),
                            BottomNavItem(
                                name = "Collections",
                                route = "lists",
                                icon = Icons.Default.List

                                         )
                                      ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
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
fun HomeScreen(navController: NavController) {

    val scrollState = rememberScrollState()

    // Body here
    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.SpaceEvenly
          ) {
        BookDisplayHome(book_data_base[1],navController)
        BookDisplayHome(book_data_base[0],navController)
        BookDisplayHome(book_data_base[2],navController)
    }
}

@Composable
fun ListsScreen() {

    Column(horizontalAlignment = CenterHorizontally) {

        Divider(modifier = Modifier.height(4.dp))

        book_lists.forEach {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
//                .background(Color.Red)
                    .border(border = BorderStroke(width = 1.dp, Color.LightGray))
                    .height(50.dp)
                    .clickable { },
                verticalAlignment = CenterVertically
               )
            {
                Text(text = it.name, modifier = Modifier.padding(horizontal = 25.dp))
            }
            Divider(modifier = Modifier.height(4.dp))

        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                modifier = Modifier.size(40.dp)
                )

        }
    }
}
