package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {
    //Inserting Data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBook(book: Book)

    //Reading all Data
    @Query("SELECT * FROM book_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Book>>
}