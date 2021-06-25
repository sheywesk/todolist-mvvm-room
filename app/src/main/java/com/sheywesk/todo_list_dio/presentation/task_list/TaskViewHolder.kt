package com.sheywesk.todo_list_dio.presentation.task_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sheywesk.todo_list_dio.data.models.Task
import com.sheywesk.todo_list_dio.databinding.ItemTaskBinding

class TaskViewHolder(private val item:ItemTaskBinding):RecyclerView.ViewHolder(item.root) {
    fun bind(task:Task){
        with(item){
            title.text = task.title
            description.text = task.description
            date.text = task.date
            time.text = task.time
        }
    }

    companion object {
        fun create(parent: ViewGroup): TaskViewHolder {

            val view: ItemTaskBinding = ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return TaskViewHolder(view)
        }
    }
}