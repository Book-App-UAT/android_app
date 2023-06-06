package com.example.myapplication.ui.theme

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.HomeScreen
import com.example.myapplication.ListsScreen
import com.example.myapplication.data.Book
import com.example.myapplication.data.book_data_base

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(book_data_base, navController)
        }
        composable("lists") {
            ListsScreen(navController)
        }

        composable("particular_list" + "/{name_of_list}", arguments = listOf(
            navArgument("name_of_list") {
                type = NavType.StringType
            }
                                                                            )) {
            var list_name = it.arguments?.getString("name_of_list")


            var filtered_list = book_data_base.filter {db-> db.collection == list_name }


            HomeScreen(books2Display = filtered_list, navController = navController)
        }

        composable("search") {
            SearchScreen(navController)
        }

        composable("book_details") {

            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Book>("book")

            //! This is a very bad fix to convert from nullable to nonNullable
            val nonNullableResult: Book = result as? Book
                ?: book_data_base[1]// Provide a fallback Book object if result is null or not of type Book
            println(nonNullableResult.cover_url)
            BookInfo(book = nonNullableResult)

        }
    }
}


