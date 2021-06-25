package com.sheywesk.todo_list_dio.presentation.tasks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheywesk.todo_list_dio.data.models.Task
import com.sheywesk.todo_list_dio.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TasksViewModel(private val repository: TaskRepository) : ViewModel() {
    val taskViewModel
        get() = repository.taskFromDb

    fun save(task: Task) {
        viewModelScope.launch {
            repository.save(task)
        }
    }
}