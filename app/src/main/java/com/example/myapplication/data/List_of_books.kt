package com.example.myapplication.data


data class ListOfBooks(
    val name: String,
    val books: MutableList<Book>
                      )

var book_lists = mutableListOf<ListOfBooks>(
    ListOfBooks( "Currently reading", mutableListOf<Book>(book_data_base[1])),

    ListOfBooks( "Read", mutableListOf<Book>(book_data_base[1])),

    ListOfBooks( "Want to read", mutableListOf<Book>(book_data_base[1])),

    ListOfBooks( "Favourites", mutableListOf<Book>(book_data_base[1]))
)

