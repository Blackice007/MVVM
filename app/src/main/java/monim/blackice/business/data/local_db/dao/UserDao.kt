package monim.blackice.business.data.local_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import monim.blackice.business.data.local_db.entity.User


@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    abstract fun getAll(): List<User>

    @Query("SELECT * FROM User where localId=:localId")
    abstract fun getAllById(localId: Int): List<User>

    @Insert
    abstract fun insert(users: List<User>): List<Long>

    @Insert
    abstract fun insert(users: User)

    @Query("DELETE FROM User")
    abstract fun delete(): Int

    @Delete
    abstract fun delete(users: List<User>): Int

    @Delete
    abstract fun delete(user: User): Int
}