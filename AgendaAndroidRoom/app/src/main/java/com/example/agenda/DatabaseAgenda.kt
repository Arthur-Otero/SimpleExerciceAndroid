package com.example.agenda

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Agenda::class],version = 1)
abstract class DatabaseAgenda : RoomDatabase() {
    abstract fun agendaDao() : AgendaDao
}