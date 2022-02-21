package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.MemberInfo
import kotlinx.coroutines.flow.Flow

interface MemberInfoRepo {
    fun getMemberInfo(): Flow<MemberInfo>
}