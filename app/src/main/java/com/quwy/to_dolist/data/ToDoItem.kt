package com.quwy.to_dolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "todo_items")
data class ToDoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val isDone: Boolean = false,
    val priority: Priority = Priority.MEDIUM
)

class PriorityConverter {
    @TypeConverter
    fun toPriority(value: String) = enumValueOf<Priority>(value)

    @TypeConverter
    fun fromPriority(value: Priority) = value.name
}