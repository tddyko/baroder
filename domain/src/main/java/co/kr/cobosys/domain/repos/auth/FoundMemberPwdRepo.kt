package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.FoundMemberPwdModel

interface FoundMemberPwdRepo {
    fun getFoundMemberPwd(): FoundMemberPwdModel
}