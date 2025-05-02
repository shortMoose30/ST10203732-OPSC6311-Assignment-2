import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.olemsaprojectsroomdb.Category

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String,
    val startTime: String,
    val endTime: String,
    val description: String,
    val categoryId: Int
)

