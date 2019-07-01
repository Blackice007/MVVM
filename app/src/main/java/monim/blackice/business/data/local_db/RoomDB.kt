package monim.blackice.business.data.local_db

import androidx.room.Database
import androidx.room.RoomDatabase
import monim.blackice.business.data.local_db.dao.UserDao
import monim.blackice.business.data.local_db.entity.User


@Database(entities = arrayOf(User::class) , version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun userDao(): UserDao
}