package com.example.olemsaprojectsroomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.olemsaprojectsroomdb.data.AppDatabase
import com.example.olemsaprojectsroomdb.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getDatabase(application).userDao()

    fun register(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val existing = withContext(Dispatchers.IO) { userDao.getUserByUsername(username) }
            if (existing == null) {
                val user = User(username = username, password = password)
                withContext(Dispatchers.IO) { userDao.insertUser(user) }
                onResult(true)
            } else {
                onResult(false)
            }
        }
    }

    fun login(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                userDao.login(username, password)
            }
            onResult(user != null)
        }
    }
}


