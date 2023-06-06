package com.example.myapplication.logic

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.myapplication.data.Book
import com.example.myapplication.data.ListOfBooks
import com.example.myapplication.data.book_data_base
import com.example.myapplication.data.book_lists

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropdownLists(currentBook : Book) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var list by remember {
        mutableStateOf<ListOfBooks?>(null)
    }

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = it }) {

        TextField(value = list?.name ?: "", onValueChange = {}, readOnly = true, trailingIcon = {
            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
        }, colors = ExposedDropdownMenuDefaults.textFieldColors()
                 , placeholder = {
                if (currentBook.collection.isBlank()) {
                    Text(text = "Add to list")
                } else {
                    Text(text = currentBook.collection)
                }
            }
                 )

        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {

            book_lists.forEach {

                DropdownMenuItem(
                    onClick = {
                        isExpanded = false
                        list = it
                        if(!book_data_base.contains(currentBook)){
                                currentBook.collection = it.name
                                book_data_base.add(currentBook)
                            }
                        else{
                            book_data_base.forEach{db_book->
                                if(db_book.title == currentBook.title){
                                    db_book.collection = it.name
                                }
                            }

                        }


                    },
                                ) {
                    Text(text = it.name)

                }
            }


        }


    }


}