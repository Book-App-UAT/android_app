package com.example.myapplication.data

import android.content.Context
//import androidx.compose.ui.tooling.data.EmptyGroup.name
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object{
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getDatabase(context: Context): BookDatabase{
            //if instance already exists return that instance
            //SINGLETON
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "book_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}