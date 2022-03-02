package co.kr.cobosys.data.repos.auth

import co.kr.cobosys.data.datasources.auth.CertifyCodeDataSource
import co.kr.cobosys.data.mappers.auth.toCertifyCodeModel
import co.kr.cobosys.domain.models.CertifyCodeModel
import co.kr.cobosys.domain.repos.auth.CertifyCodeRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CertifyCodeRepoImpl @Inject constructor(
    private val certifyCode: CertifyCodeDataSource
) : CertifyCodeRepo {
    override fun getCertifyCode(phoneNum: String, duplication: String): Flow<CertifyCodeModel> =
        certifyCode.certifyCode(phoneNum = phoneNum, duplication = duplication)
            .map { it.toCertifyCodeModel() }
}