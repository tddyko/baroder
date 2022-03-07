package co.kr.cobosys.data.datasources.local.member

import co.kr.cobosys.data.room.db.dao.MemberDao
import co.kr.cobosys.data.room.db.dto.RoomMember
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocalMemberDataSource {

    suspend fun insertMember(member: RoomMember)
    fun getMember(): Flow<List<RoomMember>>
    suspend fun delMember()
}

class LocalMemberDataSourceImpl @Inject constructor(
    private val dao: MemberDao
): LocalMemberDataSource {
    override suspend fun insertMember(member: RoomMember) = dao.insertMember(member)

    override fun getMember(): Flow<List<RoomMember>> = dao.getMember()

    override suspend fun delMember() = dao.deleteMember()

}