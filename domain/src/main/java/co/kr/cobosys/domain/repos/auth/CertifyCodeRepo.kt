package co.kr.cobosys.domain.repos.auth

import co.kr.cobosys.domain.models.CertifyCode
import kotlinx.coroutines.flow.Flow

interface CertifyCodeRepo {
    fun getCertifyCode(): Flow<CertifyCode>
}