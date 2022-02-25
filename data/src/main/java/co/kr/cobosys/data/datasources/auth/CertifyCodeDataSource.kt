package co.kr.cobosys.data.datasources.auth

import co.kr.cobosys.data.api.CertifyCodeResponseModel
import co.kr.cobosys.data.api.Request
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CertifyCodeDataSource {
    suspend fun certifyCode(phoneNum: String, duplication: String): CertifyCodeResponseModel
}

class CertifyCodeDataSourceImpl @Inject constructor(
    private val reqApi: Request
): CertifyCodeDataSource {

    override suspend fun certifyCode(phoneNum: String, duplication: String): CertifyCodeResponseModel = reqApi.requestCertifyCode(phoneNum, duplication)
}