package co.kr.cobosys.data.room.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.kr.cobosys.data.room.db.dto.RoomMember
import kotlinx.coroutines.flow.Flow

@Dao
interface MemberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(member: RoomMember)

    @Query("SELECT * FROM member")
    fun getMember(): Flow<List<RoomMember>>

    @Query("DELETE FROM member")
    suspend fun deleteMember()
}