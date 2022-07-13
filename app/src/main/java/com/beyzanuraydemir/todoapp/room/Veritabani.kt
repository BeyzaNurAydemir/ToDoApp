package com.beyzanuraydemir.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beyzanuraydemir.todoapp.data.entity.Isler

@Database(entities = [Isler::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getIslerDao() : IslerDao
}