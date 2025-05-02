
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses")
     suspend fun getAllExpenses(): List<Expense>
}




