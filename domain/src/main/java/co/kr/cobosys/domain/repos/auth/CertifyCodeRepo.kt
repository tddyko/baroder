package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.CertifyCodeModel
import kotlinx.coroutines.flow.Flow

interface CertifyCodeRepo {
    suspend fun getCertifyCode(phoneNum: String, duplication: String): CertifyCodeModel
}