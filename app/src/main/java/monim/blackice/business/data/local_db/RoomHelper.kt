package monim.blackice.business.data.local_db

import android.content.Context
import androidx.room.Room
import monim.blackice.business.data.local_db.entity.User

class RoomHelper(context: Context) : IRoomHelper {

    private var context = context
    private val db = Room.databaseBuilder(context, RoomDB::class.java, "BD_NAME").allowMainThreadQueries().build()


    override fun roomGetAllUser(): List<User> {
        return db.userDao().getAll() }

    override fun roomGetUserById(localId: Int) {
        db.userDao().getAllById(localId)
    }

    override fun roomInsertUser(users: List<User>) {
        db.userDao().insert(users)
    }

    override fun roomInsertUser(user: User) {
        db.userDao().insert(user)
    }

    override fun deleteUser(users: List<User>): Boolean {
        if(db.userDao().delete(users)>0){
            return true
        }
        return false
    }

    override fun deleteUser(users: User): Boolean {
        if(db.userDao().delete(users)>0){
            return true
        }
        return false
    }

    override fun deleteUser(): Boolean {
        if(db.userDao().delete()>0){
            return true
        }
        return false
    }
}