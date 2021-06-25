package com.sheywesk.todo_list_dio.data.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(task: Task)

    @Query("SELECT * FROM task_table")
    fun getAllTask():LiveData<List<Task>>
}