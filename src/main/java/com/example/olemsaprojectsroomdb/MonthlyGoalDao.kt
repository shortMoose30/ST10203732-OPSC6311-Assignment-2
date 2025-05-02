package com.example.olemsaprojectsroomdb.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.olemsaprojectsroomdb.MonthlyGoal
import kotlinx.coroutines.flow.Flow

@Dao
interface MonthlyGoalDao {
    @Query("SELECT * FROM monthly_goals WHERE username = :username LIMIT 1")
    fun getGoalByUsername(username: String): Flow<MonthlyGoal?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(goal: MonthlyGoal)
}

