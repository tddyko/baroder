package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.FoundMemberIdModel
import kotlinx.coroutines.flow.Flow

interface FoundMemberIdRepo {
    fun getFoundMemberId(): Flow<FoundMemberIdModel>
}