package com.sheywesk.todo_list_dio.data.repository

import com.sheywesk.todo_list_dio.data.models.Task
import com.sheywesk.todo_list_dio.data.models.TaskDao

class TaskRepository(private val localDatasource: TaskDao) {

    val taskFromDb = localDatasource.getAllTask()
    suspend fun save(task: Task){
        localDatasource.save(task)
    }
}