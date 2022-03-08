package co.kr.cobosys.data.room.db.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "member")
data class RoomMember (
    @PrimaryKey
    val uuid: UUID,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "pwd")
    val pwd: String
)