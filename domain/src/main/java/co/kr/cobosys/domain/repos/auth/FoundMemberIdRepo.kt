package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.FoundMemberId
import kotlinx.coroutines.flow.Flow

interface FoundMemberIdRepo {
    fun getFoundMemberId(): Flow<FoundMemberId>
}