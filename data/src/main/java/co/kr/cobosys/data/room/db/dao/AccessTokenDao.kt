package co.kr.cobosys.data.room.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.kr.cobosys.data.room.db.dto.AccessToken

@Dao
interface AccessTokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToken(token: AccessToken)

    @Query("SELECT * FROM access_token")
    suspend fun getToken(): AccessToken
}