package co.kr.cobosys.domain.repos.local.member

import co.kr.cobosys.domain.models.LocalMember
import kotlinx.coroutines.flow.Flow

interface LocalMemberRepo {

    suspend fun insertMember(member: LocalMember)
    fun getLocalMember(): Flow<List<LocalMember>>
    suspend fun delLocalMember()

}