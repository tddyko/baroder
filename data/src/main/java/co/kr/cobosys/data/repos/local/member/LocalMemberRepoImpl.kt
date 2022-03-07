package co.kr.cobosys.data.repos.local.member

import co.kr.cobosys.data.datasources.local.member.LocalMemberDataSource
import co.kr.cobosys.data.mappers.local.member.toLocalMember
import co.kr.cobosys.data.mappers.local.member.toRoomMember
import co.kr.cobosys.domain.models.LocalMember
import co.kr.cobosys.domain.repos.local.member.LocalMemberRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalMemberRepoImpl @Inject constructor(
    private val localMemberDataSOurce: LocalMemberDataSource
): LocalMemberRepo {
    override suspend fun insertMember(member: LocalMember) = localMemberDataSOurce.insertMember(member.toRoomMember())

    override fun getLocalMember(): Flow<List<LocalMember>> = localMemberDataSOurce.getMember().map { data -> data.map { it.toLocalMember() } }

    override suspend fun delLocalMember() = localMemberDataSOurce.delMember()

}