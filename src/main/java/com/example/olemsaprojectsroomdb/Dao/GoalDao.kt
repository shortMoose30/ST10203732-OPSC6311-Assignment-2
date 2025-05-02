package com.example.olemsaprojectsroomdb.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.olemsaprojectsroomdb.MonthlyGoal

@Dao
interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(goal: MonthlyGoal)}

   /* @Insert abstract suspend fun insert(goal: Goal)
    @Query("SELECT * FROM goals WHERE userId = :userId AND month = :month")
    abstract suspend fun getGoalForMonth(userId: Int, month: String): Goal?

    @Update
    suspend fun updateGoal(goal: MonthlyGoal)
}*/

