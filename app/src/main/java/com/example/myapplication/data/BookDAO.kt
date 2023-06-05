package com.example.myapplication.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDAO {

    @Upsert
    suspend fun upsertBook(book : Book)


    @Delete
    suspend fun deleteBook(book : Book)

    @Query("Select * FROM book order by")
    suspend fun getBooks():Flow<List<Book>>



    }
