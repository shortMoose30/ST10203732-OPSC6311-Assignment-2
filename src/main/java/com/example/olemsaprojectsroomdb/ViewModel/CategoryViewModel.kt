package com.example.olemsaprojectsroomdb.ViewModel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.olemsaprojectsroomdb.Category
import com.example.olemsaprojectsroomdb.Repository.CategoryRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {
    val categories = repository.allCategories
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addCategory(name: String) {
        viewModelScope.launch {
            repository.insertCategory(Category(name = name))
        }

        data class Category(val name: String)

    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            repository.deleteCategory(category)
        }
    }

    fun updateCategory(category: Category) {
        viewModelScope.launch {
            repository.updateCategory(category)
        }
    }

}
