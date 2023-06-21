package com.example.myapplication.data

sealed interface BookEvent{
    data class AddBookToList(val book : Book): BookEvent
    data class RemoveBookFromList(val book : Book): BookEvent
    data class SortBooks(val sortType: SortType): BookEvent
//    data class SetFavourite(val favourite: Boolean): BookEvent
//    data class SetRatingScore(val rating: Int): BookEvent
    object ShowDialog: BookEvent
    object HideDialog: BookEvent

    }