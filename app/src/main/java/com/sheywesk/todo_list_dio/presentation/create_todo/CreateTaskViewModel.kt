package com.sheywesk.todo_list_dio.presentation.create_todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheywesk.todo_list_dio.data.models.Task

class CreateTaskViewModel:ViewModel() {
    private val _createTask = MutableLiveData<Task>()

}