package com.sheywesk.todo_list_dio.di
import android.app.Application
import androidx.room.Room
import com.sheywesk.todo_list_dio.data.models.TaskDao
import com.sheywesk.todo_list_dio.data.models.TaskDatabase
import com.sheywesk.todo_list_dio.data.repository.TaskRepository
import com.sheywesk.todo_list_dio.presentation.tasks.TasksViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataBaseModules = module {

    fun provideDatabase(application: Application): TaskDatabase {
        return Room.databaseBuilder(application, TaskDatabase::class.java, "task_table")
            .build()
    }

    fun provideTaskDao(database: TaskDatabase): TaskDao {
        return database.taskDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideTaskDao(get()) }

}
val presentationModules = module {
    single { TaskRepository(get()) }
    viewModel { TasksViewModel(get()) }
}