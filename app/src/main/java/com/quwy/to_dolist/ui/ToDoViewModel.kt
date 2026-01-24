package com.quwy.to_dolist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.quwy.to_dolist.data.Priority
import com.quwy.to_dolist.data.ToDoDatabase
import com.quwy.to_dolist.data.ToDoItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).todoDao()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    val allItems: StateFlow<List<ToDoItem>> = toDoDao.getAllItems()
        .combine(searchQuery) { items, query ->
            if (query.isBlank()) {
                items
            } else {
                items.filter { it.title.contains(query, ignoreCase = true) }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun insert(item: ToDoItem) {
        viewModelScope.launch {
            toDoDao.insert(item)
        }
    }

    fun update(item: ToDoItem) {
        viewModelScope.launch {
            toDoDao.update(item)
        }
    }

    fun delete(item: ToDoItem) {
        viewModelScope.launch {
            toDoDao.delete(item)
        }
    }
}