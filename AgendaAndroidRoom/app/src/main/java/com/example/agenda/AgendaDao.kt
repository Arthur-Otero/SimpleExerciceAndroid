package com.example.agenda

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AgendaDao {
    @Query("SELECT * FROM agenda")
    suspend fun getAll(): List<Agenda>

    @Insert
    suspend fun insert(vararg agenda: Agenda)

    @Delete
    suspend fun delete(agenda: Agenda)
}