package com.sheywesk.todo_list_dio.presentation.create_todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.sheywesk.todo_list_dio.R
import com.sheywesk.todo_list_dio.data.models.Task
import com.sheywesk.todo_list_dio.databinding.ActivityCreateTodoBinding
import com.sheywesk.todo_list_dio.presentation.tasks.TasksViewModel
import com.sheywesk.todo_list_dio.utils.format
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.concurrent.timer

class CreateTodoActivity : AppCompatActivity() {
    companion object {
        fun getIntent(context: Context) = Intent(context, CreateTodoActivity::class.java)
    }

    private val tasksViewModel: TasksViewModel by viewModel()
    private val binding: ActivityCreateTodoBinding by lazy {
        ActivityCreateTodoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpToolbar()
        setUpDatePicker()
        setUpTimePicker()
        setUpCancelBtn()
        setUpSaveBtn()
    }

    private fun setUpToolbar(){
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setUpTimePicker() {
        binding.time.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_24H)
                .build()
            timePicker.addOnPositiveButtonClickListener {
                binding.time.editText?.setText("${timePicker.hour}:${timePicker.minute}")
            }
            timePicker.show(supportFragmentManager, null)
        }
    }

    private fun setUpDatePicker() {
        binding.calendar.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                binding.calendar.editText?.setText(Date(it).format())
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }
    }

    private fun setUpCancelBtn() {
        binding.cancelBtn.setOnClickListener {
            finish()
        }
    }

    private fun setUpSaveBtn() {
        binding.saveBtn.setOnClickListener {
            with(binding) {
                tasksViewModel.save(
                    Task(
                        title = title.editText?.text.toString(),
                        description = description.editText?.text.toString(),
                        date = calendar.editText?.text.toString(),
                        time = time.editText?.text.toString()
                    )
                )
            }
            finish()
        }
    }
}