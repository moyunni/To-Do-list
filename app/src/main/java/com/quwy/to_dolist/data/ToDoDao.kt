package com.quwy.to_dolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Insert
    suspend fun insert(item: ToDoItem)

    @Update
    suspend fun update(item: ToDoItem)

    @Delete
    suspend fun delete(item: ToDoItem)

    @Query("SELECT * FROM todo_items ORDER BY CASE priority WHEN 'CRITICAL' THEN 1 WHEN 'MEDIUM' THEN 2 WHEN 'LOW' THEN 3 ELSE 4 END, id DESC")
    fun getAllItems(): Flow<List<ToDoItem>>
}