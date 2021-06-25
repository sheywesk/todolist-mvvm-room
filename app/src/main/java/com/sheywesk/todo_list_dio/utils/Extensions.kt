package com.sheywesk.todo_list_dio.utils

import java.text.SimpleDateFormat
import java.util.*

val locale = Locale("pt","BR")

fun Date.format():String {
    return SimpleDateFormat("dd/MM/yyyy", locale).format(this)
}