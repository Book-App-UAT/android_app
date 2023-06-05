package com.example.myapplication.data

sealed interface BookEvent{

    object AddBookToList: BookEvent


}