package com.example.olemsaprojectsroomdb

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.olemsaprojectsroomdb.data.User

@Entity(
    tableName = "Monthlygoals",
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE)
    ]
)
data class MonthlyGoal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val month: String, // Format: "2025-05"
    val amount: Double,
    val userId: Int
)
