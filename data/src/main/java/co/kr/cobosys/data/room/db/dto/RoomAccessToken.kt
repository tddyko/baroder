package co.kr.cobosys.data.room.db.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "access_token")
data class RoomAccessToken(
    @PrimaryKey
    val uuid: UUID,
    @ColumnInfo(name = "accessToken")
    val accessToken: String
)