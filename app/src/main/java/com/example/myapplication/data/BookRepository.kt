package com.example.myapplication.data

import androidx.lifecycle.LiveData

class BookRepository(private val bookDao: BookDao) {

    val readAllData: LiveData<List<Book>> = bookDao.readAllData()
    suspend fun addBook(book: Book){
        bookDao.addBook(book)
    }

}