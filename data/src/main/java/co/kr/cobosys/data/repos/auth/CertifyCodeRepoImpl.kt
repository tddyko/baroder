package co.kr.cobosys.data.repos.auth

import co.kr.cobosys.data.datasources.auth.CertifyCodeDataSource
import co.kr.cobosys.data.mappers.auth.CertifyCodeMapper
import co.kr.cobosys.domain.models.CertifyCodeModel
import co.kr.cobosys.domain.repos.auth.CertifyCodeRepo
import javax.inject.Inject

class CertifyCodeRepoImpl @Inject constructor(
    private val certifyCode: CertifyCodeDataSource
) : CertifyCodeRepo {
    override suspend fun getCertifyCode(phoneNum: String, duplication: String): CertifyCodeModel =

}