package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Book::class],
         version = 1)
abstract class BookDataBase : RoomDatabase() {

    abstract val dao : BookDAO
}