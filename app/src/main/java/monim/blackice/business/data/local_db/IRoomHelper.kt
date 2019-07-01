package monim.blackice.business.data.local_db

import monim.blackice.business.data.local_db.entity.User

interface IRoomHelper {
    fun roomGetAllUser(): List<User>
    fun roomGetUserById(localId: Int)
    fun roomInsertUser(users: List<User>)
    fun roomInsertUser(user: User)
    fun deleteUser(users: List<User>): Boolean
    fun deleteUser(users: User): Boolean
    fun deleteUser(): Boolean
}