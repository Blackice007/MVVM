package monim.blackice.business.data.local_db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "localId")  public var localId:Int = 0
    @ColumnInfo(name = "name") public var name: String? = null
    @ColumnInfo(name = "email") public var email: String? = null
    @ColumnInfo(name = "profileUrl") public var profileUrl: String? = null
}