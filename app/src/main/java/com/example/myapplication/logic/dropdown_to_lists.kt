package com.example.myapplication.logic

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.myapplication.data.ListOfBooks
import com.example.myapplication.data.book_lists

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropdownLists() {

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
                 , placeholder = { Text(text = "Add to list")}
                 )

        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {

            book_lists.forEach {

                DropdownMenuItem(
                    onClick = {
                        isExpanded = false
                        list = it
                    },
                                ) {
                    Text(text = it.name)

                }
            }


        }


    }


}