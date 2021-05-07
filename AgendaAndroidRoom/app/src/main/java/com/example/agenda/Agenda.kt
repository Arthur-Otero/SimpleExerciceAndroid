package com.example.agenda

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Agenda(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo val name:String,
    @ColumnInfo val phone:String
)