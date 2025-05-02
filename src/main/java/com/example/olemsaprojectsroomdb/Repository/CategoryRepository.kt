package com.example.olemsaprojectsroomdb.Repository

import com.example.olemsaprojectsroomdb.Category
import com.example.olemsaprojectsroomdb.Dao.CategoryDao
import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val dao: CategoryDao) {

    val allCategories: Flow<List<Category>> = dao.getAllCategories()

    suspend fun insertCategory(category: Category) {
        dao.insert(category)
    }

    suspend fun deleteCategory(category: Category) {
        dao.delete(category)
    }

    suspend fun updateCategory(category: Category) {
        dao.update(category)
    }
}
