package com.sheywesk.todo_list_dio.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id:Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time")
    val time: String,
)