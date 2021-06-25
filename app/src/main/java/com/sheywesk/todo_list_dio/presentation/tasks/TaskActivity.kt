package com.sheywesk.todo_list_dio.presentation.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sheywesk.todo_list_dio.databinding.ActivityMainBinding
import com.sheywesk.todo_list_dio.presentation.create_todo.CreateTodoActivity
import com.sheywesk.todo_list_dio.presentation.task_list.TaskAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskActivity : AppCompatActivity() {

    private val taskViewModel: TasksViewModel by viewModel()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val taskAdapter: TaskAdapter by lazy {
        TaskAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpRecyclerView()
        setUpFabListener()
        setUpObserver()
    }
    private fun setUpRecyclerView(){
        with(binding.recyclerView){
            layoutManager = LinearLayoutManager(this@TaskActivity)
            adapter = taskAdapter
        }
    }

    private fun setUpFabListener() {
        binding.fabBtn.setOnClickListener {
            startActivity(CreateTodoActivity.getIntent(this))
        }
    }

    private fun setUpObserver(){
        taskViewModel.taskViewModel.observe(this,{
            taskAdapter.submitList(it)
        })
    }

}