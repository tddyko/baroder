package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.FoundMemberPwd
import kotlinx.coroutines.flow.Flow

interface FoundMemberPwdRepo {
    fun getFoundMemberPwd(): Flow<FoundMemberPwd>
}