package co.kr.cobosys.data.room.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.kr.cobosys.data.room.db.dto.RoomAccessToken
import kotlinx.coroutines.flow.Flow

@Dao
interface AccessTokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToken(tokenRoom: RoomAccessToken)

    @Query("SELECT * FROM access_token")
    fun getToken(): Flow<RoomAccessToken>

    @Query("DELETE FROM access_token")
    suspend fun delToken()
}