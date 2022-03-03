package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.FoundMemberPwdModel
import kotlinx.coroutines.flow.Flow

interface FoundMemberPwdRepo {
    fun getFoundMemberPwd(): Flow<FoundMemberPwdModel>
}