package com.example.rd_modul34_pember.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rd_modul34_pember.data.dao.ClubDao
import com.example.rd_modul34_pember.data.entity.Club

@Database(entities = [Club::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clubDao(): ClubDao

    companion object{
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            if (instance==null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java,"app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}