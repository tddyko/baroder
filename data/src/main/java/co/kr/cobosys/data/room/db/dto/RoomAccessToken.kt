package co.kr.cobosys.data.room.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "access_token")
data class RoomAccessToken(
    @PrimaryKey
    val accessToken: String
)