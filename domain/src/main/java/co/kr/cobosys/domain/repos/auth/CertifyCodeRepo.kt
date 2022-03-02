package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.CertifyCodeModel
import kotlinx.coroutines.flow.Flow

interface CertifyCodeRepo {
    fun getCertifyCode(phoneNum: String, duplication: String): Flow<CertifyCodeModel>
}